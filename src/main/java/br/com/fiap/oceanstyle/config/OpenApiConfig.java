package br.com.fiap.oceanstyle.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Ocean Style API", version = "1.0", description = "API do projeto Ocean Style"), tags = {
    @Tag(name = "Empresas"),
    @Tag(name = "Veiculos"),
    @Tag(name = "Vistorias"),
    @Tag(name = "Inspetores"),
    @Tag(name = "Cidades"),
    @Tag(name = "Estados"),
    @Tag(name = "Enderecos")
})
public class OpenApiConfig {

}
