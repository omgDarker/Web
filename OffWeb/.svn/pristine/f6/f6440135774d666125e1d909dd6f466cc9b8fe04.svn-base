<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 在线客服 -->
<div id="custom-service" class="hidden-xs r2 custom-service tc">
	<ul>
		<li class="transition n-border" onmouseover="asynLoad('asynLoad','QQ','&p_type=QQ')">
			<i class="iconfont">&#xe609;</i>
			<div class="content h50" id="QQ"></div>
			<div class="triangle"><i class="iconfont f20">&#xe62e;</i></div>
		</li>
		<li class="transition">
			<i class="iconfont">&#xe623;</i>
			<div class="content w120">
				<s:property value="@Static@getStatic('L_PHONE').lang"/><br>
				${KF_PHONE}
			</div>
			<div class="triangle"><i class="iconfont f20">&#xe62e;</i></div>
		</li>
		<li class="transition">
			<i class="iconfont">&#xe627;</i>
			<div class="content w120">
				<s:property value="@Static@getStatic('L_EMAIL').lang"/><br>
				${KF_EMAIL}
			</div>
			<div class="triangle"><i class="iconfont f20">&#xe62e;</i></div>
		</li>
		<li class="transition"><i class="iconfont">&#xe62a;</i></li>
		<li class="transition" onmouseover="asynLoad('asynLoad','bdsharebuttonbox','&p_type=baiduShare&pageTitle=${pageTitle}&basePath=<%=basePath%>')">
			<i class="iconfont">&#xe607;</i>
			<div class="content w120 h100" id="bdsharebuttonbox"></div>
			<div class="triangle"><i class="iconfont f20">&#xe62e;</i></div>
		</li>
		<li class="transition n-border" id="go_top">
			<i class="iconfont">&#xe608;</i>
			<div class="content"><s:property value="@Static@getStatic('L_TOTOP').lang"/></div>
			<div class="triangle"><i class="iconfont f20">&#xe62e;</i></div>
		</li>
		</ul>
</div>
<!-- 搜索框 需要改为异步加载-->
<div id="hot_serach_list" class="keyword-list">
</div>

<!-- 提示窗口 -->
<div id="lookUp" class="look-up">
	<div id="lookUpContent" class="look-up-content"></div>
	<i class="iconfont i-close" onclick="iClose('lookUp')">&#xe628;</i>
</div>
<!-- 对话框 -->
<div class="imodal modal fade" id="myModal" role="dialog"
	aria-label="myModalLabel" aria-hidden="true">
	<div id="modal-dialog" class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body" id="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn btn-danger btn-xs"
					data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<div class="footer f12 pt20 shadow border-top-color">
	<div class="container">
		<div class="row pb10">
			<div class="col-md-5 visible-md-block visible-lg-block col-xs-12 p0">
				<span class="title pt10 pb10 f16"><s:property value="@Static@getStatic('L_INTRODUCTION').lang"/></span><br> 
				<span class="pt20">
					<!-- <s:property value="@cn.wegoteam.shop.cache.Cache@getNews('F_BRIEF').content" escape="false"/> -->
					<a href="http://www.pgyer.com/uxyv" class="fl w100" href="javascript:void(0);" target="_blank">
						<img src="images/ios.jpg"  class="fl" width="100px"/>
						<br/><span class="cb mt10 tc w100">IOS下载</span>
					</a>
					
					<a class="fl ml20 w100" href="http://zhushou.360.cn/detail/index/soft_id/3040905" target="_blank">
						<img src="images/android.jpg"  class="fl" width="100px"/>
						<br/><span class="cb mt10 tc w100">安卓下载</span>
					</a>
				</span>
			</div>
			<div class="col-md-3 col-sm-3 col-xs-12 p0 links">
				<span class="title pt10 pb10 f16"><s:property value="@Static@getStatic('L_FRIENDLY').lang"/></span><br> 
				<s:iterator
						value="@cn.wegoteam.shop.cache.StaticDataCache@getStaticdatas('L_FRIENDLY','NO')">
						<a href="${link}" style="color:#ffffff;">${description}${lang}</a>
				</s:iterator>
			</div>
			
			<div class="col-md-4 col-sm-5 col-xs-12 p0">
				<span class="title pt10 pb10 f16">
					<s:property value="@Static@getStatic('L_CONTACT').lang"/>
				</span><br>
				<ul>
					<li class="mt15">
						<div class="icon transition tc fl">
							<i class="iconfont f15">&#xe622;</i>
						</div>
						<div class="fl ml10">
							<span><s:property value="@Static@getStatic('L_ADDRESS').lang"/><br>
							<a href="#a"><s:property value="@Static@getStatic('ADDRESS').lang"/>
							</a>
							</span>
						</div>
						<div class="cb"></div></li>
					<li class="mt15">
						<div class="icon transition tc fl">
							<i class="iconfont f15">&#xe60a;</i>
						</div>
						<div class="fl ml10">
							<span><s:property value="@Static@getStatic('L_EMAIL').lang"/><br>
							<a href="#a">${KF_EMAIL}</a>
							</span>
						</div>
						<div class="cb"></div></li>
					<li class="mt15">
						<div class="icon transition tc fl">
							<i class="iconfont f15">&#xe623;</i>
						</div>
						<div class="fl ml10">
							<span><s:property value="@Static@getStatic('L_PHONE').lang"/><br>
							<a href="#a">${KF_PHONE}</a>
							</span>
						</div>
						<div class="cb"></div></li>
				</ul>
				<ul class="mt20">
					<li class="social-icons fl weibo tc"><a href="#a"> <i
							class="iconfont f20">&#xe62a;</i>
					</a></li>
					<li class="social-icons fl weixin tc"><a href="#a"> <i
							class="iconfont f20">&#xe61f;</i> </a></li>
					<li class="social-icons fl twitter tc"><a href="#a"> <i
							class="iconfont f20">&#xe603;</i> </a></li>
					<li class="social-icons fl facebook tc"><a href="#a"> <i
							class="iconfont f20">&#xe62b;</i> </a></li>
				</ul>
			</div>
			<div class="cb"></div>
		</div>
	</div>
</div>
<div class="copyrights f12 pb10 pt10">
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-xs-12 p0">
				<span class="pr20">© Copyright 2013 by <a href="#a">YTWORLD.CN</a>
					- All rights reserved</span>
			</div>
			<div class="col-sm-5 col-xs-12 p0">
				津<span>ICP</span>备<span> 15031289 </span>号&nbsp;&nbsp;
				 站点管理：&nbsp;&nbsp;<a href="http://mail.ytworld.cn/" target="_blank">YTWORLD邮箱</a>
				  | <a href="manageIndex">登录</a>
			</div>
			<div class="col-sm-3 col-xs-12 p0 icon">
				<a href="#"
					target="_blank" title="360安全监测" class="r2 transition"><i
					class="iconfont f18">&#xe628;</i>
				</a> <a href="#"
					title="安全联盟" target="_blank" class="r2 transition"><i
					class="iconfont f16">&#xe60d;</i>
				</a>
			</div>
		</div>
	</div>
</div>
<%@include file="../subPages/js.jsp"%>
