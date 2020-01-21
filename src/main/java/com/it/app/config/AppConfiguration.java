package com.it.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * The type App configuration.
 */
@Configuration
@ComponentScan(basePackages = "com.it.app")
@Import({DatabaseConfiguration.class, WebConfiguration.class, SecurityConfiguration.class})
public class AppConfiguration {

}
