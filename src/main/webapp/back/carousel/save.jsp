<%@page pageEncoding="UTF-8" isELIgnored="false" %>

    <div style="text-align: center;">
        <form id="saveCarouseltInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
            <div style="margin-top: 70px;">
                标题: <input type="text" name="title" class="easyui-textbox" data-options="required:true,validType:'uname'">
            </div>

            <div style="margin-top: 20px;">
                图片: <input type="text" name="file"  class="easyui-filebox" data-options="required:true,buttonAlign:'left'">
            </div>

            <div style="margin-top: 20px;">
               状态: <input type="text" name="status"  class="easyui-textbox">
            </div>
            <div style="margin-top: 20px;">
               轮播顺序: <input type="text" name="order"  class="easyui-textbox">
            </div>
            <div style="margin-top: 20px;">
                修改日期: <input type="text" name="createDate"  class="easyui-datebox">
            </div>

</form>
    </div>