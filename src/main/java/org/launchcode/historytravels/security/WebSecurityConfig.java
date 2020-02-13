package org.launchcode.historytravels.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("securityDataSource")
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        // use jdbc authentication
        auth.jdbcAuthentication()
                .dataSource(securityDataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // designing the access level
        http.authorizeRequests()
                .antMatchers("/user/index").hasRole("USER")
                .antMatchers("/user/trail").hasRole("USER")
                .antMatchers("/user/employees").hasRole("EMPLOYEE")
                .antMatchers("/user/login*").permitAll()
                .antMatchers("/user/register*").permitAll()
                .and()
                .formLogin()
                    .loginPage("/user/login")
                    .loginProcessingUrl("/authenticate")
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }
}
