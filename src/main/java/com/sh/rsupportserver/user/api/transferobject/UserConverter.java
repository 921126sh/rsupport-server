package com.sh.rsupportserver.user.api.transferobject;


import com.sh.rsupportserver.user.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 사용자 어그리게이션 TO객체 변환기이다.
 *
 * @author seonghyun
 */
@Component
public class UserConverter {
    public UserResponse convert(User user) {
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user, response);
        return response;
    }
}
