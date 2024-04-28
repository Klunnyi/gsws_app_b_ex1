package main.config;

import main.model.Parrot;
//import main.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "main")
public class ProjectConfig {

//    @Bean(name = "koko")
////    @Primary
//    public Parrot parrot1() {
//        var p = new Parrot();
//        p.setName("Koko");
//        return p;
//    }
//
//    @Bean(value = "miki")
//    public Parrot parrot2() {
//        var p = new Parrot();
//        p.setName("Miki");
//        return p;
//    }

//    @Bean("riki")
//    public Parrot parrot3() {
//        var p = new Parrot();
//        p.setName("Riki");
//        return p;
//    }
//
//    @Bean
//    public String hello() {
//        return "Hello";
//    }
//
//    @Bean
//    @Primary
//    public Integer ten() {
//        return 10;
//    }
//
//    @Bean
//    public Integer five() {
//        return 5;
//    }
//
//    @Bean(name = "parrot")
//    @Primary
//    public Parrot parrot() {
//        Parrot p = new Parrot();
//        p.setName("Test");
//        return p;
//    }

//    @Bean(name = "person")
//    public Person person(@Qualifier("riki") Parrot parrot) {
//        Person p = new Person();
//        p.setName("Serhii");
//        p.setParrot(parrot);
//        return p;
//    }

}
