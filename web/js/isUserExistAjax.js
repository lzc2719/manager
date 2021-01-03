

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



        // 进行Ajax请求和响应结果处理
        function ajaxProcess3() {
            // 创建XMLHttpRequest对象
            createXHR();

            // 获取请求数据
            var account=$("#account-text").val();
            var password=$("#password-text").val();

            // 设定请求地址
            var url = "http://localhost:8080/myproject/LoginServlet?account=" + account+"&password="+password;

            // 建立对服务器的调用
            xhr.open("get", url, true);

            // 向服务器发出请求
            xhr.send(null);

            // 指定响应事件处理函数
            xhr.onreadystatechange = function() {
                // 当 readyState 等于 4 且状态为 200 时，表示响应已就绪
                if (xhr.readyState == 4 && xhr.status == 200) {
                    // 将响应数据更新到页面控件中显示
                    var responseData=xhr.responseText;
                    if(responseData=='登录失败，账号或密码错误！'){
                        alert(responseData);
                        window.location.href="login.jsp";
                    }else{
                        alert(responseData);
                        window.location.href="homePage.jsp";
                    }
                }
            };
        }

