<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%
    if (session.getAttribute("adminName") == null) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <%--<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/metro-blue/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/datagrid-detailview.js"></script>
    <%--<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>--%>
<script type="text/javascript">
	<!--菜单处理-->
    $(function () {
        $.post("${pageContext.request.contextPath}/menu/findAll",function(menu) {
            $.each(menu, function (index, m) {
                var content = "<div style='text-align:center;'>";
                $.each(m.lists, function (idx, child) {
                    content += "<a onclick=\"addTabs('" + child.title + "','" + child.iconCls + "','" + child.href + "')\" style='width:95%;margin:10px 0px; border: 2px #00ee00 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'" + child.iconCls + "'\">" + child.title + "</a><br>";
                });
                content += "</div>"
                $("#menu").accordion('add', {
                    title: m.title,
                    iconCls: m.iconCls,
                    content: content,
                })
            });
        });
    });
    //点击菜单追加选项卡
    function addTabs(title,iconCls,href){
        //添加以前先判断tabs中是否存在这个选项卡
        if(!$("#tabs").tabs('exists',title)){
            $("#tabs").tabs('add',{
                title:title,
                iconCls:iconCls,
                closable:true,
                fit:true,
                href:"${pageContext.request.contextPath}/"+href,
            });
        }else{
            $("#tabs").tabs('select',title);
        }

    }
    //打开修改密码的对话框
    function openEditAdminDialog() {
        $("#editAdminDialog").dialog({
            href: '${pageContext.request.contextPath}/back/admin/edit.jsp',
            buttons: [
                {
                    iconCls: 'icon-save',
                    text: "保存",
                    handler: function () {
                        $("#editAdminInputForm").form('submit', {
                            url: "${pageContext.request.contextPath}/Admin/update",
                            success: function (result) {//注意一定是json字符串 使用需要转为js对象
                                var resultObj = $.parseJSON(result);
                                if(resultObj.success){
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"管理员密码修改成功!!!"});
                                }else{
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"密码输入有误,修改密码失败!!!"});
                                }
                                //关闭dialog
                                $("#editAdminDialog").dialog('close');
                            }
                        })
                    }
                },
                {
                    iconCls: 'icon-cancel',
                    text: "取消",
                    handler: function () {
                        $("#editAdminDialog").dialog('close');
                    }
                },
            ]
        });
    }


</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;

    	padding-top:15px">欢迎您:${sessionScope.adminName} &nbsp;


            &nbsp;<a href="javaScript:;" class="easyui-linkbutton" data-options="iconCls:'icon-edit'"
                     onclick="openEditAdminDialog()">修改密码</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/Admin/exit" class="easyui-linkbutton"
               data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 习闪闪最美</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);
		    background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>

    <%-- 修改密码按钮 --%>
    <div id="editAdminDialog" data-options="width:450,height:300,iconCls:'icon-edit',title:'修改密码'"></div>
</body> 
</html>