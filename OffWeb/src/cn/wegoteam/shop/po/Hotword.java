package cn.wegoteam.shop.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import cn.crap.base.BasePo;

/**
 * Hotword entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hotword", catalog = "offweb", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Hotword  extends BasePo implements java.io.Serializable {

	private static final long serialVersionUID = -6007886292885210079L;
	private String name;
	private Integer searchTimes;

	public Hotword() {}

	public Hotword(String name, int searchTimes) {
		this.name=name;
		this.searchTimes=searchTimes;
	}

	@Column(name = "name", unique = true, nullable = false, length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "searchTimes", nullable = false)
	public Integer getSearchTimes() {
		return this.searchTimes;
	}

	public void setSearchTimes(Integer searchTimes) {
		this.searchTimes = searchTimes;
	}

}