package com.sh.rsupportserver.core.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger의 환경설정 정보를 설정한다.
 *
 * @author seonghyun
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sh.rsupport"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 기본 정보를 설정한다.
     *
     * @return 기본정보
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("알서포트 과제")
                .description("API DOCUMENT")
                .license("SeongHyun")
                .version("1.0")
                .build();
    }
}
