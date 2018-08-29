package com.sdsxer.mmdiary;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MMDiaryApplication {

  public static void main(String[] args) {
    SpringApplication.run(MMDiaryApplication.class, args);
  }
}
