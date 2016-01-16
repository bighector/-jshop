<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase  currentMenu="通知模板管理">
	<form action="${basepath}/manage/cms/notifyTemplate" method="POST" >
		<table class="table table-bordered">
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>邮件、短信 通知模板管理</strong>
				</td>
			</tr>
			<tr>
				<td style="text-align: center;width: 80px;line-height:34px;" nowrap="nowrap" >模板标识</td>
				<td style="text-align: left;">
					<input type="hidden" name="id"  id="id" value="${e.id!""}"> 
					<input type="text" value="${e.tplKey!""}" name="tplKey"  id="tplKey"  data-rule="模板标识:required;tplKey;length[1~50];"/>
                </td>
			</tr>
			<tr>
				<td style="text-align: center;width: 80px;line-height:34px;" nowra p="nowrap" >模板类型</td>
				<td style="text-align: left;">
					<input type="text" value="${e.tplType!""}" name="tplType"  id="tplType"  data-rule="模板类型:required;tplType;length[1~10];"/>
				</td>
			</tr>
			<tr>
				<td style="text-align: center;width: 80px;line-height:34px;" nowrap="nowrap">模板名称</td>
				<td style="text-align: left;">
					<input type="text" value="${e.tplName!""}" name="tplName"  id="tplName" data-rule="模板名称:required;tplName;length[1~100];"/>
				</td>
			</tr>
			<#if e.validStatus??>
			<tr>
				<td style="text-align: center;width: 80px;line-height:34px;" nowrap="nowrap">有效状态</td>
				<td style="text-align: left;">
					<select id="validStatus" name="validStatus" class="input-medium"  data-rule="状态:required;validStatus;" >
						<option value="1" <#if e.validStatus=='1'>selected="selected" </#if>>是</option>
						<option value="0" <#if e.validStatus=='0'>selected="selected" </#if>>否</option>
					</select>
				</td>
			</tr>
			</#if>
			<tr>
				<td style="text-align: center;width: 80px;line-height:150px;" nowrap="nowrap">模板内容</td>
				<td style="text-align: left;">
					<textarea cols="120" rows="8"  name="remark"  id="remark" data-rule="模板内容:required;remark;length[1~1000];">${e.remark!""}</textarea>
				</td>
			</tr>
			<tr>
				<td style="text-align: center;width: 80px;line-height:400px;" nowrap="nowrap">模板html</td>
				<td style="text-align: left;height:400px">
					<textarea name="content" id="content" style="width:100%;height:400px;visibility:hidden;" data-rule="模板HTML:required;content;">${e.content!""}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="28" style="text-align: center;">
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

<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			allowFileManager : true
		});
		K('input[name=getHtml]').click(function(e) {
			alert(editor.html());
		});
		K('input[name=isEmpty]').click(function(e) {
			alert(editor.isEmpty());
		});
		K('input[name=getText]').click(function(e) {
			alert(editor.text());
		});
		K('input[name=selectedHtml]').click(function(e) {
			alert(editor.selectedHtml());
		});
		K('input[name=setHtml]').click(function(e) {
			editor.html('<h3>Hello KindEditor</h3>');
		});
		K('input[name=setText]').click(function(e) {
			editor.text('<h3>Hello KindEditor</h3>');
		});
		K('input[name=insertHtml]').click(function(e) {
			editor.insertHtml('<strong>插入HTML</strong>');
		});
		K('input[name=appendHtml]').click(function(e) {
			editor.appendHtml('<strong>添加HTML</strong>');
		});
		K('input[name=clear]').click(function(e) {
			editor.html('');
		});
	});
	
	//更新的模板
	function updateTemplate(){
		var _tplKey = $("#tplKey").val();
		if(editor.isEmpty() || _tplKey==''){
			return;
		}
		var formData=$("form").serialize();
		var _url = "${basepath}/manage/cms/notifyTemplate/updateTemplate";
		console.log("_url="+_url);
		$.ajax({
		  type: 'POST',
		  url: _url,
		  data: formData,
		  success: function(data){
			  console.log("updateTemplate.data="+data);
			  if(data=="0"){
				  alert("保存成功！");
			  }else{
				  alert("保存失败！");  
			  }
		  },
		  dataType: "text",
		  error:function(er){
			  console.log("updateTemplate.er="+er);
		  }
		});
	}
</script>
</@page.pageBase >