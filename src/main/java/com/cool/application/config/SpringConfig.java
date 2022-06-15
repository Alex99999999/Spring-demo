package com.cool.application.config;

import com.cool.application.dao.UserDao;
import com.cool.application.dao.impl.UserDaoImpl;
import com.cool.application.db.DbConnectionProvider;
import com.cool.application.db.UserQueries;
import com.cool.application.db.postgres.PostgresDbConnectionProviderImpl;
import com.cool.application.db.postgres.queries.user.PostgresUserQueries;
import com.cool.application.service.UserService;
import com.cool.application.service.impl.UserServiceImpl;
import com.cool.application.servlet.webcommand.CommandContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.cool.application")
@EnableWebMvc
public class SpringConfig {

    @Bean
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver ivr = new InternalResourceViewResolver();
        ivr.setPrefix("/");
        ivr.setSuffix(".jsp");
        return ivr;
    }

    @Bean
    public DbConnectionProvider dbConnectionProvider() {
        return new PostgresDbConnectionProviderImpl();
    }

    @Bean
    public UserQueries userQueries() {
        return new PostgresUserQueries();
    }


    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    @Bean
    public CommandContainer getCommandContainer() {
        return new CommandContainer() {
            @Override
            protected UserService getUserService() {
                return userService();
            }
        };
    }

}
