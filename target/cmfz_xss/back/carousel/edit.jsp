<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        //console.log("${param.id}");
        //$("#editForm").form('load','${pageContext.request.contextPath}/carousel/queryOne?id=${param.id}'); //{"id":"21","name":"小黑"}
    })
</script>
<form class="easyui-form" id="editForm">

    <div style="text-align: center;">
        <form id="saveCarouseltInputForm" class="easyui-form" method="post">
            <input  name="id"  class="easyui-textbox" type="hidden" value="${param.id}"/>
            <div style="margin-top: 70px;">
              标题: <input type="text" name="title" class="easyui-textbox" data-options="required:true,validType:'uname'">
            </div>

            <div style="margin-top: 20px;">
              图片展示状态: <input type="text" name="status"  class="easyui-textbox">
            </div>
            <div style="margin-top: 20px;">
              轮播顺序: <input type="text" name="order"  class="easyui-textbox">
            </div>
        </form>
    </div>
</form>