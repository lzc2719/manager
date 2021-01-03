


    // 定义一个全局的XMLHttpRequest对象
    var xhr = false;

    // 创建XMLHttpRequest对象
    function createXHR() {
        try {
            // 适用于IE7+, Firefox, Chrome, Opera, Safari
            xhr = new XMLHttpRequest();
        } catch (e) {
            try {
                // 适用于IE6, IE5
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e1) {
                xhr = false;
            }
        }
        if (!xhr)
            alert("初始化XMLHttpRequest对象失败！");
    }


    //判断是否登录，如果没登录则提示使用者先登录
    function updateComment(loginState,movieId,commentUser,commentDate,index) {
        if (loginState==""||loginState=='false'){
            document.getElementById("comment-text"+index).value="";
            alert('Failure! please login first')
        }else {
            ajaxProcess(movieId,commentUser,commentDate,index)
        }
    }


    // 进行Ajax请求和响应结果处理
    function ajaxProcess(movieId,commentUser,commentDate,index) {

        // 创建XMLHttpRequest对象
        createXHR();

        // 获取请求数据
        var commentText=$("#comment-text"+index).val();

        // 设定请求地址
        var url = "http://localhost:8080/myproject/MovieCommentServlet?"
            +"movieId="+movieId
            +"&commentUser="+commentUser
            +"&commentDate="+commentDate
            +"&commentText="+commentText;

        // 建立对服务器的调用
        xhr.open("get", url, true);

        // 向服务器发出请求
        xhr.send(null);

        // 指定响应事件处理函数
        xhr.onreadystatechange = function () {
            // 当 readyState 等于 4 且状态为 200 时，表示响应已就绪
            if (xhr.readyState == 4 && xhr.status == 200) {
                var responseData=xhr.responseText;
                $("#comment-text"+index).val("");
                alert(responseData);
            }
        };
    }
