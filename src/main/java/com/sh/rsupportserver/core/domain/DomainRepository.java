package com.sh.rsupportserver.core.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DomainRepository<ENTITY extends DomainEntity, IDENTITY>
        extends JpaRepository<ENTITY, IDENTITY>, JpaSpecificationExecutor<ENTITY> {
}
