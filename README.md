# 알서포트 서버

# 작업순서

1. 알서포트 서버 클론
   (git clone https://github.com/esmoney/nest-server-boilerplate.git)

2. gradle refresh

3. RsupportServerApplication start

4. h2설치(mac일 경우만)
 - brew install h2 (설치)
 - h2 -web (실행)
 - 생성된 url로 연결(default 8082포트 / 테스트 커넥션 하면 안됨!!!! 바로 연결해야 함!!!!)
 - http://localhost:8080/rs-server/h2-console 접속
 - [참고](https://jamie95.tistory.com/171)

5. [클라이언트 다운로드](https://github.com/esmoney/rsupport-client#readme)


# 기술스택

- Java : 1.8
- Spring Boot : 2.4.4
- Hibernate : 5.4.2
- Swagger : 2.9.2
- Lombok : 1.18.18
- Pojomatic : 2.2.1
- h2 : 2.1.4.200


# endpoint
- http://localhost:8080/rs-server

# swagger
- http://localhost:8080/rs-server/swagger-ui.html

# h2-console
- http://localhost:8080/rs-server/h2-console
- 계정: sa  / pw: 없음


# 참고
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Gradle](https://docs.gradle.org/current/userguide/userguide.html)

---


