/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.microsite.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rivetlogic.microsite.model.SiteRequest;
import com.rivetlogic.microsite.model.SiteRequestModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SiteRequest service. Represents a row in the &quot;rivetlogic_micro_site_SiteRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rivetlogic.microsite.model.SiteRequestModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SiteRequestImpl}.
 * </p>
 *
 * @author steven.barba
 * @see SiteRequestImpl
 * @see com.rivetlogic.microsite.model.SiteRequest
 * @see com.rivetlogic.microsite.model.SiteRequestModel
 * @generated
 */
public class SiteRequestModelImpl extends BaseModelImpl<SiteRequest>
	implements SiteRequestModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a Site Request model instance should use the {@link com.rivetlogic.microsite.model.SiteRequest} interface instead.
	 */
	public static final String TABLE_NAME = "rivetlogic_micro_site_SiteRequest";
	public static final Object[][] TABLE_COLUMNS = {
			{ "siteRequestId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "status", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table rivetlogic_micro_site_SiteRequest (siteRequestId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,description VARCHAR(75) null,status VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table rivetlogic_micro_site_SiteRequest";
	public static final String ORDER_BY_JPQL = " ORDER BY siteRequest.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY rivetlogic_micro_site_SiteRequest.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rivetlogic.microsite.model.SiteRequest"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rivetlogic.microsite.model.SiteRequest"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rivetlogic.microsite.model.SiteRequest"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;
	public static long CREATEDATE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rivetlogic.microsite.model.SiteRequest"));

	public SiteRequestModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _siteRequestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSiteRequestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _siteRequestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SiteRequest.class;
	}

	@Override
	public String getModelClassName() {
		return SiteRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("siteRequestId", getSiteRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long siteRequestId = (Long)attributes.get("siteRequestId");

		if (siteRequestId != null) {
			setSiteRequestId(siteRequestId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getSiteRequestId() {
		return _siteRequestId;
	}

	@Override
	public void setSiteRequestId(long siteRequestId) {
		_siteRequestId = siteRequestId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SiteRequest.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SiteRequest toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SiteRequest)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SiteRequestImpl siteRequestImpl = new SiteRequestImpl();

		siteRequestImpl.setSiteRequestId(getSiteRequestId());
		siteRequestImpl.setGroupId(getGroupId());
		siteRequestImpl.setCompanyId(getCompanyId());
		siteRequestImpl.setUserId(getUserId());
		siteRequestImpl.setCreateDate(getCreateDate());
		siteRequestImpl.setModifiedDate(getModifiedDate());
		siteRequestImpl.setName(getName());
		siteRequestImpl.setDescription(getDescription());
		siteRequestImpl.setStatus(getStatus());

		siteRequestImpl.resetOriginalValues();

		return siteRequestImpl;
	}

	@Override
	public int compareTo(SiteRequest siteRequest) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), siteRequest.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SiteRequest)) {
			return false;
		}

		SiteRequest siteRequest = (SiteRequest)obj;

		long primaryKey = siteRequest.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SiteRequestModelImpl siteRequestModelImpl = this;

		siteRequestModelImpl._originalGroupId = siteRequestModelImpl._groupId;

		siteRequestModelImpl._setOriginalGroupId = false;

		siteRequestModelImpl._originalCompanyId = siteRequestModelImpl._companyId;

		siteRequestModelImpl._setOriginalCompanyId = false;

		siteRequestModelImpl._originalUserId = siteRequestModelImpl._userId;

		siteRequestModelImpl._setOriginalUserId = false;

		siteRequestModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SiteRequest> toCacheModel() {
		SiteRequestCacheModel siteRequestCacheModel = new SiteRequestCacheModel();

		siteRequestCacheModel.siteRequestId = getSiteRequestId();

		siteRequestCacheModel.groupId = getGroupId();

		siteRequestCacheModel.companyId = getCompanyId();

		siteRequestCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			siteRequestCacheModel.createDate = createDate.getTime();
		}
		else {
			siteRequestCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			siteRequestCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			siteRequestCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		siteRequestCacheModel.name = getName();

		String name = siteRequestCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			siteRequestCacheModel.name = null;
		}

		siteRequestCacheModel.description = getDescription();

		String description = siteRequestCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			siteRequestCacheModel.description = null;
		}

		siteRequestCacheModel.status = getStatus();

		String status = siteRequestCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			siteRequestCacheModel.status = null;
		}

		return siteRequestCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{siteRequestId=");
		sb.append(getSiteRequestId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.microsite.model.SiteRequest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>siteRequestId</column-name><column-value><![CDATA[");
		sb.append(getSiteRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SiteRequest.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SiteRequest.class
		};
	private long _siteRequestId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _status;
	private long _columnBitmask;
	private SiteRequest _escapedModel;
}