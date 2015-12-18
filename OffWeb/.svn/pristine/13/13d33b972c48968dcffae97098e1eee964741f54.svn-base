<%@ page language="java" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@include file="../subPages/css.jsp"%>
<body>
	<%@include file="../subPages/top.jsp"%>
	<%@include file="../subPages/nav.jsp"%>
	<div class="w">
			<%@include file="../subPages/slide.jsp"%>
	</div>
			<!--<iframe unselectable="on" src="slide?num=1"
				style="margin-top:-30px;width: 100%; height:436px;" frameborder="no"
				border="0" scrolling="no"> </iframe> -->
	<div class="container">
		<div class="row m0">
			<s:iterator
				value="@cn.wegoteam.shop.cache.StaticDataCache@getStaticdatas('NAV','NAV')"
				status="nav">
				<s:if test="flag!=4"><!-- 4为促销商品，不在页面显示，只能通过主菜单进入 -->
					<div class="floor">
						<div class="floor-title fl">
							<s:property value="#nav.index+1" />F ${name}
						</div>
						<div class="floor-link fr">
							<s:iterator
								value="@cn.wegoteam.shop.cache.StaticDataCache@getStaticdatas(code,'SUBNAV')"
								status="st">
								<a class="link" href="category?p_second.code=${code}">${name}</a>
								<s:if test="!#st.last">
									<span>|</span>
								</s:if>
							</s:iterator>
						</div>
						<div class="cb"></div>
					</div>
					<div class="cb"></div>
				</s:if>
			</s:iterator>
		</div>
	</div>



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<%@include file="../subPages/footer.jsp"%>
	<script type="text/javascript">
		slideHeight();
	</script>
</body>
</html>
