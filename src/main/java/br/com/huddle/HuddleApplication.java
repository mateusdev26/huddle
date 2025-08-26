package br.com.huddle;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@Log4j2
public class HuddleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuddleApplication.class, args);
		System.out.println("\n");
		log.info(">>> Docker Hub link : 'https://hub.docker.com/r/mateusdev26/huddle'");
		log.info(">>> Github repository : 'https://github.com/mateusdev26/huddle'");
	}

}
