package com.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.auth.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	public static final String PUBLIC_URL[]= {
			"/token",
			"/validate",
			"/h2-console/**",
			"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"getData",
			"/userid",
			"/webjars/**"
	};
	
	@Autowired
	private JwtAuthenticationEntryPoint entrypoint;
	
	@Autowired
	private jwtAuthenticationFilter jwtFilter;

	@Autowired
	private CustomUserDetailService userDetailsService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);

	}

	public void configure(HttpSecurity http) throws Exception {
		
	    http.headers().frameOptions().disable();

		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/userid").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/validate").permitAll()
			.antMatchers("/update").permitAll()
			.antMatchers(PUBLIC_URL).permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			;
		
		// Add a filter to validate the tokens with every request
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	

}
