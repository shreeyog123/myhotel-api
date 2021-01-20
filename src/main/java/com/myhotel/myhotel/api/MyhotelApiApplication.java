package com.myhotel.myhotel.api;

import com.myhotel.myhotel.api.model.UserEntity;
import com.myhotel.myhotel.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class MyhotelApiApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {
		List<UserEntity> users = Stream.of(
				new UserEntity(101, "javatechie", "password", "javatechie@gmail.com"),
				new UserEntity(102, "user1", "pwd1", "user1@gmail.com"),
				new UserEntity(103, "user2", "pwd2", "user2@gmail.com"),
				new UserEntity(104, "user3", "pwd3", "user3@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}


	public static void main(String[] args) {
		SpringApplication.run(MyhotelApiApplication.class, args);
	}

}
