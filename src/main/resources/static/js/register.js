var apiurl={
    registerurl:"/register",
    registersuccess:"/"
}

$("#sub").click(function () {

    var username = $("#username").val();
    var password = $("#password").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    var gender = 0;
    gender=$("input[name='gender']:checked").val();

    $.post({
        url:apiurl.registerurl,
        contentType:"application/json;charset=UTF-8",
        data:JSON.stringify({"username":username,"password":password,"gender":gender,"phone":phone,"email":email}),

      success:function(res) {
            alert("register_success");
            window.location.href = apiurl.registersuccess; // switch the page
        }
    });

});