<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="商品规格">
<script type="text/javascript">
	$(function() 
	{
		$("#title").focus();
	});

	function onSubmit() 
	{
		if ($.trim($("#specification").val()) == "") {
			alert("名称不能为空!");
			$("#name").focus();
			return false;
		}
	}
</script>
<style>
	.leftTD_css
	{
		width: 100px;
		line-height:30px;
		text-align: right;
	}
	#insertOrUpdateMsg 
	{
		border: 0px solid #aaa;
		margin: 0px;position: fixed;top: 0;
		width: 100%;
		background-color: #d1d1d1;
		display: none;
		height: 30px;z-index: 9999;
		font-size: 18px
		;color: red;
	}
</style>


	<form action="${basepath}/manage/spec" theme="simple" id="form">
		<input type="hidden" value="${e.catalogID!""}" id="catalogID"/>
	  <table class="table table-bordered" id="myTable">
		
		<!--隐藏table 克隆专用-->
  	 	 <tbody id="ACE_HIDDEN_TABLE" style="display:none">
  	 	 	 <tr class="pclass">
				<td>
				  <button class="btn btn-danger" onclick="return removeThis(this);">
					  <i class="icon-remove-sign icon-white"></i> 删除
				  </button>
				</td>
				<td style="text-align: left;line-height:30px">
					名称:	<input type="text"  id="Vals" />
						<span style="margin-left:150px;"></span> 
				    显示顺序:<input type="text"  id="Orders" number="y" size="5" maxlength="5"/>
				</td>
				</tr>
  	 	 </tbody>
		
		 <tbody id="newTB">
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>规格编辑</strong>
				</td>
			</tr>
			<tr style="display: none;">
				<td>id</td>
				<td><input type="hidden" value="${e.id!""}" name="id" label="id" /></td>
			</tr>
			<tr>
				<td class="leftTD_css">分类目录</td>
				<td style="text-align: left;">
				
					<select onchange="" name="catalogID" id="catalogSelect" data-rule="required;select;">
						<option>衣服</option>	 
					</select><br>(请选择子类别)
				</td>
			</tr>
			<tr>
				<td class="leftTD_css">名称</td>
				<td style="text-align: left;">
					<input type="text"  
						value="${e.specification!""}" name="specification"  
						data-rule="required;specification;length[1~20];"
						id="specification" 
					/>
					
				</td>
			</tr>
			<tr>
				<td class="leftTD_css">顺序</td>
				<td style="text-align: left;">
				  <input type="text"  value="${e.ordinal!""}" name="ordinal" id="ordinal" 
				   data-rule="required;ordinal;length[1~20];"/>
				</td>
			</tr>
			
			<tr style="background-color: #dff0d8">
				<td>
					<input type="button" onclick="insertrow();" value="增加属性" class="btn btn-warning"/>
				</td>
				<td style="text-align: center;">
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
						
			<#if e.vaList?exists>
				<#list e.vaList as item>
					<tr class="pclass">
						<td>
						  <button class="btn btn-danger" onclick="return removeThis(this);">
					          <i class="icon-remove-sign icon-white"></i> 删除
				          </button>
						</td>
						<td style="text-align: left; line-height:30px;">
							名称:<input type="text"  name="specVals" id="specVals" value="${item.specVal!""}"
							data-rule="required;specVals";/>
							<span style="margin-left:150px;"></span>
							 显示顺序:
							<input type="text"  
							  name="specOrders"
							  id="specOrders"  
							  number="y" 
							  value="${item.ordinal!""}" 
							  size="5" maxlength="5" 
							  data-rule="required;specOrders;integer;length[1~5];"
							/>
						</td>
					</tr>
				</#list>
			</#if>
		  </tbody> 
		</table>
	</form> 

<script type="text/javascript">
	function insertrow()
	{	  		
  		var newrow =$("#ACE_HIDDEN_TABLE").clone();
  		newrow.find("input[id=Vals]").attr("name","specVals");
        newrow.find("input[id=Orders]").attr("name","specOrders");
        $("#newTB").append(newrow.children());
	}

	function removeThis(t)
	{
		$(t).parent().parent().remove();
		return false;
	}
</script>
</@page.pageBase>