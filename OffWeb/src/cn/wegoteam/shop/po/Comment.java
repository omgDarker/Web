package cn.wegoteam.shop.po;


import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Where;
import cn.crap.base.BasePo;
import cn.wegoteam.shop.util.DateFormartUtil;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", catalog = "offweb")
public class Comment extends BasePo implements java.io.Serializable {

	// Fields
	private Comment comment;
	private User user;
	private News news;
	private Timestamp insertTime;
	private String content;
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Integer praise;//评论赞的数量
	
	
	@Transient
    public String getFormatStrTime(){
    	return DateFormartUtil.getDateByFormat(this.insertTime.toString(),"yyyy年MM月dd日 HH:mm");
    }


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pid")
	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	@Column(name = "insertTime", length = 32,nullable = true,insertable=false,updatable=false)
	public Timestamp getInsertTime() {
		return this.insertTime;
	}
	
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "comment")
	@Where(clause="flag!=-100")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uid", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nid", nullable = false)
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	@Column(name="praise",length=11,insertable=false)
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}

}