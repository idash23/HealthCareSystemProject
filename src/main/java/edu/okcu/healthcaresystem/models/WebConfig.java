package edu.okcu.healthcaresystem.models;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "edu.okcu.healthcaresystem" })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Bean
    public NamedParameterJdbcTemplate geNamedParameterJdbcTemplate(){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://ocu-mysql-capstone.mysql.database.azure.com");
        ds.setUsername("ocucapstone@ocu-mysql-capstone");
        ds.setPassword("Gg21EL$#8w!K");

        return ds;
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/resources/html/");
        viewResolver.setSuffix(".html");

        return viewResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        rb.setBasenames(new String[]{"validation"});

        return rb;
    }
}
    Create a WebInitializer class under edu.okcu.healthcaresystem.config package and write the following code in it
        package edu.okcu.healthcaresystem.config;

        import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

    @Override
    protected Class[] getRootConfigClasses() {
        return new Class[] { WebConfig.class};
    }

    @Override
    protected Class[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}