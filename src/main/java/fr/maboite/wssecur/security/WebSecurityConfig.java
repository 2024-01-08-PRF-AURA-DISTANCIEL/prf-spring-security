package fr.maboite.wssecur.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//Demande à ce que toute requête soit authentifiée
		//Seules les personnes ayant le rôle ROLE_USER sont autorisées
		//à effecturer des requêtes sur /companies/**
		//L'authentification Basic est utilisée
		//On ne fait pas de CSRF pour les requêtes sur companies (en fait, il ne 
		//faut pas en faire sur les URLs de webservices).
		//On ajoute une référence aux pages de login et logout
		//pour l'exemple, mais ce sera inutile pour cette application
		http
			.authorizeHttpRequests(requests -> requests
				.requestMatchers("/companies/**").hasAnyRole("USER")
				.anyRequest().authenticated()
			).httpBasic(Customizer.withDefaults())
			.csrf(csrfCustomizer -> csrfCustomizer.ignoringRequestMatchers("/companies/**"))
			.formLogin(form -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
	
	/**
	 * On hashe nos mots de passe avec BCrypt
	 * @return
	 */
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	
}