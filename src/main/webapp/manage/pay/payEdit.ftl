<#import "/resource/common_html_meat.ftl" as html>
<@html.htmlBase>
	<form action="${basepath}/manage/pay.action" theme="simple">
		<table class="table table-bordered">
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>支付方式编辑</strong>
				</td>
			</tr>
			<tr style="display: none;">
				<td>id</td>
				<td><input type="hidden" value="${e.id!""}" name="e.id" label="id" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">支付方式</td>
				<td style="text-align: left;">
					<#assign map = {'alipay':'支付宝'}>
                    <select id="code" name="e.code" class="input-medium">
						<#list map?keys as key>
                            <option value="${key}" <#if e.code?? && e.code==key>selected="selected" </#if>>${map[key]}</option>
						</#list>
                    </select>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">状态</td>
				<td style="text-align: left;">
					<#assign map = {'y':'启用'}>
                    <select id="status" name="e.status" class="input-medium">
						<#list map?keys as key>
                            <option value="${key}" <#if e.status?? && e.status==key>selected="selected" </#if>>${map[key]}</option>
						</#list>
                    </select>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">卖家账号</td>
				<td style="text-align: left;"><input type="text"  value="${e.seller!""}" name="e.seller"  data-rule="卖家账号:required;seller;length[1~45];"
						id="seller" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">合作身份者ID</td>
				<td style="text-align: left;"><input type="text"  value="${e.partner!""}" name="e.partner"  data-rule="合作身份者ID:required;partner;length[1~45];"
						id="partner" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">商户的私钥</td>
				<td style="text-align: left;"><input type="text"  value="${e.key1!""}" name="e.key1"  data-rule="商户的私钥:required;key1;length[1~45];"
						id="key1" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">排序</td>
				<td style="text-align: left;"><input type="text"  value="${e.order1!""}" name="e.order1"  data-rule="排序:integer;order1;"
						id="order1" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><#if e.id??>
					<button method="pay!update.action" class="btn btn-success">
						<i class="icon-ok icon-white"></i> 保存
					</button>
					<#else>
                        <button method="pay!insert.action" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 新增
                        </button>
					</#if>
				</td>
			</tr>
		</table>
	</form>

</@html.htmlBase>