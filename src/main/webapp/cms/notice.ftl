<#import "/template/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<@html.htmlBase>
		<@menu.menu selectMenu=""/>
	<div class="container">
		<div class="row">
			<div class="col-xs-9">
				<div class="row">
					<div class="col-xs-12">
						<ol class="breadcrumb">
						  <li><a href="${basepath}">首页</a></li>
						  <li><a href="${basepath}/cms/notice/index.html">公告新闻</a></li>
						  <li class="active">${notice.title!""}</li>
						</ol>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						  	<h3><strong style="color:#dd4814;">${notice.title!""}</strong></h3>
						  	<div style="text-align: right;"><small>${notice.createAccount!"管理员"} 发布于:${notice.createTime?datetime}</small></div>
						<hr style="margin-top: 5px;">
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						${notice.content!""}
					</div>
				</div>
			</div>
			
			<!-- 右边公共部分 -->
			<div class="col-xs-3">
				<div class="row">
				<#include "/index_notice_slide.ftl"/>
				</br>
				<#include "/productlist_left_picScroll.ftl"/>
				</div>
			</div>
		</div>
	</div>
</@html.htmlBase>
