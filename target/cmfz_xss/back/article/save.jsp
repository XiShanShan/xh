<%@page pageEncoding="UTF-8" isELIgnored="false" %>

    <div style="text-align: center;">
        <form id="saveArticleInputForm" class="easyui-form" method="post">
            <div style="margin-top: 70px;">
                标题: <input type="text" name="title" class="easyui-textbox" data-options="required:true,validType:'uname'">
            </div>

            <div style="margin-top: 20px;">
               内容: <input type="text" name="status"  class="easyui-textbox">
            </div>
            <div style="margin-top: 20px;">
            所属上师: <input type="text" name="order"  class="easyui-textbox">
            </div>
            <div style="margin-top: 20px;">
             发布日期: <input type="text" name="createDate"  class="easyui-datebox">
            </div>

</form>
    </div>