package com.shopMe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("com.shopMe.product.infrastructure.repositories")
@EntityScan(basePackages = { "com.shopMe.product.domainmodel.entities",
		"com.shopMe.product.domainmodel.aggregateroot" })
@EnableTransactionManagement
@ComponentScan("com.shopMe.product.interfaces.rest.transform")
public class ShopMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopMeApplication.class, args);
	}

}
