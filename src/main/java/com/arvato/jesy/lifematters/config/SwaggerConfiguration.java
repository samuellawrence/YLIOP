package com.arvato.jesy.lifematters.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.net.HttpHeaders;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ClientCredentialsGrant;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
// @Configuration
// @EnableSwagger2
// public class SwaggerConfiguration extends WebMvcConfigurationSupport {

//     @Bean
//     public Docket appApi() {
//         AuthorizationScope[] authScopes = new AuthorizationScope[1];
//         authScopes[0] = new AuthorizationScopeBuilder().scope("global").description("full access").build();
//         SecurityReference securityReference = SecurityReference.builder().reference("Authorization-Key")
//                 .scopes(authScopes).build();

//         List<SecurityContext> securityContexts = Collections.singletonList(
//                 SecurityContext.builder().securityReferences(Collections.singletonList(securityReference)).build());
//         return new Docket(DocumentationType.SWAGGER_2)
//                 .securitySchemes(Collections.singletonList(new ApiKey("Authorization-Key", "Authorization", "header")))
//                 .securityContexts(securityContexts).apiInfo(apiInfo()).select().build();
//     }

//     private ApiInfo apiInfo() {
//         return new ApiInfoBuilder().title("Swagger API Security REST API")
//                 .description("\"Swagger API Security REST API\"").version("1.0.0").build();
//     }

//     @Override
//     protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//         registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

//         registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//     }
// }

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String AUTH_SERVER = "http://localhost:8080/oauth";
	private static final String CLIENT_ID = "my-trusted-client";
	private static final String CLIENT_SECRET = "secret";

	@Bean
    public Docket produceApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.arvato.jesy.lifematters.controller"))
                .paths(paths())
                .build()
                .securitySchemes(Arrays.asList(securitySchema())) 
                .securityContexts(Collections.singletonList(securityContext()));

     }

     private SecurityScheme securitySchema() {
//        GrantType grantType = new AuthorizationCodeGrantBuilder()
//        .tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
//        .tokenRequestEndpoint(
//          new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_ID))
//        .build();
//        GrantType grantType = new AuthorizationCodeGrantBuilder().tokenEndpoint(new Tok

        //GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(AUTH_SERVER + "/token");

    	GrantType grantType = new ClientCredentialsGrant(AUTH_SERVER + "/token");
        SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
        .grantTypes(Arrays.asList(grantType))
        .scopes(Arrays.asList(scopes()))
        .build();
        
        return oauth;
	}

    private SecurityContext securityContext() {
        return SecurityContext.builder()
          .securityReferences(
            Arrays.asList(new SecurityReference("spring_oauth", scopes())))
          .forPaths(paths()) //PathSelectors.regex("/foos.*"))
          .build();
    }

    //  @Bean
    //  public SecurityConfiguration security() {
    //      return new SecurityConfiguration(CLIENT_ID, CLIENT_SECRET, null, null, "", ApiKeyVehicle.HEADER, "", " ");
    //  }
    @Bean
    public SecurityConfiguration securityInfo() {
        return SecurityConfigurationBuilder.builder()
        .clientId(CLIENT_ID)
        .clientSecret(CLIENT_SECRET)
        .scopeSeparator(" ")
        .useBasicAuthenticationWithAccessCodeGrant(true)
        .build();
        
        //return new SecurityConfiguration(CLIENT_ID, CLIENT_SECRET, CLIENT_ID, CLIENT_ID, "access_token", ApiKeyVehicle.HEADER, "oauthtoken", " ");
    }
    
	private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = { 
            new AuthorizationScope("read", "for read operations"), 
            new AuthorizationScope("write", "for write operations"), 
            new AuthorizationScope("trust", "trust api") };
          return scopes;
    }

	// Describe your apis
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Arvato Alarm REST API")
                .description("This page lists all the rest apis for Arvato Alarm App.").version("1.0-SNAPSHOT").build();
    }

    // Only select apis that matches the given Predicates.
    private Predicate<String> paths() {
        // Match all path except /error
        return Predicates.and(
        //PathSelectors.regex("/private.*"),
        PathSelectors.regex("/arvato.*"),
        Predicates.not(PathSelectors.regex("/error.*")));
    }
}