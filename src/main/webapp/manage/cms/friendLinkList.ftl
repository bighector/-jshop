<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="友情链接">
<script>
	$(function(){
        var table = $('#dataTables-example').DataTable({
            ajax: {
				url:"loadData",
				dataSrc:"list"
            },
			columns:[
                {name:"id", data:"id",orderable: false, title:'<input type="checkbox" id="firstCheckbox"/>',render:function ( data, type, row, meta ) {
                    return '<input type="checkbox" name="ids" value="'+data+'"/>';
                }},
                {name:"linkLogo", title:"logo", data:"linkLogo",render:function( data, type, row, meta ){
                	return '<img src="'+data+'" name="logo" />';
                }},
				{name:"linkName", title:"名称", data:"linkName"},
				{name:"ordinal", title:"顺序", data:"ordinal"},
				{name:"linkUrl", title:"链接", data:"linkUrl",render:function(data,type,row,meta){
					return '<a href="'+data+'" target="_blank" >'+data+'</a>';
				}},
                {name:"oper", title:"操作", data:"id",render: function (data, type, row, meta) {
					var h = "";
                	<#if checkPrivilege("/manage/user/edit")>
                        h +=  '<a href="${basepath}/manage/navigation/toEdit?id=' + data + '">编辑</a> ';
                    </#if>
                    <#if checkPrivilege("/manage/user/delete")>
                       h += '&nbsp; <a href="${basepath}/manage/navigation/deleteByID?id=' + data + '">删除</a>';
					</#if>
					return h;
                }}
			]
        });
	});
</script>
<form action="${basepath}/manage/cms/navigation/" method="post">
	<table class="table table-bordered">
		<tr style="background-color: #dff0d8;">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>友情链接管理</strong>
				</td>
			</tr>
		<tr>
			<td colspan="6">
				<!-- <input type="text" name="name" value="" />
				<button method="selectOne" class="btn btn-primary">
					<i class="icon-search icon-white"></i> 查询
				</button> -->
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
	<div class="alert alert-info" style="margin-bottom: 2px;text-align: left;">友情链接会自动显示到门户的最底部。友情链接的地址不要以“http://”开头。</div>
	<table class="table table-bordered table-hover" id="dataTables-example" style="text-align: center;">
	</table>

</form>
</@page.pageBase>