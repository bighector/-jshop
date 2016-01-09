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
				{name:"id",orderable:false,title:'',data:"id",render:function(data,type,row){
					return '<input type="checkbox" name="ids" value="'+data+'"/>';
				}},
				{name:"keywork",title:"关键字",data:"keywork",width:"50"},
				{name:"url",title:"链接",data:"url"},
				{name:"createAccount",title:"创建人",data:"createAccount",width:"50"},
				{name:"createTime",title:"创建时间",data:"createTime",render:function(data, type, row){
					var d ="";
					if(data != null)
						d = new Date(data).format("yyyy-MM-dd HH:mm:ss")
					return d;
				}},
				{name:"updateAccount",title:"更新人",data:"updateAccount",width:"50"},
				{name:"updateTime",title:"更新时间",data:"updateTime",render:function(data, type, row){
					var d = "";
					if(data != null)
						d = new Date(data).format("yyyy-MM-dd HH:mm:ss")
					return d;
				}},
				{name:"oper", title:"操作", data:"id",width:"30",render: function (data, type, row, meta) {
					<#if checkPrivilege("/manage//user/edit")>
                        return '<a href="${basepath}/manage/cms/hotQuery/toEdit?id=' + data + '">编辑</a>';
					<#else>
                        return "";
					</#if>
                }}
			]
		});
	});
	
	function dateFormat(data, type, row){
		return  new Date(data).format("yyyy-MM-dd HH:mm:ss");
	}
</script>
<form action="${basepath}/manage/cms/hotQuery/"  method="post">
		<table class="table table-bordered table-condensed">
			<tr>
				<td colspan="16">
				<#if checkPrivilege("/manage/user/insert") >	
					<a href="${basepath}/manage/cms/hotQuery/toAdd" class="btn btn-success">
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

		<table class="display stripe cell-border" id="dataTables-example">
	
		</table>
</form>
	
</@page.pageBase>