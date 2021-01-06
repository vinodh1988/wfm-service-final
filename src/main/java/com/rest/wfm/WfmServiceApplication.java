package com.rest.wfm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"com.rest.wfm.*"})
@EntityScan(basePackages = {"com.rest.wfm.entity"})
@EnableJpaRepositories(basePackages= {"com.rest.wfm.repositories"})
@EnableScheduling
@SpringBootApplication
public class WfmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WfmServiceApplication.class, args);
	}

}
