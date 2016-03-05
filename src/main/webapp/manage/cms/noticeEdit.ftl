<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="公告管理">


	<form action="${basepath}/manage/cms/notice/"  theme="simple" name="form" id="form" method="post">
		
		<table class="table table-bordered">
			<tr>
				<td colspan="2" style="text-align: center;">
					<#if e.id??>
                        公告ID：<span class="badge badge-success">${e.id!""}</span>
                        <button method="update" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 保存
                        </button>


                        <#if e.status??&&e.status=="y">
                        <a action="news" id="btnDown" href="down?id=${e.id}" class="btn btn-warning" onclick="return confirm(\"确定不显示此文章吗?\");">
                        <i class="icon-arrow-down icon-white"></i> 不显示</a>
                        <#else>
                            <a action="news" id="btnUp" href="up?id=${e.id}" class="btn btn-warning" onclick="return confirm(\"确定显示此文章吗?\");">
                            <i class="icon-arrow-up icon-white"></i> 显示</a>
                        </#if>

                       
                        <a class="btn btn-info" target="_blank" href="${systemSetting().www}/news/${e.id!""}.html">
                        <i class="icon-eye-open icon-white"></i> 查看</a>
                        
                        <a id="btnStatic" href="#" class="btn btn-warning">
                        <i class="icon-refresh icon-white"></i> 静态化</a>
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
				<td style="text-align: right;">内容</td>
				<td style="text-align: left;">
					<textarea name="content" style="width:100%;height:400px;visibility:hidden;" id="content"
					data-rule="内容:required;content;">${e.content!""}</textarea>
				</td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
 var editor;
$(function(){
    initTextEdit();
   	$("#title").focus();   	
	<#if e.id??>
	var id = "${e.id}";
	$("#btnStatic").click(function(){
		$.post("${basepath}/freemarker/create?method=staticNewsByID&id="+id, null ,function(response){
			alert(response == "success" ? "操作成功！" : "操作失败!");
		});
	});
	</#if>
});
function initTextEdit(){
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
}
</script>
</@page.pageBase>