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

package com.rivetlogic.microsite.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.rivetlogic.microsite.NoSuchSiteRequestException;
import com.rivetlogic.microsite.model.SiteRequest;
import com.rivetlogic.microsite.service.base.SiteRequestLocalServiceBaseImpl;
import com.rivetlogic.microsite.util.MicroSiteConstants;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the Site Request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.microsite.service.SiteRequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jose.ross
 * @see com.rivetlogic.microsite.service.base.SiteRequestLocalServiceBaseImpl
 * @see com.rivetlogic.microsite.service.SiteRequestLocalServiceUtil
 */
public class SiteRequestLocalServiceImpl extends SiteRequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.microsite.service.SiteRequestLocalServiceUtil} to access the Site Request local service.
	 */
    
    public List<SiteRequest> findAll() 
            throws SystemException {
        return siteRequestPersistence.findAll();
    }
    
    public List<SiteRequest> findAll(int start, int end) 
            throws SystemException {
        return siteRequestPersistence.findAll(start, end);
    }
    
    public List<SiteRequest> findByCompanyGroup(long companyId, long groupId)
            throws SystemException {
        return siteRequestPersistence.findByCompanyGroup(companyId, groupId);
    }
    
    public List<SiteRequest> findByCompanyGroupUser(long companyId, long groupId, long userId)
            throws SystemException {
        return siteRequestPersistence.findByCompanyGroupUser(companyId, groupId, userId);
    }
    
    public List<SiteRequest> findByCompanyGroupUser(long companyId, long groupId, long userId, int start, int end) 
            throws SystemException {
        return siteRequestPersistence.findByCompanyGroupUser(companyId, groupId, userId, start, end);
    }
    
    public void add(long companyId, long groupId, long userId, String name, String description) 
            throws SystemException {
        long id = counterLocalService.increment(SiteRequest.class.getName());
        SiteRequest siteRequest = siteRequestPersistence.create(id);
        
        siteRequest.setCompanyId(companyId);
        siteRequest.setGroupId(groupId);
        siteRequest.setUserId(userId);
        siteRequest.setName(name);
        siteRequest.setDescription(description);
        Date now = new Date();
        siteRequest.setCreateDate(now);
        siteRequest.setModifiedDate(now);
        siteRequest.setStatus(MicroSiteConstants.REQUEST_STATUS_PENDING);
        
        siteRequestPersistence.update(siteRequest);
    }
    
    public void updateStatus(long siteRequestId)
            throws NoSuchSiteRequestException, SystemException {
        SiteRequest siteRequest = siteRequestPersistence.findByPrimaryKey(siteRequestId);
        if(siteRequest.getStatus().equals(MicroSiteConstants.REQUEST_STATUS_PENDING))
            siteRequest.setStatus(MicroSiteConstants.REQUEST_STATUS_PROCESSING);
        else if(siteRequest.getStatus().equals(MicroSiteConstants.REQUEST_STATUS_PROCESSING))
            siteRequest.setStatus(MicroSiteConstants.REQUEST_STATUS_COMPLETE);
        
        siteRequest.setModifiedDate(new Date());
        
        siteRequestPersistence.update(siteRequest);
    }
    
}