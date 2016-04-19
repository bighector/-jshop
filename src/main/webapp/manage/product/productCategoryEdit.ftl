<#import "/manage/tpl/pageBase.ftl" as page/>
<@page.pageBase currentMenu="商品目录">
	<form action="${basepath}/manage/product/category" id="form" name="form">
		<input id="catalogID" value="${e.parentId!""}" style="display: none;"/>
		<input id="catalogID_currentID" value="${e.id!""}" style="display: none;"/>

		<table class="table table-bordered" style="width: 95%;margin: auto;">
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>编辑商品分类</strong>
				</td>
			</tr>
			<tr style="display: none;">
				<td>id</td>
				<td><input type="hidden" value="${e.id!""}" name="id" lable="id" /></td>
			</tr>
				<tr>
				<td style="text-align: right;">上级分类</td>
				<td style="text-align: left;">
					<select onchange="catalogChange(this)" name="parentId" id="catalogSelect">
						<option></option>
                        <#list catalogs as item>
							<option pid="0" value="${item.id!""}">${item.categoryName!""}</option>
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
				<td style="text-align: right;">名称</td>
				<td style="text-align: left;"><input type="text"  value="${e.categoryName!""}" name="categoryName"  id="categoryName" data-rule="名称;required;name;" size="20" maxlength="20"/></td>
			</tr>
			<tr>
				<td style="text-align: right;">编码</td>
				<td style="text-align: left;">
					<input type="text"  id="categoryCode" value="${e.categoryCode!""}" name="categoryCode"  data-rule="编码;required;code;length[1~45];remote[uniqueCode, id]" size="45" maxlength="45" /></td>
			</tr>
            <tr>
                <td style="text-align: right;">SEO关键字</td>
                <td style="text-align: left;">
                    <textarea type="text"  class="form-control" name="keywords">${e.keywords!""}</textarea>
				</td>
            </tr>
            <tr>
                <td style="text-align: right;">SEO页面标题</td>
                <td style="text-align: left;"><textarea type="text" class="form-control"  name="pageTitle">${e.pageTitle!""}</textarea>
					</td>
            </tr>
            <tr>
                <td style="text-align: right;">分类描述</td>
                <td style="text-align: left;"><textarea type="text"  class="form-control" name="description">${e.description!""}</textarea>
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
	$("#categoryName").blur(function(){
		getCode();
	});
});
function selectDefaultCatalog(){
	var _catalogID = $("#catalogID").val();
		$("#catalogSelect").val(_catalogID);
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
	var _name = $("#categoryName").val();
	var _url = "${basepath}/common/generatePinyinCode";
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {"name":_name},
	  dataType:"text",
	  //async:false,
	  success: function(data){
		  if(!data){return null;}
		  $("#categoryCode").val(data);
	  },
	  error:function(){
		  console.log("加载数据失败，请联系管理员。");
	  }
	});
}
	
</script>
</@page.pageBase>