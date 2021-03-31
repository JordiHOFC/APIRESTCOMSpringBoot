package br.com.nutrition.Config;

import br.com.nutrition.Usuario.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;


    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(aut-> {

            /*try {
                aut.antMatchers(HttpMethod.GET,"/api/nutricionista").permitAll()
                        .antMatchers(HttpMethod.POST,"/usuarios").permitAll()
                        .antMatchers(HttpMethod.POST,"/login").permitAll()
                        .antMatchers(HttpMethod.GET,"/consultas").hasRole("ADM")
                        .antMatchers(HttpMethod.POST,"/consultas").hasRole("SECRETARIO")
                        .anyRequest().authenticated().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and().addFilterBefore(new AuthenticationFilterToken(tokenService), UsernamePasswordAuthenticationFilter.class);
            } catch (Exception e) {
                e.printStackTrace();
            }*/

            try {
                aut.antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and().addFilterBefore(new AuthenticationFilterToken(tokenService), UsernamePasswordAuthenticationFilter.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }


}
