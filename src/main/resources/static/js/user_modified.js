$(document).ready(function(){
  Checklogin();
});

var username=" ";
var userdataurl ="/users/";
var puturl="";

function Checklogin() {
  $.ajax({
    url: "/users/session-username",
    dataType: "text",
    success:function(data) {
      //console.log(data);


        // empty the login/register html
        $("#check").empty();
        var html;
        html='<label>#{username}</label><a href="/sign_out">log out</a>';
        html = html.replace(/#{username}/g, data);
        $("#check").append(html);

        // In addition to the username to write down the display, and put into the js variable, other functions will use
        username=data;
        //And set the api URL for querying user data.
        userdataurl=("/users/"+data);
         //After verifying that you are logged in, go to the following function to load the user data
        loading_user_data();
    },error:function(){
        alert("error, haven't login, redirect to home page");
        window.location.href=("/");
      }
  });
}


$(document).on("click",'#modified',function(){
  if(username == " "){
    alert("havn't login");
  }else{

    window.location.href ="/users/@"+ username;
  }
});


function loading_user_data() {
  $.ajax({
    url: userdataurl,
    dataType: "json",
    success:function(data) {
      console.log(data);
      $("#username").empty();
      var html ='<div class="title">Username</div>'
          +'<input name="username" value="#{username}" required="required" disabled="disabled"/>'
          +'<button id="edit" type="button">edit </button>';
      html = html.replace(/#{username}/g, data[0].username);
      $("#username").append(html);
      //---------------------------------------//
      $("#phone").empty();
      var html ='<div class="title">phone</div>'
          +'<input name="phone" value="#{phone}" required="required" disabled="disabled"/>'
          +'<button id="edit" type="button">edit </button>';
      html = html.replace(/#{phone}/g, data[0].phone);
      $("#phone").append(html);
      //---------------------------------------//
      $("#email").empty();
      var html ='<div class="title">email</div>'
          +'<input name="email" value="#{email}" required="required" disabled="disabled"/>'
          +'<button id="edit" type="button">Edit </button>';
      html = html.replace(/#{email}/g, data[0].email);
      $("#email").append(html);
      //---------------------------------------//
      if(data[0].gender == "1"){
        $("input[name=gender][value='1']").attr('checked',true);
      }else{
        $("input[name=gender][value='0']").attr('checked',true);
      }
      //---------------------------------------//
      puturl="/users/"+data[0].uid;
    }
  });
}

$(document).on("click",'#edit',function(){
  $(this).prev().attr('disabled', false);
});



$("#save").click(function () {

  var username = $("input[name='username']").val();
  var phone = $("input[name='phone']").val();
  var email = $("input[name='email']").val();
  var gender = 0;
  gender=$("input[name='gender']:checked").val();

  $.ajax({
    url: puturl,
    type: "put",
    contentType:"application/json;charset=UTF-8",
    data:JSON.stringify({"username":username,"gender":gender,"phone":phone,"email":email}),

    success:function(res) {
      alert("Data Modification Successful");
    }
  });

});