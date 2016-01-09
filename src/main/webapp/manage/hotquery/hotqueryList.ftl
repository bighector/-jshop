<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="热门查询管理">
<script>
	$(function(){
		var table = $('#dataTables-example').DataTable({
			"ajax":{
				url:"loadData",
				dataSrc:"list"
			},
			columns:[
				{name:"ID","orderable":false,title:'<input type="checkbox" id="firstCheckbox"/>',
					data:"id",render:function(data,type,row,meta){
						 return '<input type="checkbox" name="ids" value="'+data+'"/>';
						 }},
				{name:"key1",title:"商品名",data:"key1"},
				{name:"url",title:"链接",data:"url"},
				{name:"oper", title:"操作", data:"id",render: function (data, type, row, meta) {
					<#if checkPrivilege("/manage//user/edit")>
                        return '<a href="${basepath}/manage/hotquery/toEdit?id=' + data + '">编辑</a>';
					<#else>
                        return "";
					</#if>
                }}
			]
		});
	});
</script>
<form action="${basepath}/manage/hotquery"  method="post">
		<table class="table table-bordered table-condensed">
			<tr>
				<td colspan="16">
				<#if checkPrivilege("/manage/user/insert") >	
					<a href="${basepath}/manage/hotquery/toAdd" class="btn btn-success">
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

		<table class="display stripe row-border cell-border" id="dataTables-example">
	
		</table>
</from>
	

</@page.pageBase>