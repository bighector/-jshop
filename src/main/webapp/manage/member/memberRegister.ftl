<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${basepath}/resource/bootstrap3.3.4/css/bootstrap.min.css"
	type="text/css">
<script type="text/javascript"
	src="${basepath}/resource/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${basepath}/resource/bootstrap3.3.4/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	font: 12px/150% Arial, Verdana, "\5b8b\4f53";
}

#process ul {
	position: absolute;
	margin-top: -38px;
	text-align: center;
	list-style: none;
}

#process .node ul {
	z-index: 1;
	width: 318px;
	margin-left: -192px;
}

#process .node {
	width: 13px;
}

#process .proce {
	width: 150px;
	border: solid #fff;
	border-width: 0 5px;
}

#process .proce ul {
	z-index: 5;
	width: 150px;
}

#process .node, #process .proce {
	float: left;
	position: relative;
	height: 13px;
	background-image:
		url(//misc.360buyimg.com/user/myjd-2015/widget/order-detail/i/bg_state.jpg);
	background-repeat: no-repeat;
}

#process .proce ul {
	z-index: 5;
	width: 150px;
}

#process {
	margin: 0 auto;
	padding: 20px 0 80px;
}

.section4 {
	width: 789px;
}

.proce.ready {
	background-position: 0 0;
}

.proce.active {
	background-position: 0 -20px;
}

.proce.wait {
	background-position: 0 -40px;
}

.node.ready {
	background-position: -150px 0;
}

.node.wait {
	background-position: -150px -40px;
}

ol, ul {
	list-style: none;
	list-style-type: none;
}

li {
	display: list-item;
	text-align: -webkit-match-parent;
}

#process .tx1 {
	height: 36px;
	margin-bottom: 16px;
}

#process .tx3 {
	color: #999;
	line-height: 15px;
}

ul, menu, dir {
	display: block;
	list-style-type: disc;
	-webkit-margin-before: 1em;
	-webkit-margin-after: 1em;
	-webkit-margin-start: 0px;
	-webkit-margin-end: 0px;
	-webkit-padding-start: 40px;
}

.panel {
	margin-bottom: 20px;
	background-color: #fff;
	border: 1px solid transparent;
	border-radius: 4px;
	-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
}

.panel-success {
	border-color: #d6e9c6;
}

.panel-success>.panel-heading {
	color: #468847;
	background-color: #dff0d8;
	border-color: #d6e9c6;
}
.focus{
	color:#666;
	width: 260px;
	line-height: 36px;
	background: #f7f7f7;
	border: 1px solid #dddddd;
	height: 36px;
	padding: 0 5px;
	border-radius:3px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 100px;">
			<div class="row">
				<div id="process" class="section4">
					<div class="node fore ready">
						<ul>
							<li class="tx1">&nbsp;</li>
							<li class="tx2">填写注册信息</li>
						</ul>
					</div>
					<div class="proce active">
						<ul>
							<li class="tx1">&nbsp;</li>
						</ul>
					</div>
					<div class="node wait">
						<ul>
							<li class="tx1">&nbsp;</li>
							<li class="tx2">邮箱激活</li>
							<li id="track_time_4" class="tx3"></li>
						</ul>
					</div>
					<div class="proce wait">
						<ul>
							<li class="tx1">&nbsp;</li>
						</ul>
					</div>
					<div class="node wait">
						<ul>
							<li class="tx1">&nbsp;</li>
							<li class="tx2">注册成功</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel panel-success">
				<div class="panel-body">
					<div class="col-md-10">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="nickname" class="col-md-2 control-label">昵称 :</label>
								<div class="col-md-4">
									<input name="nickname" type="text" class="form-control"
										id="nickname" placeholder="请输入昵称"
										data-rule="昵称:required;nickname;length[2~10];remote[unique.html]"
										maxlength="100">
								</div>
								<label id="regName_error" class="focus">数字，字符 xxxx</label>
							</div>

							<div class="form-group">
								<label for="account" class="col-md-2 control-label">账号:</label>
								<div class="col-md-4">
									<input name="account" type="text" class="form-control"
										id="account" placeholder="请输入账号"
										data-rule="账号:required;account;length[3~10];remote[unique.html]"
										maxlength="100">
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="col-md-2 control-label">密码:</label>
								<div class="col-md-4">
									<input name="password" type="password" class="form-control"
										id="password" placeholder="请输入密码" maxlength="100"
										data-rule="密码:required;password">
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="col-md-2 control-label">确认密码:</label>
								<div class="col-md-4">
									<input name="password2" type="password" class="form-control"
										id="password2" placeholder="请输入确认密码" maxlength="100"
										data-rule="确认密码:required;match(password)">
								</div>
							</div>

							<div class="form-group">
								<label for="email" class="col-md-2 control-label">邮箱:</label>
								<div class="col-md-4">
									<input name="email" type="text" class="form-control" id="email"
										maxlength="45"
										data-rule="邮箱:required;email;length[1~45];remote[unique.html]"
										placeholder="请输入邮箱，找回密码用的">
								</div>
							</div>

							<div class="form-group">
								<label for="vcode" class="col-md-2 control-label">验证码:</label>
								<div class="col-md-2">
									<input type="text" name="vcode" class="form-control" id="vcode"
										placeholder="验证码"
										data-rule="验证码:required;vcode;remote[unique.html]" size="4"
										maxlength="4">
								</div>
								<div class="col-md-4">
									<img src="http://wmall.tuhua365.cn//ValidateImage.do"
										id="codes2" onclick="javaScript:reloadImg2();"
										class="vcodeCss"> <a href="javascript:void(0);"
										onclick="javascript:reloadImg2();" class="btn btn-link btn-sm">看不清?换一张</a>
								</div>
							</div>

							<div class="form-group">
									<label for="link-zcxy" class="col-md-2 control-label">注册协议</label>
								<div class="col-md-4">
									<a target="_blank" id="link-zcxy" class="btn btn-link btn-md"
										href="http://wmall.tuhua365.cn//help/zcxy.html">jshop用户注册协议</a>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-offset-2 col-md-6">
									<button type="submit" class="btn btn-success btn-sm"
										value="注 册">
										<span class="glyphicon glyphicon-ok"></span>&nbsp;注册
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>