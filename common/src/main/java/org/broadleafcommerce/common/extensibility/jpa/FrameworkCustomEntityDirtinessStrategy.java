/*
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2018 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.extensibility.jpa;

import org.hibernate.Session;
import org.hibernate.boot.internal.DefaultCustomEntityDirtinessStrategy;
import org.hibernate.persister.entity.EntityPersister;

/**
 * Reset entity state after flush for {@link DirtyFallback} implementations.
 *
 * @author Jeff Fischer
 */
public class FrameworkCustomEntityDirtinessStrategy extends DefaultCustomEntityDirtinessStrategy {

    @Override
    public void resetDirty(Object entity, EntityPersister persister, Session session) {
        if (entity instanceof DirtyFallback) {
            ((DirtyFallback) entity).clearDirtyState();
        }
    }
}