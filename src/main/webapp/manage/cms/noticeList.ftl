<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="公告管理">
<form action="${basepath}/manage/cms/notice" method="post">
	<table class="table table-bordered">
		<tr>
			<td style="text-align: right;">状态</td>
			<td style="text-align: left;" >
                <select name="isValid" id="isValid" class="input-small">
                    <option value="">全部</option>
                    <option value="1">有效</option>
                    <option value="0">无效</option>
                </select>
			</td>
			
			<td style="text-align: right;">标题</td>
			
			<td style="text-align: left;" >
                 <input type="text"   name="title" class="input-medium search-query" />
			</td>
		</tr>
		<tr>
			<td colspan="11">
					<button method="selectList" id="btnSearch" class="btn btn-primary" table-id="dataTables-notice" onclick="return selectList(this)">
						<i class="icon-search icon-white"></i> 查询
					</button>
                     <#if checkPrivilege("/manage/cms/notice/insert") >
                     <a href="toAdd" class="btn btn-success"><i class="icon-plus-sign icon-white"></i> 添加</a>
                     </#if>
			</td>
		</tr>
	</table>
</form>
<table class="display stripe row-border cell-border" id="dataTables-notice" style="text-align: center;"></table>
 <script type="text/javascript">
	$(function(){
        var table = $('#dataTables-notice').DataTable({
            "ajax": {
				url:"loadData",
				dataSrc:"list"
            },

			columns:[
                {name:"ID", "orderable": false, title:'<input type="checkbox" id="firstCheckbox"/>', data:"id",render:function ( data, type, row, meta) {
                           return '<input type="checkbox" name="ids" value="'+data+'"/>';
                }},
				{name:"id", title:"ID", data:"id"},
				{name:"title", title:"标题", data:"title"},
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