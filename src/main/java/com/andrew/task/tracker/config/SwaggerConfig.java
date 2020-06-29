package com.andrew.task.tracker.config;

import com.andrew.task.tracker.service.ApplicationInfoService;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * Created by Andre on 26.06.2020.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private ApplicationInfoService applicationInfoService;

    @Autowired
    private TypeResolver typeResolver;

    @Value("${swagger.api.title}")
    private String apiTitle;

    @Value("${swagger.api.version}")
    private String apiVersion;

    @Value("${swagger.api.contact.name}")
    private String contactName;

    @Value("${swagger.api.contact.url}")
    private String contactUrl;

    @Value("${swagger.api.contact.email}")
    private String contactEmail;

    @Value("${jwt.token.header.key}")
    private String tokenHeader;

    @Value("${swagger.pageable.page.name}")
    private String pageParamName;

    @Value("${swagger.pageable.size.name}")
    private String limitParamName;

    @Value("${swagger.pageable.sort.name}")
    private String sortParamName;

    List<ResponseMessage> errorList = Lists.newArrayList(
            new ResponseMessageBuilder()
                    .code(401)
                    .message("User is not authorized")
                    .build());

    @Bean
    public Docket apiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.andrew.task.tracker.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .securitySchemes(Lists.newArrayList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()))
                .ignoredParameterTypes(Authentication.class)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, errorList)
                .globalResponseMessage(RequestMethod.POST, errorList)
                .globalResponseMessage(RequestMethod.DELETE, errorList)
                .globalResponseMessage(RequestMethod.PATCH, errorList)
                .globalResponseMessage(RequestMethod.PUT, errorList)
                .alternateTypeRules(newRule(typeResolver.resolve(Pageable.class),
                        pageableMixin(),
                        Ordered.HIGHEST_PRECEDENCE));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(apiTitle)
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .description(applicationInfoService.getInfo())
                .version(apiVersion)
                .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .displayRequestDuration(true)
                .validatorUrl(null)
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey(tokenHeader, tokenHeader, "header");
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference(tokenHeader, authorizationScopes));
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^/api/v1/(?!auth/).*$"))
                .build();
    }

    private Type pageableMixin() {
        return new AlternateTypeBuilder()
                .fullyQualifiedClassName(
                        String.format("%s.generated.%s",
                                Pageable.class.getPackage().getName(),
                                Pageable.class.getSimpleName()))
                .withProperties(Arrays.asList(
                        property(Integer.class, pageParamName),
                        property(Integer.class, limitParamName),
                        property(String.class, sortParamName)
                ))
                .build();
    }

    private AlternateTypePropertyBuilder property(Class<?> type, String name) {
        return new AlternateTypePropertyBuilder()
                .withName(name)
                .withType(type)
                .withCanRead(true)
                .withCanWrite(true);
    }

}
