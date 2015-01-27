<#import "/resource/common_html_meat.ftl" as html>
<@html.htmlBase>
<script type="text/javascript">
	$(function() {
		$("#title").focus();
	});

	function onSubmit() {
		return true;
	}
</script>
	<form action="${basepath}/manage/commentType.action" theme="simple" onsubmit="return onSubmit();">
		<table class="table table-bordered">
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>评论插件编辑</strong>
				</td>
			</tr>
			<tr style="display: none;">
				<td>id</td>
				<td><intput type="hidden" value="${e.id!""}" name="e.id" label="id" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">选择插件</td>
				<td style="text-align: left;">
					<#assign map = {'default':'系统默认','duoshuo':'多说评论插件'}>
                    <select id="code" name="e.code" class="input-medium">
						<#list map?keys as key>
                            <option value="${key}" <#if e.code?? && e.code==key>selected="selected" </#if>>${map[key]}</option>
						</#list>
                    </select>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
				<#if e.id??>
                    <button method="commentType!update.action" class="btn btn-success">
                        <i class="icon-ok icon-white"></i> 保存
                    </button>
					<#else>
                        <button method="commentType!insert.action" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 新增
                        </button>
					</#if>
					<#--<s:submit-->
						<#--method="back" value="返回" cssClass="btn btn-inverse"/></td>-->
			</tr>
		</table>
	</form>

</@html.htmlBase>