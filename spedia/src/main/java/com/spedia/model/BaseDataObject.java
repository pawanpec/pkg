package com.spedia.model;

import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * This is a base class for all the models
 * which maintains the audit related columns
 * @author vvindal, niraj
 * 
 */
@MappedSuperclass
public class BaseDataObject extends GenericObject {

	private static final long serialVersionUID = 3909439049699523105L;

	/**
	 * Primary Id of the object
	 */
	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	/**
	 * name
	 */
	protected String name;
	/**
	 * Who created the object
	 */
	private String createdBy;
	/**
	 * Who updated the object
	 */
	private String updatedBy;
	/**
	 * When object is created
	 */
	@Temporal( TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createdDate;
	/**
	 * When object is updated
	 */
	@Temporal( TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	/**
	 * Id
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Id to set
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Created by
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Created by to set
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Updated by
	 * @return updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * Updated by tos set
	 * @param updatedBy
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * Created date
	 * @return createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Created date to set
	 * @param createdDate
	 * @throws ParseException
	 */
	public void setCreatedDate(Date createdDate) throws ParseException {
		this.createdDate = createdDate;
	}

	/**
	 * Updated date
	 * @return updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Updated date to set
	 * @param updatedDate
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	/** Name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/** Name to set
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	/**
	 * Rich Method to return beautiful created date
	 * @return createdDateDay
	 */
	public int getCreatedDateDay(){
		Date cd = getCreatedDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(cd);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BaseDataObject)) {
			return false;
		}
		BaseDataObject other = (BaseDataObject) obj;
		if (createdBy == null) {
			if (other.createdBy != null) {
				return false;
			}
		} else if (!createdBy.equals(other.createdBy)) {
			return false;
		}
		if (createdDate == null) {
			if (other.createdDate != null) {
				return false;
			}
		} else if (!createdDate.equals(other.createdDate)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (updatedBy == null) {
			if (other.updatedBy != null) {
				return false;
			}
		} else if (!updatedBy.equals(other.updatedBy)) {
			return false;
		}
		if (updatedDate == null) {
			if (other.updatedDate != null) {
				return false;
			}
		} else if (!updatedDate.equals(other.updatedDate)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseDataObject [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", updatedDate=");
		builder.append(updatedDate);
		builder.append("]");
		return builder.toString();
	}

}
