package it.unical.prontoMiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ProntoMiaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProntoMiaoApplication.class, args);
	}

}
