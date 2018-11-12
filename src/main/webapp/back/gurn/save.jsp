<%@page pageEncoding="UTF-8" isELIgnored="false" %>

    <div style="text-align: center;">
        <form id="saveGurnInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
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