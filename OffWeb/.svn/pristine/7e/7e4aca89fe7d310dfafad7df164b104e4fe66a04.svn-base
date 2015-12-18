package cn.wegoteam.shop.po;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import cn.crap.base.BasePo;
import cn.wegoteam.shop.enu.NewsType;
import cn.wegoteam.shop.util.GetReqRes;
import cn.wegoteam.shop.util.MyString;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news", catalog = "offweb")
public class News extends BasePo implements java.io.Serializable {

	private static final long serialVersionUID = 7226448984101362495L;
	private String cntitle;// 新闻标题
	private String entitle;//英文名称
	private String cncontent;// 新闻内容
	private String encontent;//英文内容
	private String date;// 新闻添加时间
	private Integer click;// 新闻点击量
	private String imgUrl;// 新闻图片
	private NewsType type;// 新闻类型
	private boolean canComment;//是否可以评论
	//联系我们等
	private String tag;
	//是否显示广告
	// Constructors

	/** default constructor */
	public News() {
	}
	public News(Integer id) {
		super.id=id;
	}


	@Column(name = "cntitle", nullable = false, length = 100)
	public String getCntitle() {
		return this.cntitle;
	}

	public void setCntitle(String cntitle) {
		this.cntitle = cntitle;
	}
	@Column(name = "entitle", length = 200)
	public String getEntitle() {
		return this.entitle;
	}

	public void setEntitle(String entitle) {
		this.entitle = entitle;
	}
	@Column(name = "tag",length = 10)
	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Column(name = "cncontent", nullable = false, length = 65535)
	public String getCncontent() {
		return this.cncontent;
	}

	public void setCncontent(String cncontent) {
		this.cncontent = cncontent;
	}
	@Column(name = "encontent", length = 65535)
	public String getEncontent() {
		return this.encontent;
	}

	public void setEncontent(String encontent) {
		this.encontent = encontent;
	}

	@Column(name = "date", nullable = false, length = 20)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "click", nullable = false,insertable=false)
	public Integer getClick() {
		return this.click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	@Column(name = "imgUrl", length = 200)
	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Column(name = "type", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	public NewsType getType() {
		return this.type;
	}

	public void setType(NewsType type) {
		this.type = type;
	}
	
	@Column(name = "canComment")
	@org.hibernate.annotations.Type(type="yes_no")
	public boolean isCanComment() {
		return canComment;
	}

	public void setCanComment(boolean canComment) {
		this.canComment = canComment;
	}
	@Transient
	public String getTitle(){
		if(GetReqRes.getRequest().getServerName().contains("en.")){
			return MyString.isEmpty(entitle)?cntitle:entitle;
		}else{
			String lang=GetReqRes.getRequest().getParameter("lang");
			if(lang!=null&&lang.equals("en")){
				return MyString.isEmpty(entitle)?cntitle:entitle;
			}
		}
		return cntitle;
	}
	@Transient
	public String getContent(){
		if(GetReqRes.getRequest().getServerName().contains("en.")){
			return MyString.isEmpty(encontent)?cncontent:encontent;
		}else{
			String lang=GetReqRes.getRequest().getParameter("lang");
			if(lang!=null&&lang.equals("en")){
				return MyString.isEmpty(encontent)?cncontent:encontent;
			}
		}
		return cncontent;
	}

}