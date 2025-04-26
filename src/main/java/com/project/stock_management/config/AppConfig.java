package com.project.stock_management.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ensah.core.bo.*;

//Configuration d'une application Spring MVC (@EnableWebMvc)
@EnableWebMvc // Configuration d'une Application Spring MVC
@Configuration // Classe de configuration qui va contenir des beans à créer automatiquement par
				// Spring
@ComponentScan(basePackages = { "com.ensah.core" }) // Packages à scanner pour chercher les beans spring de type component
												// (càd @controller, @repository, @service)
public class AppConfig implements WebMvcConfigurer {

	/**
	 * A utiliser si vous voulez faire la journalisation. Voir le fichier log4j.xml
	 * ou .properties
	 */
	private Logger LOGGER = Logger.getLogger(getClass().getName());

	public AppConfig() {

		// On enregistre une trace dans le journal
		LOGGER.debug(" configuration init...");
	}

	// Configuration du ViewResolver

	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);

		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		return bean;
	}



}