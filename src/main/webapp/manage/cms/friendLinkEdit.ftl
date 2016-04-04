<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="友情链接">
    <form action="${basepath}/manage/cms/friendLink" method="post" name="form" id="form">
    <div class="alert alert-info" style="margin-bottom: 2px;text-align: left;">友情链接会自动显示到门户的最底部。友情链接的地址不要以“http://”开头。</div>
		<table class="table table-bordered">
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>友情链接编辑</strong>
				</td>
			</tr>
			<tr style="display: none;">
				<td>id</td>
				<td><input type="hidden" value="${e.id!""}" name="id" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">链接名称</td>
				<td style="text-align: left;">
					<input type="text"  value="${e.linkName!""}" name="linkName" size="20"  data-rule="required;name;length[1~45];" id="linkName" />
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">链接地址</td>
				<td style="text-align: left;">
					<input type="text"  value="${e.linkUrl!""}" name="linkUrl" size="50"  data-rule="required;name;length[1~100];" id="linkUrl" />
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">logo地址</td>
				<td style="text-align: left;">
					<input type="text"  value="${e.linkLogo!""}" name="linkLogo" size="50"  data-rule="name;length[1~100];" id="linkLogo" />
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">顺序</td>
				<td style="text-align: left;"><input type="text"  value="${e.ordinal!"0"}" size="5" name="ordinal"  data-rule="顺序:integer;order1;length[1~5];"
						id="order1" /></td>
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
</@page.pageBase>