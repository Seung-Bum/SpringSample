package org.springframework.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 하위의 파일들을 모두 불러온다.
public class SpringMvcShowcaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcShowcaseApplication.class, args);
	}

}
//webapp\WEB-INF\jsp