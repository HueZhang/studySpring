package com.huey.todo.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;


public class OpenApiConfig {

    /*@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // 1. 基本信息
                .info(new Info()
                        .title("电商平台 API")
                        .version("v1.0")
                        .description("电商平台后端接口文档")
                        .termsOfService("https://example.com/terms")
                        .contact(new Contact()
                                .name("技术支持")
                                .email("dev@example.com")
                                .url("https://example.com"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")))

                // 2. 服务器配置（多环境）
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("开发环境"),
                        new Server()
                                .url("https://api.example.com")
                                .description("生产环境")
                ))

                // 3. 安全配置（JWT示例）
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("请输入JWT Token（无需Bearer前缀）")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))

                // 4. 全局参数/响应头（可选）
                .components(new Components()
                        .addParameters("versionParam", new io.swagger.v3.oas.models.parameters.Parameter()
                                .in("header")
                                .name("X-API-Version")
                                .required(false)
                                .schema(new io.swagger.v3.oas.models.media.Schema().type("string"))
                                .description("API版本号")));
    }*/
}