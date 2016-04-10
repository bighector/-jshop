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
        <div class="row">
            <form role="form" id="form" class="form-horizontal" method="post" action="saveAddress" theme="simple">
                <input type="hidden"  name="id" value="${address.id!""}"/>
                <div class="form-group">
                    <label for="receiver" class="col-lg-2 control-label">收货人姓名</label>
                    <div class="col-lg-6">
                        <input type="text"  value="${address.receiver!""}" name="receiver"  type="text"
                               class="form-control" id="receiver" data-rule="收货人姓名:required;length[2~8];name;" placeholder="请输入收货人姓名" maxlength="8" size="8"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="province" class="col-lg-2 control-label">地址区域</label>
                    <div class="col-lg-3">
                        <select name="province" id="province" class="form-control">
                            <option value="">--选择省份--</option>
                        <#list provinces as item>
                            <option value="${item.areaCode}" ${(address.province??&&address.province==item.areaCode)?string("selected", "")}>${item.areaName}</option>
                        </#list>
                        </select>
                    </div>
                    <div class="col-lg-3">
                        <select class="form-control" id="citySelect" name="city">
                            <option value="">--选择城市--</option>
                        <#list cities as item>
                            <option value="${item.areaCode}" ${(address.city??&&address.city==item.areaCode)?string("selected", "")}>${item.areaName}</option>
                        </#list>
                        </select>
                    </div>

                    <div class="col-lg-3">
                        <select class="form-control" id="areaSelect" name="area">
                            <option value="">--选择区县--</option>
                        <#list areas as item>
                            <option value="${item.areaCode}" ${(item.areaCode??&&address.area==item.areaCode)?string("selected", "")}>${item.areaName}</option>
                        </#list>
                        </select>
                    </div>

                </div>
                <div class="form-group">
                    <label for="address" class="col-lg-2 control-label">地址</label>
                    <div class="col-lg-6">
                        <input type="text"  value="${address.address!""}" name="address"  type="text"
                               class="form-control" id="address" data-rule="地址:required;length[0~70];address;" placeholder="请输入收货人地址" maxlength="70" size="70"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="postcode" class="col-lg-2 control-label">邮编</label>
                    <div class="col-lg-6">
                        <input type="text"  value="${address.postcode!""}" name="postcode"  type="text"
                               class="form-control" id="postcode" data-rule="邮编:required;length[6];postcode;" placeholder="请输入收货人邮编" size="6" maxlength="6"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="mobile" class="col-lg-2 control-label">手机</label>
                    <div class="col-lg-6">
                        <input type="text"  value="${address.mobile!""}" name="mobile"  type="text"
                               class="form-control" id="mobile" data-rule="手机:required;length[10~15];mobile;" placeholder="请输入收货人手机" maxlength="15"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-lg-2 control-label">电话号码</label>
                    <div class="col-lg-6">
                        <input type="text"  value="${address.phone!""}" name="phone"  type="text"
                               class="form-control" id="phone" data-rule="电话号码:length[0~15];phone;" placeholder="请输入收货人座机号码" maxlength="15"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-6">
                        <button type="submit" class="btn btn-success btn-sm" value="保存">
                            <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
                        </button>
                    </div>
                </div>
            </form>
        </div>
        </div>
    </div>
</div>
<script>
$(function() {

    /**
     * 省份下拉框变动
     */
    $("#province").change(function(){
        var selectVal = $(this).val();
        if(!selectVal){
            console.log("return;");
            return;
        }
        var _url = "${basepath}/area/loadAreasByParentCode?parentCode="+selectVal;
        $("#citySelect").empty().show().append("<option value=''>--选择城市--</option>");
        $("#areaSelect").empty().show().append("<option value=''>--选择区县--</option>");
        $.ajax({
            type: 'POST',
            url: _url,
            data: {},
            dataType: "json",
            success: function(data){
                //console.log("changeProvince success!data = "+data);
                $.each(data,function(index,value){
                    //console.log("index="+index+",value="+value.code+","+value.name);
                    $("#citySelect").append("<option value='"+value.areaCode+"'>"+value.areaName+"</option>");
                });
            },
            error:function(er){
                console.log("changeProvince error!er = "+er);
            }
        });
    });

    $("#citySelect").change(function() {
        var selectCityVal = $(this).val();
        if(!selectCityVal){
            return;
        }
        var _url = "${basepath}/area/loadAreasByParentCode?parentCode="+selectCityVal;
        $("#areaSelect").empty().show().append("<option value=''>--选择区县--</option>");
        $.ajax({
            type: 'POST',
            url: _url,
            data: {},
            dataType: "json",
            success: function(data){
                //console.log("changeProvince success!data = "+data);
                $.each(data,function(index,value){
                    $("#areaSelect").append("<option value='"+value.areaCode+"'>"+value.areaName+"</option>");
                });
            },
            error:function(er){
                console.log("changeCity error!er = "+er);
            }
        });
    });
});
</script>
</@html.htmlBase>