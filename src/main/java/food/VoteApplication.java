package food;

import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableConfigurationProperties
public class VoteApplication {
//    
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//         web.ignoring()
//            .antMatchers("/webservices/**");
//    }

    @Bean
    public DataSource getDataSource(
            @Value("${food.jdbcUrl}") String url, 
            @Value("${food.user}") String user, 
            @Value("${food.password}") String password ) {
        return DataSourceBuilder.create()
                .url(url)
                .username(user)
                .password(password)
                .build();
    }
    
    @Bean
    public ObjectMapper getObjectMapper(@Value("${food.dateFormat}") String dateFormat) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(dateFormat));
        return mapper;
    }

//    
//    @Bean
//    public WebSecurityConfigurerAdapter getSecurityConfig() {
//        return new SecurityConfig();
//    }
    
    public static void main(String[] args) {
        SpringApplication.run(VoteApplication.class, "--debug");
    }
}
