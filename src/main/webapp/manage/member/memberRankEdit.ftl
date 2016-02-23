<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="等级管理">
<form action="${basepath}/manage/accountRank" method="post" theme="simple" id="form" >
	<table class="table table-bordered">
		<tr>
			<td colspan="2" style="background-color: #dff0d8;text-align: center;">
				<strong>会员等级编辑</strong>
			</td>
		</tr>
		<tr style="display: none;">
			<td>id</td>
			<td><input type="hidden" value="${e.id!""}" name="id" label="id" id="id"/></td>
		</tr>
		<tr>
			<td style="text-align: right;">code</td>
			<td style="text-align: left;"><input type="text" value="${e.code!""}" name="code" id="code" data-rule="code:required;code;length[1~10];"/></td>
		</tr>
		<tr>
			<td style="text-align: right;">等级名称</td>   
			<td style="text-align: left;"><input type="text" value="${e.name!""}" name="name" data-rule="等级名称:required;name;length[1~10];"
					id="name"/></td>
		</tr>
		<tr>
			<td style="text-align: right;">最小积分</td>
			<td style="text-align: left;"><input type="text" value="${e.minscore!""}" name="minscore" data-rule="最小积分:integer;minscore;length[1~10];"
					id="minscore" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">最大积分</td>
			<td style="text-align: left;"><input type="text" value="${e.maxscore!""}" name="maxscore" data-rule="最大积分:integer;maxscore;length[1~10];"
					id="maxscore" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">备注</td>
			<td style="text-align: left;"><input type="text" value="${e.remark!""}" name="remark"
					id="remark" /></td>
		</tr>
		<tr>
			<td style="text-align: center;" colspan="2">
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