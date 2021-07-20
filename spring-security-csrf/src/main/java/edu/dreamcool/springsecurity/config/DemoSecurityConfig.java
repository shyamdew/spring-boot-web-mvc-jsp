package edu.dreamcool.springsecurity.config;

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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("john").password("123").roles("EMPLOYEE"))
		.withUser(users.username("SUP").password("fonepaisa123").roles("EMPLOYEE"))
		.withUser(users.username("ADMIN").password("Shyam@321").roles("EMPLOYEE"))
		.withUser(users.username("mary").password("123").roles("MANAGER"))
		.withUser(users.username("susan").password("123").roles("ADMIN"));
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests() // Any http request coming in should be authorized 
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
