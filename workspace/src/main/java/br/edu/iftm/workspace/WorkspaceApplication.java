package br.edu.iftm.workspace;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableEurekaClient
@EnableMongoRepositories
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "Workspace API", version = "1.0", description = "Management Workspace and Base API"))
public class WorkspaceApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorkspaceApplication.class, args);
	}
}
