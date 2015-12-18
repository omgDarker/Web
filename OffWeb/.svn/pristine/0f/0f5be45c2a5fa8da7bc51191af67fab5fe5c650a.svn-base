package cn.wegoteam.shop.adm.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import cn.wegoteam.shop.action.BaseAction;
import cn.wegoteam.shop.cache.Cache;
import cn.wegoteam.shop.cache.StaticDataCache;
import cn.wegoteam.shop.inter.StaticdataServiceInter;
import cn.wegoteam.shop.po.Staticdata;
import cn.wegoteam.shop.po.User;
import cn.wegoteam.shop.polist.Pick;

@ParentPackage("manage")
@Namespace("/")
@Controller
public class ManIndexAction extends BaseAction<User>{
	/**
	 * p_ 开头的参数表示非model属性
	 */
	private static final long serialVersionUID = -7214652284224332303L;
	
	@Autowired
	private StaticdataServiceInter staticdataService;
	private List<Pick> picks =new ArrayList<Pick>();
	private String code="";//主键
	private String radio="";//是否为单选项
	private String tag="";
	private String def="";//默认值
	//调转到主页action
	@Action(value="manageIndex",results={@Result(name="success",location=MANAGE+"index.jsp")})
	public String manageIndex() {
		return SUCCESS;
	}
	@Action(value = "pick", results = {@Result(name = SUCCESS,location =MANAGE+"pick.jsp")})
	public String loadPick(){
		if(code.equals("STATICDATA")){
			List<Staticdata> list;
			list= StaticDataCache.getStaticdatas(getParameter("p_code",""), getParameter("p_type","NO"));
			for(Staticdata o:list){
				/****显示的商品属性必须在商品分内保护的属性内*****/
				if(!getParameter("p_p_type", "").equals("")){
					Staticdata sd = StaticDataCache.getStaticdata(getParameter("p_p_type", ""));
					if(!sd.getValue().contains(o.getPcode()))
						continue;
				}
				Pick pick=new Pick();
				pick.setId(o.getCode());
				pick.setName(o.getPcode()+"-"+o.getName());
				picks.add(pick);
			}
		}
		request.setAttribute("iCallBack", getParameter("iCallBack", ""));
		request.setAttribute("iCallBackParam", getParameter("iCallBackParam", ""));
		
		return SUCCESS;
	}
	@Action(value = "clear")
	public void clear(){
		Cache.clear();
		writeStringToResponse(SUCCESS);
	}

	public List<Pick> getPicks() {
		return picks;
	}

	public void setPicks(List<Pick> picks) {
		this.picks = picks;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}
}
