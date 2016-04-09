<#import "/manage/tpl/pageBase.ftl" as page/>
<@page.pageBase currentMenu="文章分类">
	<form action="${basepath}/manage/cms/catalog" method="post">
		<table class="table table-bordered table-condensed table-hover">
			<tr>
				<td colspan="16">
					<a href="toAdd" class="btn btn-success">
						<i class="icon-plus-sign icon-white"></i> 添加
					</a>
				</td>
			</tr>
		</table>
	</form>
	<div class="alert alert-info" style="margin-bottom: 2px;">友情提示：文章分类编码必须唯一。</div>
	<table class="display stripe row-border cell-border" id="dataTables-catalog" style="text-align: center;"></table>
<script type="text/javascript">
$(function(){
        var table = $('#dataTables-catalog').DataTable({
            "ajax": {
				url:"loadData",
				dataSrc:"list"
            },

			columns:[
                {name:"ID", "orderable": false, title:'<input type="checkbox" id="firstCheckbox"/>', data:"id",render:function ( data, type, row, meta) {
                           return '<input type="checkbox" name="ids" value="'+data+'"/>';
                }},
				{name:"id", title:"ID", data:"id"},
				{name:"categoryName", title:"分类名称", data:"categoryName"},
				{name:"categoryCode", title:"分类编码", data:"categoryCode"},
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
                     var returnOpt="";
                     returnOpt+='<a href="toEdit?id=' + data + '">编辑</a>';
                    return returnOpt;
           
                }}
			]
        });
	});
  </script>
</@page.pageBase>