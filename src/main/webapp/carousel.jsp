<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-add',
        text: "添加",
        handler: function () {
            $("#dd").dialog("open");
        }
    }, '-', {
        iconCls: 'icon-edit',
        text: "修改",
        handler: function () {
            /*将选中行变为可编辑*/
            var row = $("#dg").edatagrid("getSelected");
            if (row == null) {
                alert("请选中行")
            } else {
                $("#dg").edatagrid("editRow", $("#dg").edatagrid("getRowIndex", row))
                //$("#dg").edatagrid("reload");//更新数据
            }
        }
    }, '-', {
        iconCls: 'icon-remove',
        text: "删除",
        handler: function () {
            var row = $("#dg").edatagrid("getSelected");
            if (row==null){
                alert("请选中行")
            }else {
                $('#dg').edatagrid('destroyRow');
                //$("#dg").edatagrid("reload");//更新数据
            }

        }
    }, '-', {
        iconCls: 'icon-save',
        text: "保存",
        handler: function () {
            $("#dg").edatagrid("saveRow")
        }
    }]

    $(function () {
        $("#dg").edatagrid({

            singleSelect:false,
            url: "${pageContext.request.contextPath}/carousel/queryAll.do",
            updateUrl: "${pageContext.request.contextPath}/carousel/update.do",
            destroyUrl:"${pageContext.request.contextPath}/carousel/delete.do",
            columns:[[
                {field:'id',title:'用户ID',width:80,align:'center'},
                {field:'title',title:'图片名',width:80,align:'center'},
                {field:'description',title:'描述',width:100,align:'center'},
                {field:'status',title:'状态',width:80,align:'center',
                    editor: {
                        type: 'text',
                        options: {required: true}
                    }
                },
                {field:'pdate',title:'最后修改时间',width:100,align:'center'},
                {field:'imgPath',title:'路径',width:200,align:'center'}

            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [5, 10, 15, 20],
            pageSize: 5,
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.pdesc + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        })

    })
    function submit() {
        $('#ff').form('submit', {
            url: "${pageContext.request.contextPath}/carousel/add.do",
            onSubmit:function(){
                return $("#ff").form("validate");
            },
            success:function(data){
                $("#dd").dialog("close"),
                    $("#dg").edatagrid("reload")
            }

        })

    }
</script>


<table id="dg"></table>

<div id="dd" class="easyui-dialog" title="添加轮播图" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                $('#ff').form(
                	submit()
                 )
				}
			},{
				text:'关闭',
				handler:function(){
				$('#dd').dialog('close');
				}
			}]">

    <form id="ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="title">标题:</label>
            <input class="easyui-textbox" id="title" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <label for="pdesc">描述:</label>
            <input class="easyui-textbox" id="pdesc" type="text" name="pdesc" data-options="required:true"/>
        </div>
        <div>
            <label for="status">状态:</label>
            <select id="status" class="easyui-combobox" name="status" style="width:200px;">
                <option value="1">展示</option>
                <option value="0">不展示</option>
            </select>

        </div>
        <div>
            <input class="easyui-filebox" name="picture" style="width:300px">
        </div>
    </form>

</div>
