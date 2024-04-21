package main.config;

import main.model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "main")
public class ProjectConfig {

    @Bean(name = "koko")
    @Primary
    public Parrot parrot1() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean(value = "miki")
    public Parrot parrot2() {
        var p = new Parrot();
        p.setName("Miki");
        return p;
    }

    @Bean("riki")
    public Parrot parrot3() {
        var p = new Parrot();
        p.setName("Riki");
        return p;
    }

    @Bean
    public String hello() {
        return "Hello";
    }

    @Bean
    @Primary
    public Integer ten() {
        return 10;
    }

    @Bean
    public Integer five() {
        return 5;
    }

}
