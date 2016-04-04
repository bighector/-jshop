<#import "/template/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<@html.htmlBase>
<style type="text/css">
.centerImageCss{
	width: 560px;
	height: 180px;
}
</style>
<div id="wrap">
	<@menu.menu selectMenu=""/>
	<div class="container">
		<div class="row">
			<div class="col-xs-3">
				<div class="panel panel-primary">
                	<div class="panel-heading">帮助中心</div>
                  <div class="panel-body">
                    	<ul>
                			<#list GlobalData["cms.articleCategoryList"] as item>
                			<li class="list-item0">
                				<h5>
                					${item.categoryName!""}
                				</h5>
                				<#if item.articles?? && item.articles?size gt 0>
                				<#list item.articles as item>
                					<div style="margin-left: 20px;">
                						<a href="${basepath}/cms/article/${item.code!""}.html">${item.title!""}</a>
                					</div>
                				</#list>
                				</#if>
                			</li>
                			</#list>
                    	</ul>
                  </div>
                </div>
			</div>
			<#if articleCode?? && articleCode=="index">
				<div class="col-xs-9">
					<!-- 导航条 -->
					<div class="row">
						<div class="col-xs-12">
							<ol class="breadcrumb">
							  <li><a href="${basepath}">首页</a></li>
							      <li class="active"><a href="${basepath}/cms/article/index.html">帮助中心</a></li>
							</ol>
						</div>
					</div>
					<div class="row"><hr></div>
					<div class="row">
						TODO:帮助中心首页内容
					</div>
				</div>
			<#else>
				<div class="col-xs-9">
					<!-- 导航条 -->
					<div class="row">
						<div class="col-xs-12">
							<ol class="breadcrumb">
							  <li><a href="${basepath}">首页</a></li>
							  <#if articleCode?? && articleCode=="index">
							      <li class="active">帮助中心</li>
							  <#else>
							  	  <li><a href="${basepath}/cms/article/index.html">帮助中心</a></li>
								  <li class="active">${article.title!""}</li>
							  </#if>
							</ol>
						</div>
					</div>
		
					<div class="row">
						<div class="col-xs-12">
							<strong>${article.title!""}</strong>
							<hr>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							${article.content!""}
						</div>
					</div>
				</div>
			</#if>
		</div>
	</div>
</div>	
</@html.htmlBase>