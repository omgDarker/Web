package cn.wegoteam.shop.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import cn.crap.base.PageBean;

/**
 * 
 * 
 *
 */
public class PageTag extends SimpleTagSupport {
	// 根路径
	// 后台处理分页显示的servlet的路径，当采用局部刷新时，path=ation|target（action名字，局部刷新div）
	private String path;
	// 分页分装类 存放所有分页信息
	private PageBean page;
	// 传递的参数
	private Map<String, String> paramMap;// 存放参数 和值
	//显示风格
	/**
	 * NUM：数字
	 * UPDOWN：上一页下一页
	 * MORE：加载更多
	 * 
	 * SMALL：小号字体
	 * 
	 * M10:margin 10
	 * 
	 */
	private String style="NUM,UPDOWN";
	// private List paramList; yonglist方法

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		StringBuffer pageHtml = new StringBuffer();
		String istyle = " ";
		if(style.contains("M10"))
			istyle+= "class=\"m10\"";
		/******************************* 首页 *************************/
		pageHtml.append("<form id=\"pageForm\" "+istyle+" action=\""
				+ path + "\" method=\"post\">");
		
		istyle = " ";
		if(style.contains("SMALL"))
			istyle+= "pagination-sm ";
		
		pageHtml.append("<input type=\"hidden\" id=\"currentPage\" name=\"pageBean.currentPage\" value=\""
				+ page.getCurrentPage() + "\">");
		pageHtml.append("<input type=\"hidden\" id=\"totalPage\" name=\"pageBean.totalPage\" value=\""
				+ page.getTotalPage() + "\">");
		//totalPage与allRow不能同时传，同时传递时，若在action重新设置pageSize会有bug
		pageHtml.append("<input type=\"hidden\" name=\"pageBean.allRow\" value=\""
				+ page.getAllRow() + "\">");
		pageHtml = getParams(pageHtml);
		String link;
		if(path.indexOf("|")>0){
			path = path.replace("|", "','");
			link = "<a href=\"javascript:void(0);\" onclick=\"ajaxTurning(%s,'"+path+"');\">%s</a>";
		}else
			link = "<a href=\"javascript:void(0);\" onclick=\"pageTurning(%s);\">%s</a>";
		/***********数字*************/
		if(style.contains("NUM")){
			//如果显示上一页、下一页，则居左显示
			String ifloat = "";
			if(!style.contains("UPDOWN"))
				ifloat += " fr";
			else
				ifloat += " hidden-xs";
			pageHtml.append("<ul class=\"pagination m0 mt10"+ifloat+istyle+"\">");
			if (page.getCurrentPage() == 1)
				pageHtml.append(" <li class=\"disabled\">");
			else
				pageHtml.append(" <li>");
			pageHtml.append(String.format(link, 1 + "", "«"));
			pageHtml.append("</li>");

			/******************************* 数字**上下各输出3个 *************************/
			int star = page.getCurrentPage() - 3 < 1 ? 1 : page
					.getCurrentPage() - 3;
			int end = page.getCurrentPage() + 3 > page.getTotalPage() ? page
					.getTotalPage() : page.getCurrentPage() + 3;
			for (int j = star; j <= end; j++) {
				if (j == page.getCurrentPage()) {// 将当前页面设置背景为红色
					pageHtml.append("<li class=\"active\">");
				} else {
					pageHtml.append("<li>"); // <div id="num">开始
				}
				pageHtml.append(String.format(link, j + "", j + ""));
				pageHtml.append("</li>");// <div id="num">结束
			}
			/******************************* 末页 ***************************/
			if (page.getCurrentPage() == page.getTotalPage())
				pageHtml.append(" <li class=\"disabled\">");
			else
				pageHtml.append(" <li>");

			pageHtml.append(String.format(link, page.getTotalPage() + "", "»"));
			pageHtml.append("</li></ul>");
		}
		/***********End:数字*************/
		/***********上一页，下一页*************/
		if(style.contains("UPDOWN")){
			pageHtml.append("<ul class=\"pagination m0 mt10 fr"+istyle+"\">");
			if (page.getCurrentPage() == 1)
				pageHtml.append(" <li class=\"disabled\">");
			else
				pageHtml.append(" <li>");

			pageHtml.append(String.format(link, page.getCurrentPage()>1?page.getCurrentPage() - 1:1, "上一页"));
			pageHtml.append("</li>");

			if (page.getCurrentPage() == page.getTotalPage())
				pageHtml.append(" <li class=\"disabled\">");
			else
				pageHtml.append(" <li>");

			pageHtml.append(String.format(link, page.getCurrentPage()<page.getTotalPage()?page.getCurrentPage() + 1:page.getTotalPage(), "下一页"));
			pageHtml.append("</li></ul>");
		}
		/***********End:上一页，下一页*************/
		/***********More*************/
		if(style.contains("MORE")){
			istyle = " ";
			if(style.contains("SMALL"))
				istyle+="btn-sm";
			link = "<a href=\"javascript:void(0);\" id=\"loadingMore\" class=\"btn btn-default w"+istyle+"\" onclick=\"moreTurning('"+path+"');\"><i class=\"iconfont\">&#xe610;</i>&nbsp;&nbsp;查看更多...</a>";
			pageHtml.append(link);
		}
		
		
		pageHtml.append("<div class=\"cb\"></div>");
		pageHtml.append("</form>");
		out.println(pageHtml);// 输出
		super.doTag();
	}

	public StringBuffer getParams(StringBuffer pageHtml) {
		// 设置参数用map方法设置参数 和值
		if (paramMap != null) {
			Set<String> keyset = paramMap.keySet();
			for (Iterator<String> iterator = keyset.iterator(); iterator
					.hasNext();) {
				String paramKey = (String) iterator.next();// 参数名
				String paramValue = (String) paramMap.get(paramKey);// 参数值
				pageHtml.append("<input type=\"hidden\" id=\"" + paramKey + "\" name=\"" + paramKey + "\" value=\"" + paramValue + "\">");
			}
		}
		return pageHtml;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public PageBean getPage() {
		return page;
	}

	public void setPage(PageBean page) {
		this.page = page;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
