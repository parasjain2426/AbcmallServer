package inc.droidstar.abcmall;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity		// Enables security for our application.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// Securing the urls and allowing role-based access to these urls.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
		.antMatchers("/abcmall/**").hasRole("USER")
		.and().csrf().disable();
	}

	// In-memory authentication to authenticate the user i.e. the user credentials are stored in the memory.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("parasabcmall").password("{noop}adminparas").roles("USER");
	}
}