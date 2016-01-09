<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="品牌管理">
<script>
    $(function(){
        var table = $('#brandListDataTable').DataTable({
            "ajax": {
                url:"loadData",
                dataSrc:"list"
            },
            columns:[
                {name:"ID", "orderable": false, title:'<input type="checkbox" id="firstCheckbox"/>', data:"id",render:function ( data, type, row, meta ) {
                    return '<input type="checkbox" name="ids" value="'+data+'"/>';
                }},
                {name:"brandName", title:"品牌名称", data:"brandName"},
                {name:"logo", title:"品牌LOGO", data:"logo"},
                {name:"officeSite", title:"官方网站", data:"officeSite",render:function(data,type,row,meta){
                	if(null !== data){
                		return '<a href=' + data + '>'+ data +'</a>';
                	}else{
                		return '';
                	}
                }},
                {name:"description", title:"描述信息", data:"description"},
                {name:"ordinal", title:"顺序", data:"ordinal",render:function(data,type,row,meta){
                    return data;
                }},
                {name:"oper", title:"操作", data:"id",render: function (data, type, row, meta) {

					<#if checkPrivilege("/manage/brand/edit")>
                        return '<a href="${basepath}/manage/brand/toEdit?id=' + data + '">编辑</a>';
					<#else>
                        return "";
					</#if>
                }}
            ]
        });

        $("#result_table tr").mouseover(function(){
            $(this).addClass("over");}).mouseout(function(){
            $(this).removeClass("over");});

        //全选、反选
        $("#firstCheckbox").click(function() {
            $('input[type=checkbox]').attr("checked",$(this).attr("checked")?true:false);
        });
    });

    function deleteSelect(){
        if($("input:checked").size()==0){
            return false;
        }
        return confirm("确定删除选择的记录?");
    }
</script>

	<form action="${basepath}/manage/brand" method="post">
		<table class="table table-bordered">
			<tr>
				<td style="text-align: right;">品牌名称</td>
				<td style="text-align: left;">
					<input type="text" class="input-medium search-query" name="brandName"/>
				</td>
				<#--<td style="text-align: right;">名称</td>
				<td>
					<input type="text" class="input-medium search-query" name="name"/>
				</td>-->
			</tr>
		</table>
		<table class="table table-bordered">
			<tr>
				<td colspan="8">
					<button method="selectList" class="btn btn-primary" table-id="brandListDataTable" onclick="return selectList(this)">
						<i class="icon-search icon-white"></i> 查询
					</button>
					<a href="${basepath}/manage/brand/toAdd" class="btn btn-success">
						<i class="icon-plus-sign icon-white"></i> 添加
					</a>
					<button method="deletes" class="btn btn-danger" onclick="return submitIDs(this,'确定删除选择的记录?');">
						<i class="icon-remove-sign icon-white"></i> 删除
					</button>
							
					<div style="float: right;vertical-align: middle;bottom: 0px;top: 10px;">
						<#--<#include "/manage/system/pager.ftl">-->
					</div>
				</td>
			</tr>
		</table>
		<table class="display stripe row-border cell-border" id="brandListDataTable">
    	</table>
	</form>

</@page.pageBase>
