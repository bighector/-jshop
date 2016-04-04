<#import "/template/common_html_front.ftl" as html/>
<#import "/indexMenu.ftl" as menu/>
<@html.htmlBase>
<style>
	#advert img{
		max-width: 364px;
		max-height: 290px;
		border:0px;
	}
	#otherLogin a:hover{
		text-decoration: none;
	}
</style>
<input value="${systemSetting().website}" type="hidden" id="wwwInput"/>
	<@menu.menu/>
	<div class="container">
		<div class="row">
			<div class="col-xs-4" style="background-color:#fff;border:0px;">
				<div id="advert" style="text-align: center;">
				<#--
					<#include "/advert/advert_login_page.ftl"/>
					 -->
				</div>
			</div>
			
			<div class="col-xs-8">
				<caption>
					<#if errorMsg??>
					<div class="bs-callout bs-callout-danger author" style="text-align: left;font-size: 14px;margin: 2px 0px;">
						<strong>登陆失败!</strong> ${errorMsg}
					</div>
					</#if>
				</caption>
				
				<div class="panel panel-success" style="width:500px;">
		              <div class="panel-heading">
		                <h3 class="panel-title">
		                	<span class="glyphicon glyphicon-user"></span>&nbsp;用户登陆
		                </h3>
		              </div>
		              <div class="panel-body">
	              		<form role="form" id="form" class="form-horizontal" action="${basepath}/member/doLogin" method="post" theme="simple">
						  <div class="form-group">
						    <label for="account" class="col-md-2 control-label">账号</label>
						    <div class="col-md-6">
							    <input  name="username" type="text" class="form-control" id="account" data-rule="账号:required;username;" placeholder="请输入账号" />
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="password" class="col-md-2 control-label">密码</label>
						    <div class="col-md-6">
							    <input name="password" type="password" class="form-control" id="password" data-rule="密码:required;password;" placeholder="请输入密码" />
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-md-offset-2 col-md-6">
							    <a href="${basepath}/member/register">没有帐号?立即注册</a>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <div class="col-md-offset-2 col-md-6">
						      <button type="submit" class="btn btn-success btn-sm" value="登陆">
						      	<span class="glyphicon glyphicon-ok"></span>&nbsp;登陆
						      </button>
						      <a href="${basepath}/member/forgetPassword">忘记密码?</a>
						    </div>
						  </div>
						</form>
		              </div>
	            </div>
			</div>
		</div>
	</div>

</@html.htmlBase>