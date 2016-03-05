<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="公告管理">

<form action="${basepath}/manage/cms/notice/" method="post">
	<table class="table table-bordered">
		<tr>
			<td style="text-align: right;">状态</td>
			<td style="text-align: left;" >
                <select name="status" id="status" class="input-small">
                    <option value="">全部</option>
                    <option value="y">显示</option>
                    <option value="n">不显示</option>
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
                     <#if checkPrivilege("/manage/user/insert") >
            -->
					<button method="selectList" id="btnSearch" class="btn btn-primary" table-id="dataTables-notice" onclick="return selectList(this)">
						<i class="icon-search icon-white"></i> 查询
					</button>
                      
                     <a href="${basepath}/manage/cms/notice/toAdd" class="btn btn-success"><i class="icon-plus-sign icon-white"></i> 添加</a>
                     
                    <button method="deletes" class="btn btn-danger" onclick="return submitIDs(this,'确定删除选择的记录?');">
						<i class="icon-remove-sign icon-white"></i> 删除
					</button>
					
					<button method="updateStatusY" class="btn btn-warning" onclick="return submitIDs(this,'确定让选择的记录审核通过?这样选择的记录将会出现在门户上。');">
						<i class="icon-arrow-up icon-white"></i> 显示
					</button>
						
					<button method="updateStatusN" class="btn btn-warning" onclick="return submitIDs(this,'执行该操作后,选择的记录将不会出现在门户上。确定要执行?');">
						<i class="icon-arrow-down icon-white"></i> 不显示
					</button>


				<div style="float: right;vertical-align: middle;bottom: 0px;top: 10px;">
                    <#--<#include "/manage/system/pager.ftl"/>-->
				</div>

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
                {name:"status", title:"显示状态", data:"status",render:function(data,type,row,meta){
                    if(data == "y"){
                        return '<img src="${basepath}/resource/images/action_check.gif">';
                    } else {
                        return '<img src="${basepath}/resource/images/action_delete.gif">';
                    }
                }},
                {name:"oper", title:"操作", data:"id",render: function (data, type, row, meta) {
                      
                     var returnOpt="";
                     returnOpt+='<a href="${basepath}/manage/cms/notice/toEdit?id=' + data + '">编辑</a>';
                     
                    <#-- returnOpt+='<a href="${basepath}/manage/cms/notice/toEdit?id=' + data + '">编辑</a>';-->
                    return returnOpt;
           
                }}
			]
        });
	});
  </script>
</@page.pageBase>