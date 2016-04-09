<#import "/manage/tpl/pageBase.ftl" as page/>
<@page.pageBase currentMenu="广告管理">
<form action="${basepath}/manage/cms/advert" method="post">
	<input type="hidden" value="${e.id!""}" name="id" />
	<table class="table table-bordered" style="width: 95%;margin: auto;">
		<tr style="background-color: #dff0d8">
			<td colspan="2" style="background-color: #dff0d8;text-align: center;">
				<strong>广告内容编辑 </strong>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">类型</td>
			<td style="text-align: left;">
	            <select id="code" name="code" class="input-medium">
	                 <#assign map = {'index_top':'index_top','index_right_top':'index_right_top','index_right_bottom':'index_right_bottom','newslist_right_top':'newslist_right_top','newslist_right_bottom':'newslist_right_bottom','flashlist_right_top':'flashlist_right_top','flashlist_right_bottom':'flashlist_right_bottom'}>
	                <#list map?keys as key>
	                    <option value="${key}" <#if e.code?? && e.code==key>selected="selected" </#if>>${map[key]}</option>
	                </#list>
	            </select>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">标题</td>
			<td style="text-align: left;"><input type="text"  value="${e.title!""}" name="title"  data-rule="标题:required;title;length[1~45];" id="title" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">备注</td>
			<td style="text-align: left;"><input type="text"  value="${e.remark!""}" name="remark" id="remark" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">状态</td>
			<td style="text-align: left;">
	            <select id="status" name="status" class="input-medium">
	                <#assign map = {'y':'启用','n':'禁用'}>
	                <#list map?keys as key>
	                    <option value="${key}" <#if e.status?? && e.status==key>selected="selected" </#if>>${map[key]}</option>
	                </#list>
	            </select>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">是否优先使用图集</td>
			<td style="text-align: left;">
	            <select id="useImagesRandom" name="useImagesRandom" class="input-medium">
	                <#assign map = {'y':'优先','n':'不优先'}>
	                <#list map?keys as key>
	                    <option value="${key}" <#if e.useImagesRandom?? && e.useImagesRandom==key>selected="selected" </#if>>${map[key]}</option>
	                </#list>
	            </select>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">日期时间范围</td>
			<td style="text-align: left;">
					<input id="d4311" class="Wdate search-query" type="text" name="startDate"
					value="${e.startDate!""}"
					onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})"/>
					~ 
					<input id="d4312" class="Wdate search-query" type="text" name="endDate"
					value="${e.endDate!""}"
					onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">内容</td>
			<td style="text-align: left;">
				<textarea name="html" style="width:100%;height:300px;visibility:hidden;" data-rule="内容;content;length[4~4000];">${e.html!""}</textarea>
			</td>
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
		</tr>
	</table>
</form>
<script type="text/javascript">
	$(function() {
		$("#title").focus();
	});
	
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="html"]', {
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
</script>
</@page.pageBase>