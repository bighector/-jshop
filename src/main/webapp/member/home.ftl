<#import "/template/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<#import "/member/memberMenu.ftl" as memberMenu>
<@html.htmlBase>
	<@menu.menu selectMenu=""/>
	<div class="container">
		<div class="row">
			<div class="col-xs-3">
				<@memberMenu.accountMenu currentMenu="personInfo"/>
			</div>
			
			<div class="col-xs-9">

                <div class="row">
                    <div class="col-xs-12">
                        <ol class="breadcrumb">
                            <li class="active">个人资料</li>
                        </ol>
                    </div>
                </div>

                <hr>
				<form method="post" role="form" id="form" class="form-horizontal" action="${basepath}/account/updateInfo" theme="simple">
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">昵称：</label>
				    <div class="col-lg-6">
				    	<label class="radio-inline" style="padding-left: 0px;">
							${e.nickname!e.username}
				    		(${e.username})
				    	</label>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">真实姓名：</label>
				    <div class="col-lg-6">
				    	<input name="realName" type="text" class="form-control" id="realName" value="${e.realName!""}" placeholder="请输入真实姓名"/>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">性别：</label>
				    <div class="col-lg-8">
						<input type="radio" name="gender" value="Male" ${(e.gender=="Male")?string("checked","")}>男
                        <input type="radio" name="gender" value="Female" ${(e.gender=="Female")?string("checked","")}>女
                        <input type="radio" name="gender" value="Unknown" ${(e.gender=="Unknown")?string("checked","")}>保密
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">生日：</label>
				    <div class="col-lg-3">
				    	<input id="birthDate" name="birthDate" class="Wdate form-control" value="${e.birthDate!""}"
				    	type="text" onFocus="WdatePicker({isShowClear:false,readOnly:true})"/>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">邮箱：</label>
				    <div class="col-lg-6">
						<label>${e.email!""}</label>
				    	<a href="${basepath}/member/changeEmail" class="btn btn-link btn-sm">修改邮箱</a>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">所在地：</label>
				    <div class="col-lg-3">
							<select name="province" id="province" class="form-control" onchange="changeProvince()">
								<option value="">--选择省份--</option>
								<#list provinces as item>
								    <option value="${item.code}" ${(e.province??&&e.province==item.code)?string("selected", "")}>${item.name}</option>
								</#list>
							</select>
					    </div>
					    <div class="col-lg-3">
							<select class="form-control" id="citySelect" name="city">
								<option value="">--选择城市--</option>
								<#list cities as item>
									<option value="${item.code}" ${(e.city??&&e.city==item.code)?string("selected", "")}>${item.name}</option>
								</#list>
							</select>
					    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="col-lg-offset-2 col-lg-6">
				      <input type="submit" class="btn btn-success btn-sm" value="保存"/>
				    </div>
				  </div>
				</form>
				
			</div>
		</div>
	</div>

<script type="text/javascript" src="${basepath}/resource/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(function() {
	//$("#birthday").addClass("form-control");
});
function changeProvince(){
	var selectVal = $("#province").val();
	if(!selectVal){
		console.log("return;");
		return;
	}
	var _url = "selectCitysByProvinceCode?provinceCode="+selectVal;
	$("#citySelect").empty().append("<option value=''>--选择城市--</option>");
	$.ajax({
	  type: 'POST',
	  url: _url,
	  data: {},
	  dataType: "json",
	  success: function(data){
		  //console.log("changeProvince success!data = "+data);
		  $.each(data,function(index,value){
			  //console.log("index="+index+",value="+value.code+","+value.name);
			  $("#citySelect").append("<option value='"+value.code+"'>"+value.name+"</option>");
		  });
	  },
	  error:function(er){
		  console.log("changeProvince error!er = "+er);
	  }
	});
}
</script>
</@html.htmlBase>