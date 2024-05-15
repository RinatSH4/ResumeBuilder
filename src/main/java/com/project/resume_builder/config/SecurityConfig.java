package com.project.resume_builder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/api/users/register").permitAll() // Разрешаем доступ всем к главной странице и регистрации
                .anyRequest().authenticated() // Остальные запросы требуют аутентификации
                .and()
                .formLogin()
                .loginPage("/login") // Указываем страницу входа
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Указываем URL для выхода
                .logoutSuccessUrl("/") // Перенаправляем после выхода на главную страницу
                .invalidateHttpSession(true) // Очищаем сессию при выходе
                .deleteCookies("JSESSIONID"); // Удаляем куки
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication() // Используем память для хранения пользователей
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN"); // Создаем учетные данные администратора
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
