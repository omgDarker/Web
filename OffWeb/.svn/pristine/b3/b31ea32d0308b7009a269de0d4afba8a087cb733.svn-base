package cn.wegoteam.shop.po;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import cn.crap.base.BasePo;
import cn.wegoteam.shop.cache.Cache;
import cn.wegoteam.shop.util.Const;
import cn.wegoteam.shop.util.GetReqRes;
import cn.wegoteam.shop.util.MyString;

/**
 * Staticdata entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "staticdata", catalog = "offweb")
public class Staticdata  extends BasePo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2469432855815594938L;
	private String code;// 编号
	private String pcode;// 父编号 表中添加了外键，指向
	private String value;// 值
	private String name;// 显示的名字
	private String enName;
	private String description;// 备注
	private String link;// 链接
	private Integer order;// 是否排序
	private String type;//类型，多个static拥有 不同的fcode，但是可能属于同一类
	
	@Column(name = "code", length = 15,nullable = false)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "pcode", length = 15)
	public String getPcode() {
		return this.pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	@Column(name = "value", length = 100)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "enName", length = 100)
	public String getEnName() {
		return this.enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}
	
	
	@Column(name = "type", length = 25)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "link", length = 100)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	@Column(name = "order_list")
	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	@Transient
	public String getLang() {
		if(GetReqRes.getRequest().getServerName().contains("en.")){
				return MyString.isEmpty(enName)?name:enName;
		}else{
			String lang=GetReqRes.getRequest().getParameter("lang");
			if(lang!=null&&lang.equals("en")){
				return MyString.isEmpty(enName)?name:enName;
			}
		}
		return name;
	}

}