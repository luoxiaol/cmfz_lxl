<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-edit',
        text: "专辑详情",
        handler: function () {
            var row = $("#album_dg").treegrid("getSelected")
            if (row == null) {
                alert("请先选中行！！！")
            } else {
                if (row.ssize == null) {
                    $("#desc_dialog").dialog("open")
					/*填充内容*/
                    $("#desc_form").form("load", row);
                    $("#coverImg").prop("src", row.coverImg);
                } else {
                    alert("请先选专辑！！！")
                }
            }
            //获取专辑


        }
    }, '-', {
        iconCls: 'icon-help',
        text: "添加专辑",
        handler: function () {
            $("#addAlbum_dialog").dialog("open");
        }
    }, '-', {
        iconCls: 'icon-help',
        text: "添加章节",
        handler: function () {
            var row = $("#album_dg").treegrid("getSelected");
            if (row == null) {
                alert("请先选中行！！！")
            } else {
                if (row.ssize == null) {
                    $("#section_dialog").dialog("open");
                    $("#album_id").textbox("setValue", row.id);
                } else {
                    alert("请先选专辑！！！")
                }
            }

        }
    }, '-', {
        iconCls: 'icon-help',
        text: "下载音频",
        handler: function () {
            var row = $("#album_dg").treegrid("getSelected");
            location.href = "${pageContext.request.contextPath}/section/down.do?url=" + row.downPath + "&title=" + row.title;
        }
    }]

    $(function(){
		$('#album_dg').treegrid({
			url:'/cmfz1/album/show.do',
			idField:'id',
			treeField:'title',
            onDblClickRow:function (row) {
                if (row == null) {
                    alert("请先选中行！！！")
                } else {
                    if (row.downPath != null) {
                        $("#album_paly").dialog("open");
                        $("#audio").prop("src", row.downPath)
                    } else {
                        alert("请先选妙音！！！")
                    }
                }


			},
			toolbar:toolbar,
            fit: true,
            fitColumns: true,
            columns: [[
                {field: 'title', title: '名称', width: 60, align: 'right',align:'center'},
                {field: 'ssize', title: '大小', width: 80,align:'center'},
                {field: 'duration', title: '时长', width: 80,align:'center'},
                {field: 'status', title: '状态', width: 80,align:'center'},
                {field: 'uploadDate', title: '上传时间', width: 100,align:'center'},
                {field: 'downPath', title: '下载路径', width: 150,align:'center'}
            ]]
		});


    })

</script>
<table id="album_dg"></table>

<div id="desc_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:600px;"
	 data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
	<form id="desc_form" method="post">
		<div>
			<label for="title">名称:</label>
			<input class="easyui-validatebox" id="title" type="text" name="title"  class="easyui-validatebox"  style="width:60%;height: 60%"/>
		</div>
		<div>
			<label for="coverImg">封面:</label>
			<img id="coverImg" src="" type="text"  class="easyui-validatebox"  style="width:60%;height: 60%">
		</div>
		<div>
			<label for="acount">集数:</label>
			<input class="easyui-validatebox" type="text" id="acount" name="acount"  class="easyui-validatebox"  style="width:60%;height: 60%"/>
		</div>
		<div>
			<label for="score">评分:</label>
			<input class="easyui-validatebox" type="text" id="score" name="score"  class="easyui-validatebox"  style="width:60%;height: 60%"/>
		</div>
		<div>
			<label for="author">作者:</label>
			<input class="easyui-validatebox" type="text" id="author" name="author" class="easyui-validatebox"  style="width:60%;height: 60%"/>
		</div>
		<div>
			<label for="broadCast">播音:</label>
			<input class="easyui-validatebox" type="text" id="broadCast" name="broadCast"  class="easyui-validatebox"  style="width:60%;height: 60%"/>
		</div>
		<div>
			<label for="publishDate">发布日期:</label>
			<input class="easyui-validatebox" type="text" id="publishDate" name="publishDate"   class="easyui-validatebox"  style="width:60%;height: 60%"/>
		</div>
		<div>
			<label for="brief">简介:</label>
			<input class="easyui-validatebox" type="text" id="brief" name="brief" type="text"  class="easyui-validatebox"  style="width:60%;height: 60%"/>
		</div>
	</form>
</div>

<div id="section_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
	 data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                  $('#section_form').form('submit',{
                  		url:'${pageContext.request.contextPath}/section/add.do',
                  		success:function(data){
                  			$('#section_dialog').dialog('close');
							$('#album_dg').treegrid('reload')

                  		}
                  })
				}
			},{
				text:'关闭',
				handler:function(){
                    $('#section_dialog').dialog('close');
				}
			}]">

	<form id="section_form" method="post" enctype="multipart/form-data">
		<div>
			<label for="album_id">aid:</label>
			<input class="easyui-textbox" value="0" name="aid" id="album_id"/>
		</div>
		<div>
			<label for="section_title">章节名称:</label>
			<input class="easyui-textbox" name="title" id="section_title"/>
		</div>
		<div>
			<label for="section_status">状态:</label>
			<input class="easyui-textbox" name="status" id="section_status"/>
		</div>
		<div>
			<label for="section_ssize">大小:</label>
			<input class="easyui-textbox" name="status" id="section_ssize"/>
		</div>
		<div>
			<label for="section_duration">时长:</label>
			<input class="easyui-textbox" name="status" id="section_duration"/>
		</div>
		<div>
			<label for="section_file">上传:</label>
			<input class="easyui-filebox" id="section_file" name="section_file"/>
		</div>
	</form>
</div>

<div id="addAlbum_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
	 data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
					$('#album_form').form('submit',{
					  url:'${pageContext.request.contextPath}/album/add.do',
					  success:function(data){
			 				$('#addAlbum_dialog').dialog('close');
							$('#album_dg').treegrid('reload');//更新数据
					  }
					})
				}
			},{
				text:'关闭',
				handler:function(){
                    $('#addAlbum_dialog').dialog('close');
				}
			}]">

	<form id="album_form" method="post" enctype="multipart/form-data">
		<div>
			<label for="album_title">专辑名称:</label>
			<input class="easyui-textbox" name="title" id="album_title"/>
		</div>
		<div>
			<label for="album_status">状态:</label>
			<input class="easyui-textbox" name="status" id="album_status"/>
		</div>
		<div>
			<label for="album_acount">集数:</label>
			<input class="easyui-textbox" name="acount" id="album_acount"/>
		</div>
		<div>
			<label for="album_score">评分:</label>
			<input class="easyui-textbox" name="score" id="album_score"/>
		</div>
		<div>
			<label for="album_author">作者:</label>
			<input class="easyui-textbox" name="author" id="album_author"/>
		</div>
		<div>
			<label for="album_broadCast">播音:</label>
			<input class="easyui-textbox" name="broadCast" id="album_broadCast"/>
		</div>
		<div>
			<label for="album_brief">简介:</label>
			<input class="easyui-textbox" name="brief" id="album_brief"/>
		</div>
		<div>
			<label for="file">上传:</label>
			<input class="easyui-filebox" id="file" name="image"/>
		</div>
	</form>
</div>

<div id="album_paly" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
	data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

	<audio id="audio" src="" controls="controls" autoplay="autoplay"></audio>

</div>