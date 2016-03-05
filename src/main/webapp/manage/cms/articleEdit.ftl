<#import "/manage/tpl/pageBase.ftl" as page/>
<@page.pageBase currentMenu="文章管理">
<script type="text/javascript">
	$(function() {
		$("#title").focus();
        var _catalogId = $("#catalogId").val();
        if( _catalogId != '' && _catalogId != > 0 ){
            $("#catalogSelect").val(_catalogId);
        }
	});

	function onSubmit() {
		//if($("#pid").val()==''){
			//var t = $('#cc').combotree('tree');	// get the tree object
			//var n = t.tree('getSelected');		// get selected node
			//if(!n || !n.id){
				//alert("请选择父亲类别");
				//return false;
			//}
			//$("#pid").val(n.id);
		//}
		
		if ($.trim($("#name").val()) == "") {
			alert("名称不能为空!");
			$("#title").focus();
			return false;
		}
	}
</script>
	<form action="${basepath}/manage/cms/article" theme="simple" id="form" name="form">
		<input type="hidden" id="catalogID" value="${e.catalogId!""}" style="display: none;"/>
		<input id="catalogID_currentID" value="${e.id!""}" style="display: none;"/>
		<input type="hidden" value="${e.type!""}" name="type" id="type"/>
		
		<table class="table table-bordered" style="width: 95%;margin: auto;">
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>文章编辑</strong>
						<span class="badge badge-success">文章管理</span>&nbsp;<strong>
				</td>
			</tr>
			<tr style="display: none;">
				<td>id</td>
				<td><input type="hidden" value="${e.id!""}" name="id" label="id" /></td>
			</tr>
				<tr>
				<td style="text-align: right;">大类${e.catalogId!""}</td>
				<td style="text-align: left;">
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
				<td style="text-align: right;">标题</td>
				<td style="text-align: left;"><input type="text"  value="${e.title!""}" name="title"  id="title" data-rule="名称;required;title;" size="20" maxlength="50"
						/></td>
			</tr>
            <tr>
                <td style="text-align: right;">标题简称</td>
                <td style="text-align: left;">
                    <input type="text"  value="${e.code!""}" name="code"  data-rule="编码;required;code;length[1~80];remote[uniqueCode, id]" size="45" maxlength="80" id="code" /></td>
            </tr>
            <tr>
                <td style="text-align: right;">副标题</td>
                <td style="text-align: left;"><input type="text"  value="${e.secondTitle!""}" name="secondTitle"  id="secondTitle" data-rule="名称;required;secondTitle;" size="20" maxlength="20"
                /></td>
            </tr>
            <tr>
                <td style="text-align: right;">是否显示到门户</td>
                <td style="text-align: left;">
					<#assign map={"":"","y":"是","n":"否"}>
                    <select id="status" name="status" data-rule="是否显示到门户:required;" class="input-medium">
					<#list map ? keys as key>
						<option value="${key}" <#if e.status??&&e.status==key>selected="selected"</#if>>${map[key]}</option>
					</#list>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">内容</td>
                <td style="text-align: left;"><textarea name="content" class="form-control" rows="3" id="introduce"
                     data-rule="内容;required;content;length[4~500];">${e.content!""}</textarea>
                </td>
            </tr>
            <tr>
				<td style="text-align: right;">顺序</td>
				<td style="text-align: left;"><input type="text"  value="${e.ordinal!""}" name="ordinal"  data-rule="顺序;required;integer;order1;" size="20" maxlength="20"
						id="ordinal" /></td>
			</tr>

			<tr>
				<td colspan="2" style="text-align: center;">
                    <#if e.id??>
                        <button method="update" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 保存
                        </button>
					<#else>
                        <button method="insert" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 新增
                        </button>
					</#if>
				</td>
			</tr>
		</table>
	</form>
	
<script type="text/javascript">
$(function(){
	selectDefaultCatalog();
	
	$("#title").blur(function(){
		getCode();
	});
});
function selectDefaultCatalog(){
	var _catalogID = $("#catalogID").val();
	console.log("selectDefaultCatalog._catalogID="+_catalogID);
	//if(_catalogID!='' && _catalogID>0){
		$("#catalogSelect").val(_catalogID);
	//}
}

//function catalogChange(obj){
//	var _pid = $(obj).find("option:selected").attr("pid");
//	console.log("_pid="+_pid);
//	if(!(_pid && _pid==0)){
//		alert("不能选择子类!");
//		selectDefaultCatalog();
//		return false;
//	}
//}

function getCode(){
	var _name = $("#title").val();
	var _url = "autoCode";
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {"title":_name},
	  dataType:"text",
	  //async:false,
	  success: function(data){
		  if(!data){return null;}
		  console.log("data="+data);
		  $("#code").val(data);
	  },
	  error:function(){
		  console.log("加载数据失败，请联系管理员。");
	  }
	});
}
	
</script>
</@page.pageBase>