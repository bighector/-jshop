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
            <#--
                     TODO 添加权限控制  
                     <#if checkPrivilege("/manage/cms/notice/insert") >
            -->
					<button method="selectList" id="btnSearch" class="btn btn-primary" table-id="dataTables-notice" onclick="return selectList(this)">
						<i class="icon-search icon-white"></i> 查询
					</button>
                      
                     <a href="${basepath}/manage/cms/notice/toAdd" class="btn btn-success"><i class="icon-plus-sign icon-white"></i> 添加</a>
                     
					<button method="updateStatusY" class="btn btn-warning" onclick="return submitIDs(this,'确定将选择的记录置为有效?\n\n这样选择的记录将会出现在门户上。');">
						<i class="icon-arrow-up icon-white"></i> 置为有效
					</button>
						
					<button method="updateStatusN" class="btn btn-warning" onclick="return submitIDs(this,'确定将选择的记录置为无效?\n\n执行该操作后,选择的记录将不会出现在门户上');">
						<i class="icon-arrow-down icon-white"></i> 置为无效
					</button>


			</td>
		</tr>
	</table>

    <table class="display stripe row-border cell-border" id="dataTables-notice">
    </table>
</form>
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
                {name:"updateTime", title:"最后操作时间", data:"updateTime",render:function(data,type,row,meta){
                   return new Date(data).format("yyyy-MM-dd HH:mm:ss");
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
                     returnOpt+='<a href="${basepath}/manage/cms/notice/toEdit?id=' + data + '">编辑</a>';
                     
                    return returnOpt;
           
                }}
			]
        });
	});
  </script>
</@page.pageBase>