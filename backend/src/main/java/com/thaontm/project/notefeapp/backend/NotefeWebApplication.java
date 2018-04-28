package com.thaontm.project.notefeapp.backend;

import com.thaontm.project.notefeapp.backend.core.service.LanguageService;
import com.thaontm.project.notefeapp.backend.core.service.PostService;
import com.thaontm.project.notefeapp.backend.core.service.SegmentService;
import com.thaontm.project.notefeapp.backend.core.service.SegmentTypeService;
import com.thaontm.project.notefeapp.backend.utils.TestData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

@SpringBootApplication
@EnableScheduling
public class NotefeWebApplication {

    @Value("${rest.api.base.path}")
    private String restApiBasePath;

    public static void main(String[] args) {
        SpringApplication.run(NotefeWebApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PostService postService, SegmentTypeService segmentTypeService, SegmentService segmentService, LanguageService languageService) {
        return (args) -> {
            TestData.addLanguage(languageService);
            TestData.addSegmentType(segmentTypeService);
            TestData.addPost(postService);
            TestData.addSegment(postService, segmentService, segmentTypeService);
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:4200");
            }
        };
    }

    @Bean
    public WebMvcRegistrationsAdapter webMvcRegistrationsHandlerMapping() {
        NotefeWebApplication application = this;
        return new WebMvcRegistrationsAdapter() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new RequestMappingHandlerMapping() {

                    @Override
                    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
                        Class<?> beanType = method.getDeclaringClass();
                        RestController restApiController = beanType.getAnnotation(RestController.class);
                        if (restApiController != null) {
                            PatternsRequestCondition apiPattern = new PatternsRequestCondition(application.restApiBasePath)
                                .combine(mapping.getPatternsCondition());

                            mapping = new RequestMappingInfo(mapping.getName(), apiPattern,
                                mapping.getMethodsCondition(), mapping.getParamsCondition(),
                                mapping.getHeadersCondition(), mapping.getConsumesCondition(),
                                mapping.getProducesCondition(), mapping.getCustomCondition());
                        }

                        super.registerHandlerMethod(handler, method, mapping);
                    }
                };
            }
        };
    }

}
