<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="热门查询管理">
<script>
	$(function(){
		var table = $('#dataTables-example').DataTable({
			ajax:{
				url:"loadData",
				dataSrc:"list"
			},
			columns:[
				{name:"id",orderable:false,title:'',data:"id",render:function(data,type,row){
					return '<input type="checkbox" name="ids" value="'+data+'"/>';
				}},
				{name:"keywork",title:"关键字",data:"keywork"},
				{name:"url",title:"链接地址",data:"url"},
				{name:"updateTime", title:"最后一次操作时间", data:"updateTime",render:function(data,type,row,meta){
                	var d = "";
                	if(data)
                		d = new Date(data).format("yyyy-MM-dd HH:mm:ss")
                   return d;
                }},
				{name:"isValid", title:"是否有效", data:"isValid",render:function(data,type,row,meta){
                    if(data == true){
                        return '<img src="${staticpath}/images/action_check.gif">';
                    } else {
                        return '<img src="${staticpath}/images/action_delete.gif">';
                    }
                }},
				{name:"updateTime",title:"更新时间",data:"updateTime",render:function(data, type, row){
					var d = "";
					if(data != null)
						d = new Date(data).format("yyyy-MM-dd HH:mm:ss")
					return d;
				}},
				{name:"oper", title:"操作", data:"id",render: function (data, type, row, meta) {
					var h = "";
                	<#if checkPrivilege("/manage/user/edit")>
                        h +=  '<a href="toEdit?id=' + data + '">编辑</a> ';
                    </#if>
                    <#if checkPrivilege("/manage/user/delete")>
                       h += '&nbsp; <a href="deleteByID?id=' + data + '">删除</a>';
					</#if>
					return h;
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
					<a href="toAdd" class="btn btn-success">
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
		<table class="display stripe cell-border" id="dataTables-example" style="text-align:center;"></table>
</form>
</@page.pageBase>