<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">   
<script type="text/javascript" src="/cmfz_lxl/js/jquery.min.js"></script>
<script type="text/javascript" src="/cmfz_lxl/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/cmfz_lxl/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/cmfz_lxl/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="/cmfz_lxl/js/datagrid-detailview.js"></script>
<script type="text/javascript">
	<!--菜单处理-->
    $(function () {
        $.ajax({
            url:"/cmfz_lxl/menu/allMenu.do",
            type:"get",
            //返回数据若为json格式，不需再转，若不是，则要转格式
            dataType:"json",
            success:function(result){
                //遍历 结果集合 回调函数
                //--------------------下标  遍历出的元素
                $.each(result,function(index,one){
                    var c="";//-------------为取得子集的title----// console.log(one.tittle);-----下面使用块级元素，使tittle分行---点击出发方法并传参
                    //console.log(one.url);
                    $.each(one.childList,function(index2,two){
                        c += "<div><a href='#' onclick=\"addTabs('" +two.tittle + "','" + two.url + "','" + two.iconCls + "')\" class='easyui-linkbutton' data-options=\"iconCls:'"+two.iconCls+"'\">" +
                            two.tittle + "</a></div>";
                    })

                    //-----获取一级菜单----以上是二级菜单---包括了\转义符
                    console.log(c);
                    $('#aa').accordion('add', {
                        title: one.tittle,
                        content: c,
                        selected: true,
                        iconCls:one.iconCls
                    });

                })
            }


        })
    })
    function addTabs(tittle,url,iconCls){
	    var flag=$("#tt").tabs("exists",tittle);
	    if(flag){
	        $("#tt").tabs("select",tittle);//存在的话则选中
        }else{
                console.log(url);
	            $("#tt").tabs("add",{
	            title:tittle,
                selected:true,
                iconCls:iconCls,
                href:"${pageContext.request.contextPath}"+url,
                closable:true
            })
        }
    }

</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
                                <!-- EL表达式    -->
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.chiManager.name} &nbsp;
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;
            <!--  大概所有的action都加 .do  ?  -->
            <a href="/cmfz_lxl/managerAction/exit.do" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
        </div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>