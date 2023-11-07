$(document).ready(function(){
  showHotList();
  Checklogin();
});

function showHotList() {
  $("#hot-list").empty();
  $.ajax({
    url: "/products/list/hot",
    dataType: "json",
    success:function(data) {
      hotlist=data;
      console.log(hotlist);
      for (var i = 0; i < hotlist.length; i++) {
        var html ='<div class="content col-md-2">'
            +'<div class="title">#{title}</div>'
            +'<div class="price">$#{price}</div><a class="d-flex justify-content-end" href="#{href}">Explore Product</a>'
            +'</div>';
        html = html.replace(/#{title}/g, hotlist[i].title);
        html = html.replace(/#{price}/g, hotlist[i].price);
        html = html.replace(/#{href}/g, "/product?id=" + hotlist[i].id);

        $("#hot-list").append(html);
      }
    }
  });
}

var username=" ";

function Checklogin() {
  $.ajax({
    url: "/users/session-username",
    dataType: "text",
    success:function(data) {
      console.log(data);
        var html;
        html='<span class="separator"></span><label>#{username}</label><a href="/sign_out">log out</a>';
        html = html.replace(/#{username}/g, data);
        $("#check").append(html);
        username=data;
    },error:function (){

    }
  });
}

//When checklogin() in the page, it will set the value of js variable username according to the login or not, if it is not set, it means there is no login, //so it will block the feedback when you press the modify data hyperlink button.
//So when you press the hyperlink button to modify the data, it will block the feedback.
$(document).on("click",'#modified',function(){
  if(username == " "){
    alert("haven't login");
  }else{
    window.location.href ="/users/@"+ username;
  }
});