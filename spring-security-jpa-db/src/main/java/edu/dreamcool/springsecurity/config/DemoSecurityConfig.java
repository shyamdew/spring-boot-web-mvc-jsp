package edu.dreamcool.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource ds;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.jdbcAuthentication().dataSource(ds);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests() // Any http request coming in should be authorized
		.antMatchers("/products").permitAll()
		.antMatchers("/css/**").permitAll()
			.anyRequest()
				.authenticated() // all request should be authenticated
		.and()
			.formLogin()
				.loginPage("/login") // custome login page 
				.loginProcessingUrl("/authenticateTheUser") // process auth reqest at this resource
				.permitAll()
		.and()
			.logout()
				.permitAll(); // display login page for everyone
	}

}
