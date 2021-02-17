package inc.monster.app.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/", "/index", "/login", "/css/**", "/images/**").permitAll()
                        .mvcMatchers("/car/edit").hasRole("ADMIN")
                        .anyRequest().hasRole("USER")
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .successForwardUrl("/car/index")
                        .failureUrl("/login-error")
                )
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/")
                );
    }

}
