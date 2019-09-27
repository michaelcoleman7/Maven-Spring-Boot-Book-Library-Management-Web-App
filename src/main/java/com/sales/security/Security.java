package com.sales.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{
	//List of blocked urls while user is not logged in
    public final static String[] URLS = new String[]{
    		"/showBooks", "/showCustomers", "/showLoans", "/addBook","/addCustomer", "/newLoan", "/deleteLoan"
    };
  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception{
    httpSecurity.authorizeRequests()
     .antMatchers(URLS)
     .hasRole("USER")
     .and()
     .formLogin()
     .and()
     .logout()
     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//mapping for logging out
     .logoutSuccessUrl("/");//when logged out return to this url mapping
  }
 
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
                        throws Exception {
    auth.inMemoryAuthentication()
      .withUser("user").password("user").roles("USER");//user and password details
  }
}
