package com.nalashaa.pas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.envers.Audited;
import org.springframework.security.core.context.SecurityContextHolder;

@MappedSuperclass
public abstract class EntityBase implements Serializable {
	private static final long serialVersionUID = 8984421416876960891L;

	/**
	 * This array is a set of properties that should never have setters called
	 * on. It is mostly to let Bean Utils methods that might need to copy all
	 * the properties from one class to another know which properties to skip.
	 */
	public static final String[] UNMODIFIABLE_PROPERTIES = new String[] { "id", "systemDefined" };

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column
	protected Long id;

	@Version
	@Column
	private Date version = new Date();

	public EntityBase() {

	}

	public EntityBase(EntityBase value) {
		this.id = value.id;
		if (value != null && value.version != null)
			this.version = value.version;
	}

	public Long getId() {
		return id;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date date) {
		if (date != null)
			version = date;
	}

	@Audited
	@Column
	private Date lastUpdateTime;

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	// @ManyToOne(cascade = { CascadeType.PERSIST })
	// @JoinColumn(name = "lastUpdateUser_id")
	@Audited
	@Column
	private String lastUpdateUser;

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	@Column
	private boolean isSystemDefined = false;

	public boolean isSystemDefined() {
		return this.isSystemDefined;
	}

	/**
	 * This method should (obviously) never be called by any logged in user
	 * action or by our cient side code
	 * 
	 * @param value
	 */
	public void setSystemDefined(boolean value) throws UnsupportedOperationException {

		// here we ensure that if the method is called from a user session, we
		// throw an exception
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			this.isSystemDefined = value;
		} else {
			throw new UnsupportedOperationException();
		}
	}

	@Transient
	private Boolean isWritable;

	public Boolean getTransWritable() {
		return isWritable;
	}

	/**
	 * This method is used to remove duplicate entities in the assigned list.
	 * this should avoid duplicate entries in DB, specially for drag and drop
	 * use cases
	 * 
	 * eg : removeDuplicateEntities(sites)
	 * 
	 * @param rawList
	 *            (It may contain duplicates or unique)
	 */
	public <T> void removeDuplicateEntities(List<T> rawList) {
		List<T> cleanEntities = new ArrayList<T>();
		if (rawList != null && !rawList.isEmpty()) {
			for (T object : rawList) {
				if (cleanEntities.size() == 0 || !cleanEntities.contains(object)) {
					cleanEntities.add(object);
				}
			}
			rawList.clear();
			for (T uniqueEntity : cleanEntities) {
				rawList.add(uniqueEntity);
			}
		}
	}

	@Override
	public String toString() {
		return this.getClass().getName() + ": " + getId() + " " + this.getLastUpdateUser() + " "
				+ this.getLastUpdateTime();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityBase other = (EntityBase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
