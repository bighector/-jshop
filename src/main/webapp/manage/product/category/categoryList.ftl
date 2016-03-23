<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="分类目录">
<script type="text/javascript" src="${basepath}/resource/jquery-treegrid/jquery.easyui.min.js"></script>
  
<link rel="stylesheet" type="text/css" href="${basepath}/resource/jquery-treegrid/css/easyui.css">
<link rel="stylesheet" type="text/css" href="${basepath}/resource/jquery-treegrid/css/icon.css">
<script type="text/javascript">
  
    $(function() 
	{
		$("#treegrid").treegrid(
		{
			url:'${basepath}/manage/category/loadByPid',
			idField:'id',
			treeField:'id',
			fit:true,
			loadMsg:'数据加载中请稍后……', 
			columns:[[
			  {title:'类别名称',field:'cateName',width:130},
			  {title:'类别编码',field:'cateCode',width:130},
			  {title:'标题',   field:'page_title',width:100},
			  {title:'关键字',   field:'keywords',width:300},
			  {title:'描述',   field:'description',width:400}
			 ]],
			 onBeforeExpand:function(row)
			 {
			    var url = "${basepath}/manage/category/loadByPid?pid" + row.treeid;
			    $("#treegrid").treegrid("options").url = url;
			    return true;
			 }
			
		});		
	});
	
	
	
</script>

	<form action="${basepath}/manage/category" name="form" id="form" method="post" theme="simple">
		<table class="table table-bordered table-condensed table-hover">
			<tr>
				<td colspan="16">

					<a href="selectList" class="btn btn-primary">
						<i class="icon-search icon-white"></i> 查询
					</a>
						

					<a href="toAdd?" class="btn btn-success">
						<i class="icon-plus-sign icon-white"></i> 添加
					</a>
					
				</td>
			</tr>
		</table>
	</form>
	
 	<div class="alert alert-info" style="margin-bottom: 2px;">友情提示：商品目录一般分为三层，一层，二层，三层。商品目录编码必须唯一。</div>
	  <table id="treegrid" class="easyui-treegrid" style="min-width:800px;min-height:250px">
	</table>


</@page.pageBase>