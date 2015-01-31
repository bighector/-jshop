<#import "/resource/common_html_meat.ftl" as html>
<@html.htmlBase>
	<form action="${basepath}/manage/indexImg.action" theme="simple" enctype="multipart/form-data">
		<span id="pifeSpan" class="input-group-addon" style="display:none">${systemSetting().imageRootPath}</span>
		<table class="table table-bordered">
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong> 门 户 图 片 编 辑 </strong>
				</td>
			</tr>
			<tr style="display: none;">
				<th>id</th>
				<td><input type="hidden" value="${e.id!""}" name="e.id" label="id" id="idd"/></td>
			</tr>
			<tr>
				<th class="right">标题</th>
				<td style="text-align: left;"><input type="text"  value="${e.title!""}" name="e.title"  data-rule="标题:required;title;length[1~45];"
						id="title" /></td>
			</tr>
			<tr>
				<th>图片地址</th>
				<td style="text-align: left;" colspan="3">
					<input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
					<input type="text"  value="${e.picture!""}" name="e.picture"  id="picture" ccc="imagesInput" style="width: 600px;" data-rule="图片地址:required;picture;" />
					<#if e.picture??>
						<a target="_blank" href="${systemSetting().imageRootPath}/..${e.picture!""}">
							<img style="max-width: 50px;max-height: 50px;" alt="" src="${systemSetting().imageRootPath}/..${e.picture!""}">
						</a>
					</#if>
				</td>
			</tr>
			<tr>
				<th>广告链接</th>
				<td style="text-align: left;">
					<input type="text"  value="${e.link!""}" name="e.link"  id="link" />
				</td>
			</tr>
			<tr>
				<th>排序</th>
				<td style="text-align: left;"><input type="text"  value="${e.order1!""}" name="e.order1"  data-rule="排序:integer;order1;length[1~5];"
						id="order1" /></td>
			</tr>
			<tr>
				<th>描述</th>
				<td style="text-align: left;"><input type="text"  value="${e.desc1!""}" name="e.desc1"  data-rule="排序:desc1;length[1~100];"
						id="desc1" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<#if e.id??>
                        <button method="indexImg!update.action" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 保存
                        </button>
					<#else>
                        <button method="indexImg!insert.action" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 新增
                        </button>
					</#if>
			</tr>
		</table>
	</form>
<script>
//删除图片主路径
function clearRootImagePath(picInput){
	var _pifeSpan = $("#pifeSpan").text();
	var _imgVal = picInput.val();
	picInput.val(_imgVal.substring(_imgVal.indexOf("/attached/")));
	//if(_imgVal && _imgVal.length>0 && _imgVal.indexOf(_pifeSpan)==0){
		//picInput.val(_imgVal.substring(_pifeSpan.length));
	//}
}

KindEditor.ready(function(K) {
	var editor = K.editor({
		fileManagerJson : '${basepath}/resource/kindeditor-4.1.7/jsp/file_manager_json.jsp'
	});
	K('input[name=filemanager]').click(function() {
		var imagesInputObj = $(this).parent().children("input[ccc=imagesInput]");
		editor.loadPlugin('filemanager', function() {
			editor.plugin.filemanagerDialog({
				viewType : 'VIEW',
				dirName : 'image',
				clickFn : function(url, title) {
					//K('#picture').val(url);
					//alert(url);
					imagesInputObj.val(url);
					editor.hideDialog();
					clearRootImagePath(imagesInputObj);//$("#picture"));
				}
			});
		});
	});
	
});
</script>
</@html.htmlBase>