package com.sh.rsupportserver;

import com.sh.rsupportserver.auth.configuration.AuthPasswordEncoder;
import com.sh.rsupportserver.notice.api.transferobject.NoticeRequest;
import com.sh.rsupportserver.notice.application.ChangeNoticeService;
import com.sh.rsupportserver.user.api.transferobject.UserRequest;
import com.sh.rsupportserver.user.application.ChangeUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class RsupportServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RsupportServerApplication.class, args);
    }

    /**
     * TODO: 테스트를 위해 200 개의 공지, 사용자를 생성한다.
     */
    @Bean
    public CommandLineRunner initData(ChangeNoticeService changeNoticeService, ChangeUserService changeUserService, AuthPasswordEncoder authPasswordEncoder) {
        return args ->
                IntStream.rangeClosed(1, 200).forEach(i -> {
                    changeNoticeService.registerNotice(new NoticeRequest("title" + i, "content" + i ));
                    changeUserService.registerUser(new UserRequest("id" + i, "nm" + i, authPasswordEncoder.encode("pwd" + i )));
                });
    }
}
