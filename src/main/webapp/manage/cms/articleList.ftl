<#import "/manage/tpl/pageBase.ftl" as page/>
<@page.pageBase currentMenu="文章管理">

<form action="${basepath}/manage/cms/article/" name="form" id="form" method="post">
    <table class="table table-bordered">
        <tr>
            <td >标题</td>
            <td >
                <input type="text"   name="title"  id="title"  />
            </td>
            <td >编码</td>
            <td >
                <input type="text"   name="code"  id="code"  />
            </td>
            <td >分类</td>
            <td ><input type="hidden"  id="catalogId">
                <select name="categoryId" id="catalogSelect">
                    <option></option>
					<#list categories as item>
                        <option pid="0" value="${item.id!""}"><font color='red'>${item.categoryName!""}</font></option>
						<#if item.children?? && item.children?size gt 0>
							<#list item.children as item>
                                <option value="${item.id!""}">&nbsp;&nbsp;&nbsp;&nbsp;${item.categoryName!""}</option>
							</#list>
						</#if>
					</#list>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="30">

                <button method="selectList" id="btnSearch" class="btn btn-primary" table-id="dataTables-notice" onclick="return selectList(this)">
                    <i class="icon-search icon-white"></i> 查询
                </button>

                <a href="toAdd" class="btn btn-success">
                    <i class="icon-plus-sign icon-white"></i> 添加
                </a>
            </td>
        </tr>
    </table>
    <table class="display stripe row-border cell-border" id="dataTables-article">
    </table>
</form>

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
                {name:"updateTime", title:"最后操作时间", data:"updateTime",render:function(data,type,row,meta){
                    return new Date(data).format("yyyy-MM-dd HH:mm:ss");
                }},
                {name:"status", title:"是否有效", data:"isValid",render:function(data,type,row,meta){
                    if(data == true){
                        return '<img src="${staticpath}/images/action_check.gif">';
                    } else {
                        return '<img src="${staticpath}/images/action_delete.gif">';
                    }
                }},
                {name:"oper", title:"操作", data:"id",render: function (data, type, row, meta) {

                    var returnOpt="";
                    returnOpt+='<a href="${basepath}/manage/cms/article/toEdit?id=' + data + '">编辑</a>';
                    return returnOpt;

                }}
            ]
        });
    });
</script>

</@page.pageBase>