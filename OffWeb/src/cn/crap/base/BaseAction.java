package cn.crap.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T>, Preparable, SessionAware, ServletRequestAware,
		ServletResponseAware {

	private static final long serialVersionUID = 1L;
	protected T model;
	protected List<T> models = new ArrayList<T>();
	protected Map<String, Object> session;
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected Integer defaultSize = 10;
	protected final static String WEB = "/WEB-INF/web/";
	protected final static String NEWS = "/WEB-INF/web/news/";
	protected final static String SUBPAGES = "/WEB-INF/subPages/";
	protected final static String MANAGE = "/WEB-INF/manage/";
	/***************************admin*************************************/
	protected final static String ADMIN = "/WEB-INF/admin/";
	/***************************End:admin*********************************/
	protected String tipMessage;
	protected String pageTitle = "亿通世界";
	protected String pageMessage = "欢迎进入亿通世界";
	protected String pageName;
	//action查询条件
	protected Map<String, Object> map = new HashMap<String, Object>();
	protected PageBean pageBean = new PageBean(defaultSize);
	//struts2标签分页参数,新版后台json返回参数
	protected Map<String, Object> paramMap = new HashMap<String, Object>();
	protected Logger log;
	protected Class<?> clazz;
	// 后台列表页面顶部操作
	protected String operators;

	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			clazz = (Class<?>) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
			log = Logger.getLogger(clazz);
			operators = "<button class=\"l-button\" style='float:right;' onclick=\"addNewRow('"
					+ getClazz() + "')\">添加" + getClazz() + "</button>";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化后台加载数据
	 */
	public void initAdminList(String parentCode, String currentCode, String operators,Object parentPageStatic,Object currentPageStatic ){
		paramMap.put(Const.ParentPage, parentPageStatic);
		paramMap.put(Const.CurrentPage, currentPageStatic);
		paramMap.put("clazz", getClazz());
		paramMap.put(Const.SortName,getParameter(Const.SortName,"id"));
		paramMap.put(Const.SortOrder,getParameter(Const.SortOrder,"desc").equals("desc") ? Const.ImgSortDesc:Const.ImgSortAsc);
		paramMap.put("operators", operators);
	}
	// 重写getParameter方法
	public String getParameter(String arg, String defaultValue) {
		String temp = request.getParameter(arg);
		if (MyString.isEmpty(temp))
			return defaultValue;
		else
			temp = request.getParameter(arg).trim();
		return temp;
	}

	public String getParameter(String arg) {
		return getParameter(arg, "");
	}

	public String getSession(String key){
		Object o = session.get(key);
		return o == null? "":o.toString();
	}
	public int getParameter(String arg, int defaultValue) {
		String temp = request.getParameter(arg);
		if (temp == null)
			return defaultValue;
		else {
			temp = request.getParameter(arg).trim();
			try {
				return Integer.parseInt(temp);
			} catch (Exception e) {
				return defaultValue;
			}
		}
	}
	// 将url中的参数强制装换为integer对象
	public int getIntParameter(String str) {
		try {
			String strParam = request.getParameter(str);
			if (strParam != null && strParam.trim() != "") {
				return Integer.parseInt(strParam);
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}

	}
	// 向前台返回json格式的数据
	public void writeStringToResponse(String content) {
		try {
			// 设置字符集
			response.setCharacterEncoding("utf-8");
			// 获取向前台的打印流
			PrintWriter pw = response.getWriter();
			pw.write(content);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeJasonToResponse(List<?> list) {
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "addTime"});// 除去dept属性
		JSONArray json = JSONArray.fromObject(list,config);
		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void initPage(String pageName, String pageMessage) {
		request.setAttribute("pageName", pageName);
		request.setAttribute("pageMessage", pageMessage);
	}

	public void initPage(String pageName, String pageMessage, String succMess) {
		initPage(pageName, pageMessage);
		request.setAttribute("tipMessage", succMess);
	}

	public void initPage(String pageName) {
		initPage(pageName, "欢迎进入亿通世界");
	}

	public void setReturnPage(String returnPage, String returnName) {
		request.setAttribute("returnPage", returnPage);
		request.setAttribute("returnName", returnName);
	}

//	public static boolean isLegal(String str) {
//		if (str == null)
//			return false;
//		return str
//				.matches("[0-9|a-z|A-Z|_|#|@|\\s|.|:|,|+|-|-|*|/|\u2E80-\u9FFF]*");
//	}

	public void prepare() {
	};

	public T getModel() {
		return model;
	};

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Map<String, Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

	public List<T> getModels() {
		return models;
	}

	public void setModels(List<T> models) {
		this.models = models;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageMessage() {
		return pageMessage;
	}

	public void setPageMessage(String pageMessage) {
		this.pageMessage = pageMessage;
	}

	public String getTipMessage() {
		return tipMessage;
	}

	public void setTipMessage(String tipMessage) {
		this.tipMessage = tipMessage;
	}

	// mange/list.jsp页面获取class名称
	public String getClazz() {
		return clazz.getSimpleName();
	}

	public String getOperators() {
		return operators;
	}

	public void setOperators(String operators) {
		this.operators = operators;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

}
