package cn.crap.base;

import static javax.persistence.GenerationType.IDENTITY;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BasePo {
	protected Integer id;
	protected Integer flag;// ±êÖ¾Î»
	protected Timestamp addTime;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "flag", insertable = false, nullable = false)
	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Column(name = "addTime", nullable = false, insertable = false, updatable = false)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Transient
	public String getShowAddTime() {
		if(this.addTime==null)
			return "";
		return this.addTime.toString()
				.substring(0, this.addTime.toString().lastIndexOf(":")).trim();
	}
	
	@Transient
	public String getFlagName(){
			return  FlagType.getFlagName(flag);
	}
}