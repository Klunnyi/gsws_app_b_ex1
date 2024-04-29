package main.config;

import main.model.Parrot;
//import main.model.Person;
import main.proxies.CommentNotificationProxy;
import main.repositories.CommentRepository;
import main.services.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "main")
public class ProjectConfig {

    @Bean("comService")
    @Lazy
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CommentService commentService (CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        return new CommentService(commentRepository, commentNotificationProxy);
    }

    @Bean(name = "Koko")
//    @Primary
    public Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean()
    @Primary
    public Parrot parrot1() {
        var p = new Parrot();
        p.setName("Test");
        return p;
    }

    @Bean(value = "miki")
    public Parrot parrot2() {
        var p = new Parrot();
        p.setName("Miki");
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

    //    @Bean("riki")
//    public Parrot parrot3() {
//        var p = new Parrot();
//        p.setName("Riki");
//        return p;
//    }

//    @Bean(name = "p")
//    @Primary
//    public Parrot p() {
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
