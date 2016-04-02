<#macro htmlBase title="Ofmall" jsFiles=[] cssFiels=[] nobody=false >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <#assign non_responsive2>y</#assign>
    <#assign responsive>${Session["responsive"]!""}</#assign>
    <#if responsive == "y">
        <#assign non_responsive2>n</#assign>
    <#elseif systemSetting().isResponsive>
        <#assign non_responsive2>n</#assign>
    <#else >
        <#assign non_responsive2>y</#assign>
    </#if>
    <#assign style>${RequestParameters.style!""}</#assign>
    <#if style=="">
        <#assign style>${systemSetting().style}</#assign>
    </#if>

    <!-- <link rel="stylesheet" href="http://v3.bootcss.com/dist/css/bootstrap.css"  type="text/css"> -->

    <script>
        var basepath = "${basepath}";
        var staticpath = "${staticpath}";
        var non_responsive2 = "${non_responsive2}";
        <#if currentUser()??>
            var login = true;
        var currentUser = "${currentUser().username}";
        <#else >
        var login = false;
        var currentUser = "";
        </#if>
    </script>
    <#if non_responsive2 != "y">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </#if>
    <meta name="description" content="${systemSetting().description}"/>
    <meta name="keywords" content="${systemSetting().keywords}"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${title!"Ofmall"}</title>
    <link rel="shortcut icon" type="image/x-icon" href="${systemSetting().shortcuticon}">
    <link rel="stylesheet" href="${basepath}/resource/css/sticky-footer.css"  type="text/css">
    <link rel="stylesheet" href="${basepath}/resource/css/base.css"  type="text/css">
    <link rel="stylesheet" href="${basepath}/resource/bootstrap3.3.4/css/${style}/bootstrap.min.css"  type="text/css">
    <link rel="stylesheet" href="${basepath}/resource/bootstrap3.3.4/css/docs.css"  type="text/css">
    <link rel="stylesheet" href="${basepath}/resource/validator-0.7.0/jquery.validator.css" />
    <#if non_responsive2 == "y">
        <link rel="stylesheet" href="${basepath}/resource/bootstrap3.3.4/css/non-responsive.css"  type="text/css">
    </#if>

    <script type="text/javascript" src="${basepath}/resource/js/jquery-1.9.1.min.js"></script>

    <script type="text/javascript" src="${basepath}/resource/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${basepath}/resource/js/jquery.blockUI.js"></script>

    <script type="text/javascript" src="${basepath}/resource/validator-0.7.0/jquery.validator.js"></script>
    <script type="text/javascript" src="${basepath}/resource/validator-0.7.0/local/zh_CN.js"></script>

    <script type="text/javascript" src="${basepath}/resource/js/jquery.lazyload.min.js"></script>
    <script type="text/javascript" src="${basepath}/resource/js/superMenu/js/new.js"></script>
    <link href="${basepath}/resource/js/slideTab2/css/lanrenzhijia.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${basepath}/resource/js/slideTab2/js/lanrenzhijia.js"></script>

</head>
    <#if nobody>
        <#if !systemSetting().isOpen>
        ${systemSetting().closeMsg!"系统关闭，请联系管理员"}
            <#return />
        </#if>
        <#nested />
    <#else >
    <body>
        <#if !systemSetting().isOpen>
        ${systemSetting().closeMsg!"系统关闭，请联系管理员"}
            <#return />
        </#if>
        <#nested />
        <#include "/template/foot.ftl">
        <#include "/index_superSlide_js.ftl">
    </body>
    </#if>
</html>
</#macro>
