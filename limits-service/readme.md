
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-config</artifactId> -- this is dependency of spring config client
</dependency>

spring.application.name=limits-service

spring.config.import=optional:configserver:http://localhost:8888 -- this is to connect configserver

spring.profiles.active=dev
spring.cloud.config.profile=dev -- this is to pick dev profile