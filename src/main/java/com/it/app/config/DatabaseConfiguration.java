package com.it.app.config;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.it.app.repository")
public class DatabaseConfiguration {

    @Value("${connection.driver_class}")
    private String driverClass;

    @Value("${connection.url}")
    private String url;

    @Value("${connection.username}")
    private String username;

    @Value("${connection.password}")
    private String password;

    @Bean
    public DataSource dataSource() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("data.sql").build();

/*        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driverClass);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);*/

/*        //for fill database
        Resource resource = new ClassPathResource("data.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        DatabasePopulatorUtils.execute(databasePopulator, driverManagerDataSource);*/

       // return driverManagerDataSource;
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.it.app.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaProperties(additionalProrerties());
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    private Properties additionalProrerties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","create-drop");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        return properties;
    }
}
