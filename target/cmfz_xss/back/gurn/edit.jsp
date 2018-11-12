<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {

    })
</script>

    <div style="text-align: center;">
        <form id="GurnInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
            <input  name="id"  class="easyui-textbox" type="hidden" value="${param.id}"/>
            <div style="margin-top: 70px;">
              上师名: <input type="text" name="name" class="easyui-textbox" data-options="required:true,validType:'uname'">
            </div>

            <div style="margin-top: 20px;">
            上师头像: <input type="text" name="file"  class="easyui-filebox" data-options="required:true,buttonAlign:'left'">
            </div>
            <div style="margin-top: 20px;">
             上师性别: <input type="text" name="gender"  class="easyui-textbox">
            </div>
        </form>
    </div>
