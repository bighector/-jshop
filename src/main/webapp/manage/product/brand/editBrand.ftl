<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="品牌管理">
<style>
	.td_right{text-align: right;}
</style>
<script type="text/javascript">
	$(function() {
		 $("#code").focus();
	});
</script>
<form action="${basepath}/manage/product/brand" id="form" method="post">
		<table class="table table-bordered">
			<tr>
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>商品品牌编辑</strong>
				</td>
			</tr>
			<tr style="display:none;">
				<th>id</th>
				<td><input type="hidden" name="id" value="${e.id!""}"></td>
			</tr>
			<tr>
				<th class="td_right">品牌名称</th>
				<td style="text-align: left;">
						<input type="text" name="brandName" id="brandName" value="${e.brandName!""}" data-rule="品牌名称:required;brandName;"/>
				</td>
			</tr>
			<tr>
				<th class="td_right">品牌LOGO</th>
				<td style="text-align: left;">
                        <input type="text" name="logo" id="logo" value="${e.logo!""}"/>
				</td>
			</tr>
            <tr>
                <th class="td_right">官方网站</th>
                <td style="text-align: left;">
                		<input type="text" name="officeSite" id="officeSite" value="${e.officeSite!""}" data-rule="官方网站:required;"/>
                </td>
            </tr>
            <tr>
            <tr>
                <th class="td_right">顺序</th>
                <td style="text-align: left;">
                		<input type="text" name="ordinal" id="ordinal" value="${e.ordinal!"0"}" data-rule="顺序:integer"/>
                </td>
            </tr>
            <tr>
				<th class="td_right">描述信息</th>
				<td style="text-align: left;">
					<textarea name="description" style="width:100%;height:300px;visibility:hidden;">
						${e.description!""}
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<#if e.id??>
                        <button method="update" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 保存
                        </button>
                        <#else >
                            <button method="insert" class="btn btn-success">
                                <i class="icon-ok icon-white"></i> 新增
                            </button>
                    </#if>
				</td>
			</tr>
		</table>
</form>
<script type="text/javascript">
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="description"]', {
			allowFileManager : true
		});
		K('input[name=getHtml]').click(function(e) {
			alert(editor.html());
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
</script>
</@page.pageBase>