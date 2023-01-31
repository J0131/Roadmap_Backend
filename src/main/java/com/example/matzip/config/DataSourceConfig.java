package com.example.matzip.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    // - 외부 설정 파일 (application.properties)을 참조할 때 쓰는 방법 중 하나이다.
    // - applcation.properties의 key를 같은 값으로 시작하게 구현해두면, 이를 묶어서 등록가능
    // - 즉, 위 코드처럼 prefix = "spring.datasource" 라고 하면 spring.datasource가
    // - 접두어로 붙어 있는 application.properties 값들을 참조할 수 있다.
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
