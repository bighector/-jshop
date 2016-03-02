<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="会员等级">
<script>
	$(function(){
        var table = $('#dataTables-example').DataTable({
            "ajax": {
				url:"loadData",
				dataSrc:"list"
            },
//            serverParams:function(data){
//				$.each($("form").serializeArray(),function(ix,v){
//					data[v.name]= v.value;
//				})
////			$.extend(data, $("form").serialize());
//			},
			columns:[
                {name:"ID", "orderable": false, title:'<input type="checkbox" id="firstCheckbox"/>', data:"id",render:function ( data, type, row, meta ) {
                    // 'sort', 'type' and undefined all just use the integer
                    return '<input type="checkbox" name="ids" value="'+data+'"/>';
                }},
				{name:"code", title:"code", data:"code"},
				{name:"name", title:"等级", data:"name"},
				{name:"minscore", title:"最小积分", data:"minscore"},
				{name:"maxscore", title:"最大积分", data:"maxscore"},
				{name:"remark", title:"备注", data:"remark"},
                {name:"createtime", title:"创建时间", data:"createTime",render:function(data,type,row,meta){
                    return data;
                }},
                {name:"oper", title:"操作", data:"id",render: function (data, type, row, meta) {
					<#if checkPrivilege("/manage//accountRank/edit")>
                        return '<a href="${basepath}/manage//accountRank/toEdit?id=' + data + '">编辑</a> &nbsp; <a href="${basepath}/manage//accountRank/deleteByID?id=' + data + '">删除</a>';
					<#else>
                        return "";
					</#if>
                }}
			]
        });
        
        
	});
</script>
<style type="text/css">
.titleCss {
	background-color: #e6e6e6;
	border: solid 1px #e6e6e6;
	position: relative;
	margin: -1px 0 0 0;
	line-height: 32px;
	text-align: left;
}

.aCss {
	overflow: hidden;
	word-break: keep-all;
	white-space: nowrap;
	text-overflow: ellipsis;
	text-align: left;
	font-size: 12px;
}

.liCss {
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
	height: 30px;
	text-align: left;
	margin-left: 10px;
	margin-right: 10px;
}
</style>
<form action="${basepath}/accountRank/loadData" method="post">
	<table class="table table-bordered table-condensed">
		<tr>
			<td style="text-align: right;">名称</td>
			<td style="text-align: left;" >
			<input type="text" class="input-small" id="name" name="name">
			</td>
			<td>
			</td>
			<td>
            <#if checkPrivilege("/manage/accountRank/search") >
					<button method="selectList" id="btnSearch" class="btn btn-primary" table-id="dataTables-example" onclick="return selectList(this)">
						<i class="icon-search icon-white"></i> 查询
					</button>
             </#if>
				<#if checkPrivilege("/manage/keyvalue/insert") >
                <a href="${basepath}/manage//accountRank/toAdd" class="btn btn-success"><i class="icon-plus-sign icon-white"></i> 添加</a>
				</#if>

				<div style="float: right;vertical-align: middle;bottom: 0px;top: 10px;">
                    <#--<#include "/manage/system/pager.ftl"/>-->
				</div>

			</td>
		</tr>
	</table>

    <table class="display stripe row-border cell-border" id="dataTables-example">
    </table>
    
</form>
</@page.pageBase>