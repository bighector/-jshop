<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase  currentMenu="热门查询管理">

	<div class="alert alert-info">
		提示：对【热门查询】的添加/修改不会立即生效，需要到系统管理--缓存管理页面点击【热门查询关键字】按钮，才能生效。
	</div>
	
	<form action="${basepath}/manage/cms/hotQuery/" method="POST"  id="form">
		<table class="table table-bordered">
			<tr>
				<td colspan="2" style="text-align: left;">
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
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>热门查询编辑 </strong>
				</td>
			</tr>
			<tr style="display: none;">
				<td>id</td>
				<td><input type="hidden" value="${e.id!""}" name="id" label="id" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">是否有效</td>
                <td style="text-align: left;">
                    <select id="status" name="isValid" data-rule="是否有效:required;" class="input-medium">
					<#assign map={"1":"是","0":"否"}>
					<#list map ? keys as key>
						<option value="${key}" <#if e.isValid??&&e.isValid?string("1","0")==key>selected="selected"</#if>>${map[key]}</option>
					</#list>
					</select>
                </td>
            </tr>
			<tr>
				<td style="text-align: center;width:200px;line-height:34px;">热门查询关键字</td>
				<td style="text-align: left;">
					<input type="text"  value="${e.keywork!""}" name="keywork"  id="keywork" width=" 350px" data-rule="热门查询关键字:required;keywork;length[1~100];"/>
				</td>
			</tr>
			<tr>
				<td style="text-align: center;width:200px;line-height:34px;">链接</td>
				<td style="text-align: left;">
					<input type="text" value="${e.url!""}" name="url"  id="url" data-rule="链接:required;url;length[1~100];"/>
				</td>
			</tr>
		</table>
	</form>
	<span id="pifeSpan" class="input-group-addon" style="display:none"><%=SystemManager.systemSetting.getImageRootPath()%></span>
<script type="text/javascript">
	function selectDefaultCatalog(){
		var _catalogID = $("#catalogID").val()+"";//alert(_catalogID);
		if(_catalogID!='' && _catalogID>0){//alert("_catalogID="+_catalogID);
			$("#catalogSelect").val(_catalogID);
		}
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

//删除图片主路径
function clearRootImagePath(picInput){
	var _pifeSpan = $("#pifeSpan").text();
	var _imgVal = picInput.val();
	console.log("1===>_imgVal = "+_imgVal);
	//if(_imgVal && _imgVal.length>0 && _imgVal.indexOf(_pifeSpan)==0){
		//picInput.val(_imgVal.substring(_pifeSpan.length));
		console.log("2===>"+_imgVal.indexOf("/attached/"));
		picInput.val(_imgVal.substring(_imgVal.indexOf("/attached/")));
		
	//}
}

</script>

</@page.pageBase >