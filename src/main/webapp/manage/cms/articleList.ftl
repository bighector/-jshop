<#import "/manage/tpl/pageBase.ftl" as page/>
<@page.pageBase currentMenu="文章管理">
<#--<script type="text/javascript">
	$(function() {
		$("#treegrid").treegrid({"treeColumn":1});
		var _catalogId = $("#catalogId").val();
		if( _catalogId != '' && _catalogId != > 0 ){
            $("#catalogSelect").val(_catalogId);
		}
	});
	function deleteSelect(id) {
		try{
			if(confirm("确定删除当前记录?")){
				$.blockUI({ message: "系统处理中，请等待...",css: {
			        border: 'none',
			        padding: '15px',
			        backgroundColor: '#000',
			        '-webkit-border-radius': '10px',
			        '-moz-border-radius': '10px',
			        opacity: .5,
			        color: '#fff'
			    }});
				var _url = "deleteByID?id="+id;
				$.ajax({
				  type: 'POST',
				  url: _url,
				  data: {},
				  async:false,
				  success: function(data){
					  console.log("ajax.data="+data);
					  if(data){

						var _form = $("#form");
						_form.attr("action","selectList");
						_form.submit();

						  //alert("删除成功！");
						  //document.form.action = "catalog!selectList.action";
					      //document.form.submit();
					  }
					  jQuery.unblockUI();
				  },
				  dataType: "text",
				  error:function(){
					  	jQuery.unblockUI();
						alert("加载失败，请联系管理员。");
				  }
				});
			}
		}catch(e){
			console.log("eee="+e);
		}
		return false;
	}
	//编辑
	function editSelect(id){
		//document.form1.action = "catalog!toEdit.action?e.id="+node.id;
        //document.form1.submit();
        var _url = "toEdit?id="+id;
        var _form = $("#form");
		_form.attr("action",_url);
		_form.submit();
	}
</script>-->

<form action="${basepath}/manage/article" name="form" id="form" method="post">
    <table class="table table-bordered">
        <tr>
            <td >标题</td>
            <td >
                <input type="text"   name="title"  id="title"  />
            </td>
            <td >标题简称</td>
            <td >
                <input type="text"   name="code"  id="code"  />
            </td>
            <td >大类</td>
            <td ><input type="hidden"  id="catalogId">
                <select onchange="catalogChange(this)" name="catalogId" id="catalogSelect">
                    <option></option>
					<#list catalogs as item>
                        <option pid="0" value="${item.id!""}"><font color='red'>${item.name!""}</font></option>
						<#if item.children?? && item.children?size gt 0>
							<#list item.children as item>
                                <option value="${item.id!""}">&nbsp;&nbsp;&nbsp;&nbsp;${item.name!""}</option>
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

                <button method="deletes" class="btn btn-danger" onclick="return submitIDs(this,'确定删除选择的记录?');">
                    <i class="icon-remove-sign icon-white"></i> 删除
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
                {name:"secondTitle", title:"副标题", data:"secondTitle"},
                {name:"code", title:"标题简称", data:"code"},
                {name:"order1", title:"排序", data:"order1"},
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
                    returnOpt+='<a href="${basepath}/manage/article/toEdit?id=' + data + '">编辑</a>';

				<#-- returnOpt+='<a href="${basepath}/manage/notice/toEdit?id=' + data + '">编辑</a>';-->
                    return returnOpt;

                }}
            ]
        });
    });
</script>

</@page.pageBase>