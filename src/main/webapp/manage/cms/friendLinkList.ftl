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
				{name:"linkName", title:"名称", data:"linkName"},
				{name:"linkUrl", title:"链接", data:"linkUrl",render:function(data,type,row,meta){
					return '<a href="http://'+data+'" target="_blank" >'+data+'</a>';
				}},
                {name:"linkLogo", title:"logo", data:"linkLogo",render:function( data, type, row, meta ){
                	return '<img src="'+data+'" name="logo" />';
                }},
				{name:"ordinal", title:"顺序", data:"ordinal"},
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
                {name:"oper", title:"操作", data:"id",render: function (data, type, row, meta) {
					var h = "";
                	<#if checkPrivilege("/manage/cms/friendLink/edit")>
                        h +=  '<a href="toEdit?id=' + data + '">编辑</a> ';
                    </#if>
					return h;
                }}
			]
        });
	});
</script>
<form action="${basepath}/manage/cms/navigation/" method="post">
	<table class="table table-bordered">
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
			</td>
		</tr>
	</table>

	<table class="table table-bordered table-hover" id="dataTables-example" style="text-align: center;">
	</table>

</form>
</@page.pageBase>