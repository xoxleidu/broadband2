layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate','element'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
    	element = layui.element;
		$ = layui.jquery;


    ///product/product/findProductById

	//页面初始化
    var serverPath = "http://localhost:8080/broadband";
    var productData ="";
	var findProductBase = {
        "currentPage": 1,
        "pageSize": 50
    };

    $.ajax({
        type: "post",
        url: serverPath + "/product/product/findProductBase",
        data: JSON.stringify(findProductBase),
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function(res){
            productData = res.result.records;
            //var productData = res.result;
            productList(productData);
        },
        error: function (e) {
            alertConsole(e);
        }
    })

    function productList(productData){

        var dataHtml = '';
        for(var i=0;i<productData.length;i++){
            dataHtml += '<input name="product" id="'
                + productData[i].id
                + '" title="'
                + productData[i].name
                + '"type="radio">';
        }
        $(".product_content").html(dataHtml);
        form.render();
    }

    //提交个人资料
    form.on("submit(addProduct)",function(data){
        var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
        //将填写的用户信息存到session以便下次调取
        var key,userInfoHtml = '';
        userInfoHtml = {
            'address' : $("#address").val(),
            'sex' : data.field.sex,
            'contactMobile' : $("#contactMobile").val(),
            'contacts' : $("#contacts").val(),
            'idcard' : $("#idcard").val(),
            'mobile' : $("#mobile").val(),
            'name' : $("#name").val(),
            'tel' : $("#address").val(),
            'type': 0
        };
        /*for(key in data.field){
            if(key.indexOf("like") != -1){
                userInfoHtml[key] = "on";
            }
        }*/
        //window.sessionStorage.setItem("userInfo",JSON.stringify(userInfoHtml));

        $.ajax({
            type: "post",
            url: "http://localhost:8080/broadband/customer/customerMessage/add",
            data: JSON.stringify(userInfoHtml),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (data) {
                /*if (data.flag === 1) {
                    kenWindowClose(true);
                    var callback = eval("window.parent.LoadData1");
                    callback("操作成功！");
                }
                else {
                    GysAlert({
                        content: data.message
                    });
                }*/

                setTimeout(function(){
                    layer.close(index);
                    layer.msg("提交成功！");
                },2000);
            },
            error: function (e) {
                alertConsole(e);
            }
        });


        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    })
	
})
