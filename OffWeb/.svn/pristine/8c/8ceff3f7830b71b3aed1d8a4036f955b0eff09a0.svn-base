<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/manage/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>E通世界</title>
    <link href="<%=basePath%>lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <link href="<%= basePath%>lib/ligerUI/skins/Gray/css/dialog.css" rel="stylesheet" type="text/css" /> 
    <script src="<%=basePath%>lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>    
    <script src="<%=basePath%>lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
   
    
        <script type="text/javascript">
            var tab = null;
            var accordion = null;
            var tree = null;
            $(function ()
            {

                //布局
                $("#layout1").ligerLayout({ leftWidth: 190,isRightCollapse: true, height: '100%',heightDiff:-34,space:4, onHeightChanged: f_heightChanged });

                var height = $(".l-layout-center").height();

                //Tab
                $("#framecenter").ligerTab({ height: height });

                //面板
                $("#accordion1").ligerAccordion({ height: height - 24, speed: 200 });

                $(".l-link").hover(function ()
                {
                    $(this).addClass("l-link-over");
                }, function ()
                {
                    $(this).removeClass("l-link-over");
                });
               

                tab = $("#framecenter").ligerGetTabManager();
                accordion = $("#accordion1").ligerGetAccordionManager();
                tree = $("#tree1").ligerGetTreeManager();
                $("#pageloading").hide();

            });
            function f_heightChanged(options)
            {
                if (tab)
                    tab.addHeight(options.diff);
                if (accordion && options.middleHeight - 24 > 0)
                    accordion.setHeight(options.middleHeight - 24);
            }
            function f_addTab(tabid,text, url)
            { 
                tab.addTabItem({ tabid : tabid,text: text, url: url });
            } 
             
            function deleteCache()
            {
            	$.ajax({
            		url:'clear',
            		data:'',
            		success:function(data){
            			showtip(data);
            		}
            	});
            }
            function showtip(state){
                if(state==1||state=='true'||state=='success'){
                 tip = $.ligerDialog.tip({  title: '提示信息',content:'操作成功!' });
                }
                else tip = $.ligerDialog.tip({  title: '提示信息',content:'抱歉，操作失败。'});
           		setTimeout(function () { tip.close(); }, 2000);
            }
     </script> 
     
<style type="text/css"> 
    body,html{height:100%; min-width:1024px;}
    body{ padding:0px; margin:0;   overflow:hidden;}  
    .l-link{ display:block; height:26px; line-height:26px; padding-left:10px; text-decoration:underline; color:#333;}
    .l-link2{text-decoration:underline; color:white; margin-left:2px;margin-right:2px;}
    .l-layout-top{background:#102A49; color:White;}
    .l-layout-bottom{ background:#E5EDEF; text-align:center;}
   	#pageloading{position:absolute; left:0px; top:0px; background:white url('<%=basePath%>lib/images/loading.gif') no-repeat center; width:100%; height:100%;z-index:99999;}
    .l-link{ display:block; line-height:22px; height:22px; padding-left:16px;border:1px solid white; margin:4px;}
    .l-link-over{ background:#FFEEAC; border:1px solid #DB9F00;} 
    .l-winbar{ background:#2B5A76; height:30px; position:absolute; left:0px; bottom:0px; width:100%; z-index:99999;}
    .space{ color:#E7E7E7;}
    /* 顶部 */ 
    .l-topmenu{ margin:0; padding:0; height:80px; line-height:31px; background:url('<%=basePath%>lib/images/bg_top.gif');  position:relative; border-top:1px solid #1D438B;  }
    .l-topmenu-logo{ color:#E7E7E7; padding-left:35px; padding-top:7px; float: left;}
    .l-topmenu-welcome{  position:absolute; height:24px; line-height:24px;  right:15px; bottom:5px;color:#FFF; cursor:default;}
    .l-topmenu-welcome a{ color:#E7E7E7; text-decoration:underline; font-weight:bold; color:#6CF;} 
	.l-topmenu-caption{ float:left; height:50px; margin-left:20px; font-size:25px; color:#FFF; margin-top:20px;text-shadow: 0 0 25px #555; cursor:default;
 </style>
 <style type="text/css">
        .l-case-title
        {
            font-weight: bold;
            margin-top: 20px;
            margin-bottom: 20px;
        }
 </style>
</head>
<body style="padding:0px;background:#EAEEF5;">  
<div id="pageloading">

</div>  
<div id="topmenu" class="l-topmenu">
    <div class="l-topmenu-logo">
		<!-- <img src="<%=basePath%>lib/images/logo.png" width="65" height="65"/> -->
	</div>
	<div class="l-topmenu-caption">E通世界后台管理系统<br/>
		<p style=" font-size:12px; line-height:12px; margin-top:5px;"></p>
	</div>
    <div class="l-topmenu-welcome">
        当前用户：
       ${username }（${userPrivilege}）
        <span class="space">|</span>
        <a class="l-link2" onclick="deleteCache();" style="cursor: pointer;">清除缓存</a>
        <span class="space">|</span>
        <a href="logOut" class="l-link2" target="_self">退出</a>
    </div> 
</div>
  <div id="layout1" style="width:99.2%; margin:0 auto; margin-top:4px; "> 
        <div position="left"  title="主要菜单" id="accordion1"> 
        		<s:iterator
						value="@cn.wegoteam.shop.cache.StaticDataCache@getStaticdatas('ADMIN_MENU','NO')">
                    <div title="${name}">
                    <div style=" height:7px;"></div>
                    	<s:iterator value="@cn.wegoteam.shop.cache.StaticDataCache@getStaticdatas(code,'NO')">
                         <a class="l-link" href="javascript:f_addTab('${name}','${name}','${link}')">${name}</a> 
						</s:iterator>
                    </div>    
             	 </s:iterator>
        </div>
        <debug></debug>
        <div position="center" id="framecenter"> 
            <div tabid="home" title="主页" style="height:300px" >
                <iframe frameborder="0" name="home" id="home" src="http://www.baidu.com"></iframe>
            </div> 
        </div> 
  </div>
    <div  style="height:32px; line-height:32px; text-align:center;">
            Copyright © 2014-2016 WEGOTeam
    </div>
</body>
</html>
