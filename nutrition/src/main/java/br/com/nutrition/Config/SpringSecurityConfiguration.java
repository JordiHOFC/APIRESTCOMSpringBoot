package br.com.nutrition.Config;

import br.com.nutrition.Usuario.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(aut-> {

            try {
                aut.antMatchers(HttpMethod.GET,"/api/nutricionista").permitAll()
                        .antMatchers(HttpMethod.POST,"/usuarios").permitAll()
                        .antMatchers(HttpMethod.GET,"/consultas").hasRole("ADM")
                        .anyRequest().authenticated().and().csrf().disable().formLogin();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }


}
