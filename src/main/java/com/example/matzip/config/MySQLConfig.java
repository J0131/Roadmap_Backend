package com.example.matzip.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.example.matzip.dao")
public class MySQLConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
            final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            // SqlSessionFactory => MySql과 MyBatis를 연결해주는 객체
            // SqlSessionFactoryBean => SqlSessionFactory를 생성해주는 클래스
        
            sessionFactory.setDataSource(dataSource);
            // setDataSource => 앞서 정의한 datasource를 참조하게함

            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            // PathMatchingResourcePatternResolver => resource 위치 검색을 돕는 Spring class
            sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            // classpath => resource 폴더를 나타냄

            Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
            sessionFactory.setConfigLocation(myBatisConfig);
            
            return sessionFactory.getObject();
    }
}
