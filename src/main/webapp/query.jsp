<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function(){
           $.ajax({
               url:"${pageContext.request.contextPath}/pro/queryAll",
               type:"get",
               dataType:"json",
               success:function(data) {
                   $.each(data,function (index, pro) {
                       /*text 填充的内容  val为其添加一个属性*/
                       var nameOpt=$("<option>").text(pro.name).val(pro.code);
                       $("#province").append(nameOpt)
                   });
                   $("#province").change();
            }
           })

            $("#province").change(function () {
                var provinceCode=$("#province").val();
                $.ajax({
                    url:"${pageContext.request.contextPath}/pro/queryByProvince",
                    data:{"provinceCode":provinceCode},
                    type:"post",
                    dataType:"json",
                    success:function (data) {
                        $("#dao").empty();
                        $.each(data,function (index,city) {
                            var opt=$("<option>").val(city.code).text(city.name);
                            $("#dao").append(opt)
                        });
                        $("#dao").change();
                    }
                })
            });
            $("#dao").change(function () {
                var cityCode=$("#dao").val();
                //根据市的code查询该市下的所有区
                $.ajax({
                    url:"${pageContext.request.contextPath}/pro/queryByCity",
                    type:"post",
                    data:{"cityCode":cityCode},
                    dataType:"json",
                    success:function (data) {
                        $("#area").empty();
                        $.each(data,function (index,area) {
                            var opt=$("<option>").text(area.name);
                            $("#area").append(opt)
                        })
                    }
                })
            })
        })
    </script>
</head>
<body>
省<select id="province"></select>
市<select id="city"></select>
区<select id="area"></select>
</body>
</html>