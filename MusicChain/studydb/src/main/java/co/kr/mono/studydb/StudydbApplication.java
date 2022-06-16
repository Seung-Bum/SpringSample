package co.kr.mono.studydb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan(basePackages = {"co.kr.mono.studydb.dao"}, annotationClass = org.apache.ibatis.annotations.Mapper.class)
public class StudydbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudydbApplication.class, args);
	}

}
