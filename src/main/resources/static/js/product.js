var username=" ";
var producturl="/products/" + window.location.search;
var pid="";

console.log(producturl);


$(document).ready(function(){
  Checklogin();
  loading_product_data();
});


function Checklogin() {
  $.ajax({
    url: "/users/session-username",
    dataType: "text",
    success:function(data) {
      console.log(data);
      if(data != ""){
        $("#check").empty();
        var html;
        html='<label>#{username}</label><a href="/sign_out">log out!</a>';
        html = html.replace(/#{username}/g, data);
        $("#check").append(html);
      }else {
      }
    }
  });
}



function loading_product_data() {
  $.ajax({
    url: producturl,
    dataType: "json",
    success:function(data) {
      console.log(data);
      $("#itemname").text(data.title);
      $("#price").text("$" + data.price);
      $("#num").text("remain：" + data.num);
      $("#productImage").attr("src", data.imagepath);


      pid=data.id;

      if(data.status == 0){
        alert("out of stock");
      }
    }
  });
}

$(document).on("click",'#dec',function(){

  var num = parseInt($("input[name=productnum]").val());
  if(num==1){
    alert("minimum!!")
  }else{
    $("input[name=productnum]").val(num-1);
  }

});

$(document).on("click",'#inc',function(){
  var num = parseInt($("input[name=productnum]").val());
  $("input[name=productnum]").val(num+1);
});



$(document).on("click", '#addtocart', function () {
    // Check if the user is logged in
    if (username != null) {
        // User is logged in, make the AJAX request to add the item to the cart
        $.ajax({
            url: "/carts/addcart",
            data: { "pid": pid, "amount": $("input[name=productnum]").val() },
            type: "post",
            dataType: "json",
            success: function (response) {
                console.log(response)
                if (response.status === '200') {
                    // Request is successful
                    alert("Add successfully");
                    // Redirect to another page
                    window.location.href = "/mycarts";
                } else {
                    // Request is not successful, handle the error
                    alert("Failed to add item to the cart. " + response.message);
                }
            },
            error: function (xhr, status, error) {
                // Request failed, handle the error
                alert("Failed to make the request. Status code: " + xhr.status + " Error: " + error);
            }
        });
    } else {
        // User is not logged in, display an alert
        alert("Please log in before adding items to your cart.");
    }
});

//$(document).on("click", '#addtocart', function () {
//    // Check if the user is logged in
//    if (username!=null) {
//        // User is logged in, make the AJAX request to add the item to the cart
//        $.ajax({
//            url: "/carts/addcart",
//            data: { "pid": pid, "amount": $("input[name=productnum]").val() },
//            type: "post",
//            dataType: "json",
//            success: function (res) {
//                alert("Add successfully");
//                if (res != "") {
//                    alert("Add successfully");
//                } else {
//                    alert("Failed to add item to the cart");
//                }
//            }
//        });
//    } else {
//        // User is not logged in, display an alert
//        alert("Please log in before adding items to your cart.");
//    }
//});