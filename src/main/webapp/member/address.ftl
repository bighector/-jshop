<#import "/template/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<#import "/member/memberMenu.ftl" as memberMenu>
<@html.htmlBase>
<style type="text/css">
.centerImageCss{
	width: 560px;
	height: 180px;
}
</style>
	<@menu.menu selectMenu=""/>
	<div class="container" style="margin-top: 0px;padding-top: 0px;">
		<div class="row">
			<div class="col-xs-3" style="min-height: 300px;">
				<@memberMenu.accountMenu currentMenu="address"/>
			</div>
			
			<div class="col-xs-9" style="min-height: 200px;">

                <div class="row">
                    <div class="col-xs-12">
                        <ol class="breadcrumb">
                            <li class="active">配送地址</li>
                        </ol>
                    </div>
                </div>

                <hr>
				
					<#if addressList?? && addressList?size gt 0>
						<table class="table table-bordered table-hover" style="margin-bottom: 10px;">
							<tr style="background-color: #dff0d8">
								<th width="20px" style="display: none;"><input type="checkbox" id="firstCheckbox" /></th>
								<th nowrap="nowrap" style="text-align: center;">收货人</th>
								<th style="text-align: left;">所在区域</th>
								<th style="text-align: left;">街道地址</th>
								<th style="text-align: center;">邮编</th>
								<th style="text-align: center;">电话号码</th>
								<th style="text-align: center;">手机号</th>
								<th nowrap="nowrap" style="text-align: center;">设为默认</th>
								<th style="text-align: center;">操作</th>
							</tr>
							<#list addressList as item>
								<tr>
									<td style="display: none;">${item.id!""}</td>
									<td style="text-align: center;">${item.receiver!""}</td>
									<td style="text-align: left;">${item.pcadetail!""}</td>
									<td style="text-align: left;">${item.address!""}</td>
									<td style="text-align: center;">${item.postcode!""}</td>
									<td style="text-align: center;">${item.phone!""}</td>
									<td style="text-align: center;">${item.mobile!""}</td>
									<td nowrap="nowrap" style="text-align: center;">
										<#if item.isDefault>
											<input type="radio" name="setDefaultRadio" value="${item.id!""}" checked="checked"/>
										<#else>
											<input type="radio" name="setDefaultRadio" value="${item.id!""}"/>
										</#if>
									</td>
									<td style="text-align: center;" nowrap="nowrap">
										<a href="${basepath}/member/addressEdit?id=${item.id!""}">
											修改
										</a>|
										<a onclick="return deletes();" href="${basepath}/member/addressDelete?id=${item.id!""}">
											删除
										</a>
									</td>
								</tr>
							</#list>
						</table>
					<#else>
						<!-- 
						<div class="bs-callout bs-callout-danger author" style="text-align: left;font-size: 14px;margin: 2px 0px;">
							还没有任何配送信息！赶紧添加吧。
						</div>
						 -->
						
						<div class="col-xs-12">
							<hr>
							<div class="row">
								<div class="col-xs-12" style="font-size: 14px;font-weight: normal;">
									<div class="panel panel-default">
							              <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
								              <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
								              		<span class="glyphicon glyphicon-user"></span>亲，还没有任何配送信息哦！赶紧<a href="${basepath}/member/addressAdd" class="btn btn-link">添加</a>吧。
								              </div>
							              </div>
									</div>
									<hr>
								</div>
							</div>
							
						</div>
						
					</#if>
					
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript">
$(function() {
	$("input[name=setDefaultRadio]").click(function(){
		var _url = "setAddressDefault?id="+$(this).val();
		//alert(_url);
		$.ajax({
		  type: 'POST',
		  url: _url,
		  data: {},
		  success: function(data){
			  alert("修改默认地址成功！");
		  },
		  dataType: "json",
		  error:function(){
			alert("操作失败，请联系管理员或更换浏览器再试!");				  
		  }
		});
	});
});
function search(){
	var _key = $.trim($("#key").val());
	if(_key==''){
		return false;
	}
	$("#searchForm").submit();
}
function deletes(){
	return confirm("确定删除选择的记录?");
}
</script>
</@html.htmlBase>