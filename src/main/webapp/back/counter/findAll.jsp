<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#counter").datagrid({
            url:'${pageContext.request.contextPath}/counter/findAll',
            pagination:true,
            toolbar:[
                {
                    text:'添加计数器',
                    iconCls:'icon-add',
                    handler:function () {
                        $("#saveCounterDialog").dialog({
                            buttons:[
                                {
                                    text:'保存',
                                    iconCls:'icon-save',
                                    handler:function () {
                                        //保存用户信息
                                        $("#saveCounterInputForm").form('submit',{
                                            url:'${pageContext.request.contextPath}/counter/save',
                                            success:function (result) {//响应的一定是json格式字符串   使用应该先转为js对象
                                                //提示信息
                                                $.messager.show({title:'提示',msg:'功课添加成功！'});
                                                //关闭对话框
                                                $("#savecounter").dialog('close');
                                                //刷新datagrid
                                                $("#counter").datagrid('reload');
                                            }
                                        });
                                    }
                                },{
                                    iconCls:'icon-cancel',
                                    text:'关闭',
                                    handler:function () {
                                        $("#saveCounterDialog").dialog('close');
                                    }
                                }
                            ]
                        });
                    }
                },
                {
                    text:'批量删除',
                    iconCls:'icon-remove',
                    handler:function (){
                        var rows = $("#counter").datagrid('getSelections');
                        if (rows.length<0){
                            $.messager.show({title:'提示',msg:'至少选一行'});
                        }else{
                            var ids = [];
                            for (var i = 0; i < rows.length ; i++) {
                                ids.push(rows[i].id);
                            }
                            //发送ajax请求传递数组  注意: $.get $.post 只能传递简单数据(key=value) 不能数组类型的数据
                            //如果想要传递数组类型的数据只能使用  $.ajax 并且还要设置其中的一个属性
                            $.ajax({
                                url:'${pageContext.request.contextPath}/counter/deleteAll',
                                type:'POST',
                                traditional:true,//传递数据类型的数据时必须设置这个属性为true
                                data:{id:ids},
                                success:function(result){
                                    //消息提示
                                    $.messager.show({title:'提示',msg:"删除成功!!!"});
                                    //刷新datagrid
                                    $("#counter").datagrid('reload');
                                },
                                error:function(){
                                    //消息提示
                                    $.messager.show({title:'提示',msg:"删除失败!!!"});
                                    //刷新datagrid
                                    $("#counter").datagrid('reload');
                                }
                            })
                        }
                    }
                }
            ],
            columns:[[
                {title:"cks",field:"cks",checkbox:true},
                {title:'计数器id',field:'id',width:120,},
                {title:'计数器名',field:'title',width:120,},
                {title:'数字',field:'count',width:120,},
                {title:'时间',field:'date',width:120,},
                {title:'操作',field:'options',width:120,
                    formatter:function (value,row,index) {
                        return "<a href='javascript:;' class='del' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;" +
                            "<a href='javascript:;' class='del' onclick=\"editRow('"+row.id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">修改</a>";
                    }
                }
            ]],
            onLoadSuccess:function () {
              $('.del').linkbutton();
            }
        });
    });

    //删除一行的数据
    function delRow(id) {
        //获取当前点击删除 发送到ajax请求删除的 id的信息
        $.post("${pageContext.request.contextPath}/counter/delete",{"id":id},function (result) {//响应成功后回调
            //刷新datagrid的值
            $("#counter").datagrid('reload');
        });
    }
    //修改一行的数据
    function editRow(id) {
        $("#editCounterDialog").dialog({
            href:'${pageContext.request.contextPath}/back/counter/edit.jsp?id='+id,
                buttons:[
                {
                    iconCls:'icon-save',
                    text:'修改',
                    handler:function () {
                        $("#editCounterInputForm").form('submit',{
                            url:'${pageContext.request.contextPath}/counter/update',
                            success:function (result) {//注意一定是json字符串  使用需要转为js对象
                                //关闭dialog
                                $("#editCounterDialog").dialog('close');
                                //刷新datagrid
                                $("#counter").datagrid('reload');//刷新当前datagrid
                                //提示修改信息
                                $.messager.show({title:'提示',msg:"功课信息修改成功!!!"});
                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:'取消',
                    handler:function () {
                        $("#editCounterDialog").dialog('close');
                    }
                }
            ],
        });
    }
</script>
<table id="counter" class="easyui-datagrid" data-options="fit:true"></table>

<%--添加用户对话框--%>
<div id="saveCounterDialog" data-options="href:'${pageContext.request.contextPath}/back/counter/save.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'添加计数器'">

    <%--修改用户对话框--%>
    <div id="editCounterDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'修改计数器信息'">
    </div>
