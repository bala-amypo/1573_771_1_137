@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme securityScheme = new SecurityScheme()
            .name("Authorization")
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT");

        return new OpenAPI()
      
            .info(new Info()
                .title("SaaS User Role Permission Manager API")
                .version("1.0")
                .description("JWT secured role-permission management"))
            .addSecurityItem(new SecurityRequirement().addList("Authorization"))
            .schemaRequirement("Authorization", securityScheme);
    }
}


