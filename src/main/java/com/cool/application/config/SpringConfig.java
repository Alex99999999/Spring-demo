package com.cool.application.config;

import com.cool.application.dao.UserDao;
import com.cool.application.dao.impl.UserDaoImpl;
import com.cool.application.db.DbConnectionProvider;
import com.cool.application.db.UserQueries;
import com.cool.application.db.postgres.PostgresDbConnectionProviderImpl;
import com.cool.application.db.postgres.queries.user.PostgresUserQueries;
import com.cool.application.service.UserService;
import com.cool.application.service.impl.UserServiceImpl;
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

//    @Bean
//    public Command getAllUsersCommand () {
//        return new GetAllUsersCommand();
//    }
//
//    @Bean
//    public CommandContainer getommandContainer() {
//         CommandContainer container = new CommandContainer() {
//            @Override
//            protected void populateCommands() {
//                commands = new HashMap<>();
//                System.out.println("````````````````````````````populating````````````````````````````````");
//                commands.put(UserOperations.GET_ALL_USERS.getName(), getAllUsersCommand());
//            }
//        };
//        return container;
//    }

}
