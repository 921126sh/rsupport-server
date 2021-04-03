package com.sh.rsupportserver;

import com.sh.rsupportserver.notice.api.transferobject.NoticeRequest;
import com.sh.rsupportserver.notice.application.ChangeNoticeService;
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
     * TODO: 테스트를 위해 200 개의 공지를 생성한다.
     */
    @Bean
    public CommandLineRunner initData(ChangeNoticeService changeNoticeService) {
        return args ->
                IntStream.rangeClosed(1, 200).forEach(i -> {
                    changeNoticeService.registerNotice(new NoticeRequest("title" + i, "content" + i ));
                });
    }
}
