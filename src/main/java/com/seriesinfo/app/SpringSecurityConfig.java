package com.seriesinfo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.seriesinfo.app.service.JPAUserDetailService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JPAUserDetailService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	/** 
	 * Method that configure the access to the differents views..
	 * @param http: allow configure web based security.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/invitado/**", "/principal/**", "/listar_peliculas/**", "/listar_series/**", "/detalle_pelicula/**", "/detalle_serie/**", "/detalle_personaje/**", "/v4", "/authentication/v4", "/registration/**", "/jojo/**", "/css/**", "/js/**", "/img/**").permitAll()
		.antMatchers("listas/**").hasAnyRole("REGISTRADO")
		.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login")
			.permitAll()
		.and()
		.logout().permitAll();
		
		http.csrf().disable();
		http.formLogin().defaultSuccessUrl("/principal", true);
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
	}
	
	

}
