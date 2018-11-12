<%@page pageEncoding="UTF-8" isELIgnored="false" %>

    <div style="text-align: center;">
        <form id="saveCourseInputForm" class="easyui-form" method="post">
            <div style="margin-top: 70px;">
                功课名: <input type="text" name="title" class="easyui-textbox" data-options="required:true,validType:'uname'">
            </div>

            <div style="margin-top: 20px;">
                功课标记: <input type="text" name="marking"  class="easyui-textbox">
            </div>

            <div style="margin-top: 20px;">
                功课时间: <input type="text" name="createDate"  class="easyui-datebox">
            </div>



</form>
    </div>