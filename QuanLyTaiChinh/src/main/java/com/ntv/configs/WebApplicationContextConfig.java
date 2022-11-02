/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
//import com.ntv.validator.UserNameValidator;
import com.ntv.validator.WebAppValidator;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author inmac
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.ntv.controllers",
    "com.ntv.repository",
    "com.ntv.service",
    "com.ntv.validator"
   
})
public class WebApplicationContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new ExpenseItemFormatter());
//        registry.addFormatter(new IncomeItemFormatter());
//    }
    @Bean
    public InternalResourceViewResolver
            getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver
                = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public WebAppValidator userValidator(){
        Set<Validator> v = new HashSet<>();
//        v.add(new UserNameValidator());
        
        WebAppValidator v1 = new WebAppValidator();
        v1.setSpringValidator(v);
        
        return v1;
    }
    
    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
    @Bean
    public LocalValidatorFactoryBean beanVaidator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resource
                = new ResourceBundleMessageSource();
        resource.setBasenames("messages");

        return resource;
    }

}
