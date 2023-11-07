$(document).ready(function(){
  Checklogin();
  loading_cart_data();
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
        html='<label>#{username}</label><a href="/sign_out">log out</a>';
        html = html.replace(/#{username}/g, data);
        $("#check").append(html);
      }else {
        alert("login expired!");
        window.location.href="/";
      }
    }
  });
}

function deleteCartItem(cartId) {
    // Perform an AJAX request to delete the cart item using the identifier (cartItemId)
    $.ajax({
        url: '/carts/' + cartId, // Use the appropriate URL for your delete API
        type: 'DELETE',
        success: function (response) {
            // Handle the success response, e.g., remove the item from the UI
            alert('Item deleted successfully.');

            location.reload();
        },
        error: function (error) {
            // Handle errors, e.g., show an error message
            alert('Failed to delete the item.');
        }
    });
}


function loading_cart_data() {
  $("#info").empty();
  $.ajax({
    url: "/carts/" ,
    dataType: "json",
    success:function(data) {
      console.log(data);
      for(var i = 0 ;i < data.length ;i++ ){
        var producturl="product?=" + data[i].pid;
        var num=data[i].num;
        var title=data[i].title;
        var price=data[i].price;
        var cid = data[i].cid;

        var html=
    '<div class="row">'+
      '<div class="col-3">'+
        '<div class="title">#{title}</div>'+
        '<div class="img">#{img}</div>'+
      '</div>'+
      '<div class="col-2">item price'+
        '<div class="price">#{price}</div>'+
      '</div>'+
     '<div class="col-3">num'+
        '<div class="num" id="num">#{num}</div>'+
      '</div>'+
      '<div class="col-2">total'+
        '<div class="totalprice">#{total}</div>'+
      '</div>'+
      '<div class="col-2">'+
        '<button class="btn btn-danger" onclick="deleteCartItem(#{cid})">Delete</button>'+
      '</div>'+
    '</div>';

        html = html.replace(/#{title}/g, title);
        html = html.replace(/#{price}/g, price);
        html = html.replace(/#{num}/g, num);
        html = html.replace(/#{total}/g, num*price);
        html = html.replace(/#{cid}/g, cid);

        $("#info").append(html);

      }
    }
  });
}