<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/1 0001
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function() {
        var url = "/getAllInformationHandler";
        $.ajax({
            url: url,
            type: 'POST',
            dataType: 'JSON',
            success: function(data) {

                    $('.tbody').append(`
                        <tr>
                            <td>
                                <div class="image"><a href="details.html?id=${data.content[i].id}"><img src="${fn1()}"></a></div>
                            </td>
                            <td>${arr1[data.content[i].nature]}</td>
                            <td>${data.content[i].repostNumber}</td>
                            <td class="phoneBrand"><span title="iPone">${arr2[data.content[i].phoneBrand]}</span></td>
                            <td>${fn2()}</td>
                            <td>${data.content[i].imei}</td>
                            <td>${data.content[i].characteristic}</td>
                            <td>${data.content[i].userName}</td>
                            <td>${data.content[i].phone}</td>
                            <td>${data.content[i].wechat}</td>
                            <td><a href="details.html?id=${data.content[i].id}">详情</a>
                            </td>
                         </tr>
                        `);
                }

                $('.M-box').pagination({
                    pageCount:data.totalPages,
                    coping:true,
                    homePage:'首页',
                    endPage:'末页',
                    prevContent:'上页',
                    nextContent:'下页',
                    current:1,
                    callback:function (api) {
                        $.ajax({
                            url:url,
                            type:'POST',
                            data:{
                                currentPage:api.getCurrent()-1
                            },
                            success:function (data) {
                                function fn1() {
                                    if(data.content[i].photo!=""&&data.content[i].photo!=null){
                                        return `${data.content[i].photo}`;
                                    }else{
                                        return 'images/defPic.jpg';
                                    }
                                }
                                function fn2(){
                                    if(data.content[i].phoneVersion!=""&&data.content[i].phoneVersion!=null){
                                        return  `${data.content[i].phoneVersion}`;
                                    }else{
                                        return '其他';
                                    }
                                }
                                //console.log(data);
                                $('.tbody').html(``);
                                var arr1=['盗','抢','丢','其他'];
                                var arr2=['苹果','三星','华为','小米','魅族','LG','索尼','OPPO','美图','努比亚','360','中兴','HTC','锤子','一加','酷派','黑莓','金立','诺基亚','其他'];
                                for(var i=0;i<data.content.length;i++){
                                    $('.tbody').append(`
                                        <tr>
                                            <td>
                                                <div class="image"><a href="details.html?id=${data.content[i].id}"><img src="${fn1()}"></a></div>
                                            </td>
                                            <td>${arr1[data.content[i].nature]}</td>
                                            <td>${data.content[i].repostNumber}</td>
                                            <td class="phoneBrand"><span title="iPone">${arr2[data.content[i].phoneBrand]}</span></td>
                                            <td>${fn2()}</td>
                                            <td>${data.content[i].imei}</td>
                                            <td>${data.content[i].characteristic}</td>
                                            <td>${data.content[i].userName}</td>
                                            <td>${data.content[i].phone}</td>
                                            <td>${data.content[i].wechat}</td>
                                            <td><a href="details.html?id=${data.content[i].id}">详情</a>
                                            </td>
                                         </tr>
                                        `);
                                }
                            },
                            error:function () {
                                alert("没有找到对应结果！");
                            }
                        })
                    }
                });

            },
            error:function () {
                alert("没有找到对应结果！");
            }
        });




    });

</script>
</body>
</html>
