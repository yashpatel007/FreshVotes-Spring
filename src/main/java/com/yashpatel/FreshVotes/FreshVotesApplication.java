package com.yashpatel.FreshVotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = {"com.yashpatel.domain"}) 
public class FreshVotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshVotesApplication.class, args);
	}

}
