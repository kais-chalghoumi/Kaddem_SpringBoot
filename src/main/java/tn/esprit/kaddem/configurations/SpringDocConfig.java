package tn.esprit.kaddem.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        return new Contact().name("Equipe ASI II")
                .email("*************@esprit.tn")
                .url("https://www.linkedin.com/in/**********/");
    }

    @Bean
    public GroupedOpenApi contratPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Contrat Management API")
                .pathsToMatch("/contrat/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi departementPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Departement Management API")
                .pathsToMatch("/departement/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi detailEquipePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only DetailEquipe Management API")
                .pathsToMatch("/detailEquipe/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi equipePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Equipe Management API")
                .pathsToMatch("/equipe/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi etudiantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Etudiant Management API")
                .pathsToMatch("/etudiant/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi universitePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Universite Management API")
                .pathsToMatch("/universite/**")
                .pathsToExclude("**")
                .build();
    }

}


