<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="通知模板管理">
	<script type="text/javascript">
	$(function(){
		var table = $('#dataTables-example').DataTable({
			"ajax":{
				url:"loadData",
				dataSrc:"list"
			},
			columns:[
				{name:"id",orderable:false,title:'',sWidth:"10",data:"id",render:function(data,type,row){
					return '<input type="checkbox" name="ids" value="'+data+'"/>';
				}},
				{name:"tplType",title:"类型",data:"tplType",sWidth:"30"},
				{name:"tplKey",title:"标识",data:"tplKey"},
				{name:"tplName",title:"名称",data:"tplName",sWidth:"60"},
				{name:"remark",title:"内容",data:"remark"},
				{name:"validStatus",title:"状态",data:"validStatus",sWidth:"30",render:function(data, type, row){
					if(data == "1")
						return "是";
					else
						return "否";
				}},
				{name:"oper", title:"操作", data:"id",sWidth:"30",render: function (data, type, row, meta) {
					<#if checkPrivilege("/manage//user/edit")>
                        return '<a href="${basepath}/manage/cms/notifyTemplate/toEdit?id=' + data + '">编辑</a>';
					<#else>
                        return "";
					</#if>
                }}
			]
		});
	});
	</script>
	<form action="${basepath}/manage/cms/notifyTemplate" method="POST" >
		<table class="table table-bordered">
			<tr style="background-color: #dff0d8;">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>邮件、短信 通知模板管理</strong>
				</td>
			</tr>
			<tr>
				<td colspan="16">
				<#if checkPrivilege("/manage/user/insert") >	
					<a href="${basepath}/manage/cms/notifyTemplate/toAdd" class="btn btn-success">
						<i class="icon-plus-sign icon-white"></i> 添加
					</a>
				</#if>
				<#if checkPrivilege("/manage/user/delete") >			
					<button method="deletes" class="btn btn-danger" onclick="return submitIDs(this,'确定删除选择的记录?');">
						<i class="icon-remove-sign icon-white"></i> 删除
					</button>
				</#if>		
				</td>
			</tr>
		</table>

		<table class="display stripe cell-border" id="dataTables-example" style="text-align: center;">
		</table>
	</form>
</@page.pageBase>