package com.balkiss.produits.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 PasswordEncoder passwordEncoder = passwordEncoder ();
	 /*auth.inMemoryAuthentication().withUser("admin")
	 .password(passwordEncoder.encode("123")).roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("balkiss")
	 .password(passwordEncoder.encode("123")).roles("AGENT","USER");
	  auth.inMemoryAuthentication().withUser("user1")
	 .password(passwordEncoder.encode("123")).roles("USER");
	  */
	 
	 System.out.println("Password Encoded BCRYPT :******************** ");
	 System.out.println(passwordEncoder.encode("123"));
	 auth.jdbcAuthentication()
	 .dataSource(dataSource)
	 .usersByUsernameQuery("select username , password , enabled from user where username =?")
	 .authoritiesByUsernameQuery(
	 "SELECT u.username, r.role " +
	 "FROM user_role ur, user u , role r " +
	 "WHERE u.user_id = ur.user_id AND ur.role_id = r.role_id AND u.username = ?")
	 .passwordEncoder(passwordEncoder)
	 .rolePrefix("ROLE_");
	 }


 @Override
 protected void configure(HttpSecurity http) throws Exception {
 http.authorizeRequests().antMatchers("/showCreatePC").hasAnyRole("ADMIN","AGENT");
 http.authorizeRequests().antMatchers("/savePc").hasAnyRole("ADMIN","AGENT");
 http.authorizeRequests().antMatchers("/listePcs").hasAnyRole("ADMIN","AGENT","USER");

 http.authorizeRequests().antMatchers("/supprimerPc","/modifierPc","/updatePc").hasRole("ADMIN");
 http.authorizeRequests().antMatchers("/login").permitAll();
 http.authorizeRequests().antMatchers("/api").permitAll();
 http.authorizeRequests().antMatchers("/api/marques").permitAll();
 http.authorizeRequests().antMatchers("/api/pcsMarque").permitAll();
 http.authorizeRequests().anyRequest().authenticated();
 http.formLogin().loginPage("/login");;
 http.exceptionHandling().accessDeniedPage("/accessDenied");
 
 
 }
 @Bean
 public PasswordEncoder passwordEncoder () {
 return new BCryptPasswordEncoder();
 }
 
}