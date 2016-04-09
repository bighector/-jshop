<#import "/manage/tpl/pageBase.ftl" as page/>
<@page.pageBase currentMenu="文章管理">

<form action="${basepath}/manage/cms/article" method="post">
    <table class="table table-bordered table-condensed">
        <tr>
            <td >标题</td>
            <td >
                <input type="text"   name="title"  id="title" class="input-medium search-query"  />
            </td>
            <td >编码</td>
            <td >
                <input type="text"   name="code"  id="code" class="input-medium search-query" />
            </td>
            <td >分类</td>
            <td >
            	<input type="hidden"  id="catalogId" class="input-medium search-query"/>
           		<select name="categoryId" id="catalogSelect">
            		<option></option>
	                <#if categories?? && categories?size gt 0>
	                    <#list categories as item>
	                        <option value="${item.id!""}">${item.categoryName!""}</option>
	                    </#list>
	                </#if>
				</select>
            </td>
        </tr>
        <tr>
            <td colspan="30">
				<button method="selectList" class="btn btn-primary" table-id="dataTables-article" onclick="return selectList(this)">
					<i class="icon-search icon-white"></i> 查询
				</button>
                <a href="toAdd" class="btn btn-success">
                    <i class="icon-plus-sign icon-white"></i> 添加
                </a>
            </td>
        </tr>
    </table>
</form>
<table class="display stripe row-border cell-border" id="dataTables-article" style="text-align: center;"></table> 
<script type="text/javascript">
    $(function(){
        var table = $('#dataTables-article').DataTable({
            "ajax": {
                url:"loadData",
                dataSrc:"list"
            },

            columns:[
                {name:"id", title:"ID", data:"id"},
                {name:"categoryName", title:"文章分类", data:"categoryName"},
                {name:"title", title:"标题", data:"title"},
                {name:"code", title:"编码", data:"code"},
                {name:"ordinal", title:"排序", data:"ordinal"},
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
        
        //选中分类条件
        $("#catalogSelect").change(function(){
        	$("#catalogId").val(this.value);
        });
    });
</script>

</@page.pageBase>