<#import "/manage/tpl/pageBase.ftl" as page/>
<@page.pageBase currentMenu="公告管理">
	<form action="${basepath}/manage/cms/notice"  method="post">
		<table class="table table-bordered">
			<tr>
				<td colspan="2" style="text-align: center;">
					<#if e.id??>
                        公告ID：<span class="badge badge-success">${e.id!""}</span>
                        <button method="update" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 保存
                        </button>
                        <#if e.isValid?? && !e.isValid>
                        <a action="news" id="btnDown" href="down?id=${e.id}" class="btn btn-warning" onclick="return confirm(\"确定不显示此公告吗?\");">
                        <i class="icon-arrow-down icon-white"></i> 不显示</a>
                        <#else>
                            <a action="news" id="btnUp" href="up?id=${e.id}" class="btn btn-warning" onclick="return confirm(\"确定显示此公告吗?\");">
                            <i class="icon-arrow-up icon-white"></i> 显示</a>
                        </#if>
                        <a class="btn btn-info" target="_blank" href="${systemSetting().website}/cms/notice/${e.id!""}.html">
                        <i class="icon-eye-open icon-white"></i> 查看</a>
					<#else>
                        <button method="insert" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 新增
                        </button>
					</#if>
				</td>
			</tr>
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>文章内容编辑 </strong>
				</td>
			</tr>
			<tr style="display: none;">
				<td>id</td>
				<td><input type="hidden" value="${e.id!""}" name="id" label="id" /></td>
			</tr>
			
			<tr>
				<td style="text-align: right;width: 80px;">标题</td>
				<td style="text-align: left;"><input type="text" value="${e.title!""}" name="title" style="width: 80%;" id="title"
				data-rule="标题:required;title;length[1~45];"/></td>
			</tr>
            <tr>
                <td style="text-align: right;">是否有效</td>
                <td style="text-align: left;">
					<#assign map={"1":"是","0":"否"}>
                    <select id="status" name="isValid" data-rule="是否有效:required;" class="input-medium">
					<#list map ? keys as key>
						<option value="${key}" <#if e.isValid??&&e.isValid?string("1","0")==key>selected="selected"</#if>>${map[key]}</option>
					</#list>
                </td>
            </tr>
			<tr>
				<td style="text-align: right;">内容</td>
                <td style="text-align: left;">
                    <textarea name="content" class="form-control" rows="20" id="content" data-rule="内容;content;length[4~4000];">${e.content!""}</textarea>
				</td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
$(function(){
   	$("#title").focus();
	var id = "${e.id!""}";

    var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			allowFileManager : true
		});
	});
});
</script>
</@page.pageBase>