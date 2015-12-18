<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>slide1</TITLE>
<link rel="stylesheet" type="text/css" href="slides/css_1/style.css?9d92229" media="screen">
<script type="text/javascript" src="slides/js_1/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="slides/js_1/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="slides/js_1/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript">
//Slider
jQuery(window).load(function() {
	jQuery('#slider').nivoSlider({
	effect: 'fold',
	slices:15,
	animSpeed:500, //Slide transition speed
	pauseTime:5000,
	controlNav: false,
	directionNavHide: false,
	prevText: 'prev',
	nextText: 'next',
	startSlide:0, //Set starting Slide (0 index)
	directionNav:true, //Next &amp; Prev
	afterLoad: function(){
		jQuery(".nivo-caption").animate({top:"60"}, {easing:"easeOutBack", duration: 500})
		},
		beforeChange: function(){
		jQuery(".nivo-caption").animate({top:"-300"}, {easing:"easeInBack", duration: 500})
		},
		afterChange: function(){
		jQuery(".nivo-caption").animate({top:"60"}, {easing:"easeOutBack", duration: 500})
		}
	});
	
});

</script>

</head>

<body>

<div id="slider-container">

	<div id="slider" class="nivoSlider">
		<s:iterator value="@cn.wegoteam.shop.cache.StaticDataCache@getStaticdatas('INDEXSLIDE','SLIDE')" id="slide">
			<a href="javascript:void(0);"><img title="#${id}" alt="" src="<s:property value="@cn.wegoteam.shop.util.Html@imgSrc(value)"/>"></a>	
		</s:iterator>
	</div><!-- #slider -->
	<s:iterator value="@cn.wegoteam.shop.cache.StaticDataCache@getStaticdatas('INDEXSLIDE','SLIDE')" id="slide">
		<div id="${id}" class="nivo-html-caption">
		<span class="sdate"></span>
		<h1><a href="${link}" target="_blank">${name}</a></h1>
		<br/>
		<p>${description}</p>
		</div>
	</s:iterator>
	
	
</div>
</body>
</html>
