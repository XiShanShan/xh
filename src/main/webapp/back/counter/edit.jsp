<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {

    })
</script>


    <div style="text-align: center;">
        <form id="editCounterInputForm" class="easyui-form" method="post">
            <input  name="id"  class="easyui-textbox" type="hidden" value="${param.id}"/>
            <div style="margin-top: 70px;">
                计数器名: <input type="text" name="title" class="easyui-textbox" data-options="required:true,validType:'uname'">
            </div>

            <div style="margin-top: 20px;">
                数字: <input type="text" name="count"  class="easyui-textbox">
            </div>

            <div style="margin-top: 20px;">
                时间: <input type="text" name="date"  class="easyui-datebox">
        </div>

        </form>
    </div>
