<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="广告管理">
<script>
	$(function(){
        var table = $('#dataTables-example').DataTable({
            "ajax": {
				url:"loadData",
				dataSrc:"list"
            },
			columns:[
                {name:"id", "orderable": false, title:'<input type="checkbox" id="firstCheckbox"/>', data:"id",render:function ( data, type, row, meta ) {
                    return '<input type="checkbox" name="ids" value="'+data+'"/>';
                }},
				{name:"title", title:"广告标题", data:"title"},
				{name:"code", title:"code", data:"code"},
				{name:"startDate", title:"开始日期", data:"startDate"},
				{name:"endDate", title:"结束日期", data:"endDate"},
                {name:"status", title:"状态", data:"status",render:function(data,type,row,meta){
                    if(data == "y"){
                        return '<img src="${basepath}/resource/images/action_check.gif">';
                    } else {
                        return '<img src="${basepath}/resource/images/action_delete.gif">';
                    }
                }},
                {name:"useImagesRandom", title:"图集优先", data:"useImagesRandom",render:function(data,type,row,meta){
                    if(data == "y"){
                        return '<img src="${basepath}/resource/images/action_check.gif">';
                    } else {
                        return '<img src="${basepath}/resource/images/action_delete.gif">';
                    }
                }},
                {name:"oper", title:"操作", data:"id",render: function (data, type, row, meta) {

					<#if checkPrivilege("/manage/advert/edit")>
                        return '<a href="${basepath}/manage/advert/toEdit?id=' + data + '">编辑</a>';
					<#else>
                        return "";
					</#if>
                }}
			]
        });
	});
</script>
<form action="${basepath}/manage/advert" method="post">
	<table class="table table-bordered table-condensed">
		<tr>
		<td>广告标题</td>
						<td><input type="text"  value="${title!""}" name="title" class="input-medium search-query" /></td>
						<td>类型</td>
						<td>
                            <#assign map = {'index_top':'index_top','index_right_top':'index_right_top','index_right_bottom':'index_right_bottom','newslist_right_top':'newslist_right_top','newslist_right_bottom':'newslist_right_bottom','flashlist_right_top':'flashlist_right_top','flashlist_right_bottom':'flashlist_right_bottom'}>
                            <select id="code" name="code" class="input-medium">
                                <#list map?keys as key>
                                    <option value="${key}" <#if code?? && code==key>selected="selected" </#if>>${map[key]}</option>
                                </#list>
                            </select>
						</td>
		</tr>
		<tr>
			<td colspan="11">
            
            <button method="selectList" class="btn btn-primary" onclick="selectList(this)">
								<i class="icon-search icon-white"></i> 查询
							</button>
						
							<a href="toAdd" class="btn btn-success">
								<i class="icon-plus-sign icon-white"></i> 添加
							</a>
						
							<button method="deletes" class="btn btn-danger" onclick="return submitIDs(this,'确定删除选择的记录?');">
								<i class="icon-remove-sign icon-white"></i> 删除
							</button>

			</td>
		</tr>
	</table>
<table class="display stripe row-border cell-border" id="dataTables-example">
    </table>
		<div class="alert alert-info" style="text-align: left;font-size: 14px;margin: 2px 0px;">
					图标含义：<BR>
					<img alt="显示" src="${basepath}/resource/images/action_check.gif">：显示到门户上
					<img alt="不显示" src="${basepath}/resource/images/action_delete.gif">：不显示到门户上
				</div>
</form>
</@page.pageBase>