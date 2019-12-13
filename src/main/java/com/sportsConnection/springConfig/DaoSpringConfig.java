package com.sportsConnection.springConfig;

import com.sportsConnection.dao.PostgresqlSPortDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoSpringConfig {

    @Bean
    public PostgresqlSPortDaoImpl postgresqlSPortDao() {
        return new PostgresqlSPortDaoImpl();
    }
}
