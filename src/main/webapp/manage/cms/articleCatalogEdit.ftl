<#import "/manage/tpl/pageBase.ftl" as page/>
<@page.pageBase currentMenu="文章分类">
	<form action="${basepath}/manage/cms/articleCatalog">
		<input id="catalogID" value="${e.parentId!""}" style="display: none;"/>
		<input id="catalogID_currentID" value="${e.id!""}" style="display: none;"/>
		<input type="hidden" value="${e.categoryType!""}" name="type" id="type"/>

		<table class="table table-bordered" style="width: 95%;margin: auto;">
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>编辑分类</strong>
						<span class="badge badge-success">文章分类</span>&nbsp;
				</td>
			</tr>
			<tr style="display: none;">
				<td>id</td>
				<td><input type="hidden" value="${e.id!""}" name="id" lable="id" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">上级分类</td>
				<td style="text-align: left;">
					<select onchange="catalogChange(this)" name="pid" id="catalogSelect">
						<#if !e.id??>
						<option></option>
						</#if>
					 	<#list catalogs as item>
							<option pid="0" value="${item.id!""}"><font color='red'>${item.categoryName!""}</font></option>
                            <#if item.children?? && item.children?size gt 0>
                                <#list item.children as item>
                                    <option value="${item.id!""}">${item.categoryName!""}</option>
                                </#list>
                            </#if>
                        </#list>
					</select>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">是否有效</td>
				<td style="text-align: left;">
                    <select id="isValid" name="isValid" data-rule="是否有效:required;" class="input-medium">
					<#assign map={"1":"是","0":"否"}>
					<#list map ? keys as key>
						<option value="${key}" <#if e.isValid??&&e.isValid?string("1","0")==key>selected="selected"</#if>>${map[key]}</option>
					</#list>
					</select>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">分类名称</td>
				<td style="text-align: left;"><input type="text"  value="${e.categoryName!""}" name="categoryName"  id="categoryName" data-rule="名称;required;name;" size="20" maxlength="20"/></td>
			</tr>
			<tr>
				<td style="text-align: right;">分类编码</td>
				<td style="text-align: left;">
					<input type="text"  value="${e.categoryCode!""}" name="categoryCode"  data-rule="编码;required;code;length[1~45];remote[uniqueCode, id]" size="45" maxlength="45" id="code" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">顺序</td>
				<td style="text-align: left;"><input type="text"  value="${e.ordinal!""}" name="ordinal"  data-rule="顺序;required;integer;ordinal;" size="20" maxlength="20"	id="ordinal" /></td>
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
	$("#title").focus();
	selectDefaultCatalog();
	$("#name").blur(function(){
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

function catalogChange(obj){
	var _pid = $(obj).find("option:selected").attr("pid");
	console.log("_pid="+_pid);
	if(!(_pid && _pid==0)){
		alert("不能选择子类!");
		selectDefaultCatalog();
		return false;
	}
}

function getCode(){
	var _name = $("#name").val();
	//var _url = "catalog!autoCode.action?e.name="+_name;
	var _url = "autoCode";
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {"name":_name},
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