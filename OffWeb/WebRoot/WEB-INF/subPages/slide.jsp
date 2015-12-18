<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<s:iterator value="@cn.wegoteam.shop.cache.StaticDataCache@getStaticdatas('INDEXSLIDE','SLIDE')" status="slide">
								<li data-target="#carousel-example-generic" data-slide-to="<s:property value="#slide.index" />" 
									class="<s:if test="#slide.first">active</s:if>"></li>
							</s:iterator>
						</ol>
						<div class="carousel-inner">
							<!-- 三张图片轮播，直接指定src即可 -->
							<s:iterator value="@cn.wegoteam.shop.cache.StaticDataCache@getStaticdatas('INDEXSLIDE','SLIDE')" status="slide">
								<div class="slide-img item<s:if test="#slide.first"> active</s:if>">
									<a href="${link}" target="_blank"><img alt="First slide" style="background-size:auto;" src="${value}" /></a>
									<s:if test="!lang.equals('NO')">
										<div class="index-slide-text r2 a">
											<a href="${link}" target="_blank">${lang}</a>
										</div> 
									</s:if>
								</div>
							</s:iterator>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left"></span>
						</a>
						<a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"></span>
						</a>
</div>

					