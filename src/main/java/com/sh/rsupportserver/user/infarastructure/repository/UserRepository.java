package com.sh.rsupportserver.user.infarastructure.repository;


import com.sh.rsupportserver.core.domain.DomainRepository;
import com.sh.rsupportserver.user.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

/**
 * 사용자 도메인 레파지토리이다.
 *
 * @author seonghyun
 */
public interface UserRepository extends DomainRepository<User, Long> {
    User findByUserId(String userId);

    @Override
    @EntityGraph(attributePaths = {"userRoles"}, type = EntityGraph.EntityGraphType.LOAD)
    List<User> findAll();
}
