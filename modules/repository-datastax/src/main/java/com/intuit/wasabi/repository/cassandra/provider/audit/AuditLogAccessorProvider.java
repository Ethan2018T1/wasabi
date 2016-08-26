package com.intuit.wasabi.repository.cassandra.provider.audit;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intuit.wasabi.cassandra.datastax.CassandraDriver;
import com.intuit.wasabi.repository.cassandra.accessor.audit.AuditLogAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditLogAccessorProvider implements Provider<AuditLogAccessor> {
    private final Logger logger = LoggerFactory.getLogger(AuditLogAccessorProvider.class);
    private final Session session;
    private final MappingManager manager;

    @Inject
    public AuditLogAccessorProvider(CassandraDriver driver) {
        this.session = driver.getSession();
        this.manager = new MappingManager(session);
    }


    @Override
    public AuditLogAccessor get() {
        return manager.createAccessor(AuditLogAccessor.class);
    }
}