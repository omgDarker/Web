package cn.wegoteam.shop.po;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.crap.base.BasePo;
import cn.wegoteam.shop.enu.SexType;
import cn.wegoteam.shop.enu.UserType;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "offweb")
public class User  extends BasePo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8368928923466188494L;
	private String name; // 用户姓名
	private SexType sex; // 用户性别
	private String email; // 用户邮箱
	private String phone; // 用户电话
	private String password; // 用户密码
	private String qq; // 用户QQ
	private Integer bounds; // 用户积分
	private Integer grade; // 用户等级
	private Timestamp insertTime; // 记录插入时间
	private UserType type;//用户类型
	private String authority;//权限
	private String role;//角色
	
	
	@Transient
	public String getAnonymousName(){
		StringBuilder sb = new StringBuilder(name.substring(0, 1));
		for(int i=0;i<name.length()-2;i++){
			sb.append("*");
		}
		return sb.append(name.substring(name.length()-1)).toString();
	}
	@Transient
	public String getFormatStrTime(){
    	return this.insertTime.toString().substring(0,this.insertTime.toString().lastIndexOf(" ")).trim();
    }

	@Column(name = "name", length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex", length = 12,nullable=false,insertable=false)
	@Enumerated(EnumType.STRING)
	public SexType getSex() {
		return this.sex;
	}

	public void setSex(SexType sex) {
		this.sex = sex;
	}
    @Column(name="type",length=12,nullable = true,insertable=false)
    @Enumerated(EnumType.STRING)
    public UserType getType(){
    	return this.type;
    }
    public void setType(UserType type){
    	this.type=type;
    }
	@Column(name = "email", length = 32)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 32)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "password", length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "qq", length = 32)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "bounds",nullable=true,insertable=false)
	public Integer getBounds() {
		return this.bounds;
	}

	public void setBounds(Integer bounds) {
		this.bounds = bounds;
	}

	@Column(name = "grade",nullable = true,insertable=false)
	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Column(name = "insertTime", length = 32,nullable = true,insertable=false,updatable=false)
	public Timestamp getInsertTime() {
		return this.insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	@Column(name = "authority", length = 200)
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Column(name = "role", length = 100)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}