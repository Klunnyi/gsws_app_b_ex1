package main.srart;

import com.sun.tools.javac.Main;
import main.config.ProjectConfig;
import main.model.*;
import main.proxies.EmailCommentNotificationProxy;
import main.repositories.DBCommentRepository;
import main.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class Man {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = c.getBean(Parrot.class);
        System.out.println(p.getName());

//        Parrot bean2 = c.getBean("parrot2",Parrot.class);
//        System.out.println(bean2.getName());
//
//        Parrot bean3 = c.getBean("parrot3",Parrot.class);
//        System.out.println(bean3.getName());

//        Integer ten = c.getBean("ten", Integer.class);
//        System.out.println(ten);
//
//        String hello = c.getBean("hello", String.class);
//        System.out.println(hello);
//
//
//        String bean1 = c.getBean(String.class);
//        System.out.println(bean1);
//
//        Integer bean2 = c.getBean(Integer.class);
//        System.out.println(bean2);


//        var service = c.getBean("commentService", CommentService.class);
//
//        Comment comment = new Comment();
//        comment.setText("Demo comment");
//        comment.setAuthor("Natasha");

        //service.publishComment(comment);
//        service.deleteComment(comment);
//        service.editComment(comment);


        //logger.info(value);

//        var c = new AnnotationConfigApplicationContext(
//        ProjectConfig.class);
//
//        System.out.println("Before retrieving the CommentService");
//        var service = c.getBean("commentService", CommentService.class);
//        System.out.println("After retrieving the CommentService");

//        var commentRepository = new DBCommentRepository();
//        var commentNotificationProxy = new EmailCommentNotificationProxy();
//        var commentService = new CommentService(commentRepository, commentNotificationProxy);
//        var comment = new Comment();
//        comment.setAuthor("Laurentiu");
//        comment.setText("Demo comment");
//        commentService.publishComment(comment);

//        var comment = new Comment();
//        comment.setAuthor("Laurentiu");
//        comment.setText("Demo comment");
//        var commentService = context.getBean(CommentService.class);
//        commentService.publishComment(comment);

//        CommentService comService1 = context.getBean("comService", CommentService.class);
//        CommentService comService2 = context.getBean("comService", CommentService.class);
//
//        System.out.println(comService1 == comService2);


//        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
//
//        Person person = context.getBean("person", Person.class);
//        System.out.println(person);

//        Parrot parrot = context.getBean("parrot", Parrot.class);
//        System.out.println(parrot);


//        Parrot getParrot = context.getBean(Parrot.class);
//        getParrot.setName("Tom");
//
//        Parrot getParrot2 = context.getBean("parrot", Parrot.class);
//        System.out.println(getParrot2);

//        Parrot getParrot = context.getBean("miki", Parrot.class);
//        System.out.println(getParrot);
//
//        String s = context.getBean(String.class);
//        System.out.println(s);
//
//        Integer i = context.getBean(Integer.class);
//        System.out.println(i);

//        Dog dog = context.getBean(Dog.class);
//        dog.setId(1);
//        System.out.println(dog);
//
//        dog.setName("Ram");
//        System.out.println(dog);

        //Создать четыре машины, бмв добавить в контекст

//        Car car[] = new Car[4];
//        Car audi = new Car("audi", "red");
//        Car bmw1 = new Car("bmw1", "blue");
//        Car tesla =new Car("tesla", "white");
//        Car bmw2 = new Car("bmw2", "black");
//
//        car[0] = audi;
//        car[1] = bmw1;
//        car[2] = tesla;
//        car[3] = bmw2;

//        for (Car carFromArray : car) {
//            String name = carFromArray.getName();
//            if (Objects.equals(name, "bmw")) {
//                Supplier<Car> carSupplier = () -> carFromArray;
//                context.registerBean(carFromArray.getName(), Car.class, carSupplier);
//            }
//        }

//        Supplier<Car> carSupplier1 = () -> bmw1;
//        context.registerBean(bmw1.getName(), Car.class, carSupplier1, bc -> bc.setPrimary(true));
//
//        Supplier<Car> carSupplier2 = () -> bmw2;
//        context.registerBean(bmw2.getName(), Car.class, carSupplier2);
//
//
//        Car bmw = context.getBean(Car.class);
//        System.out.println(bmw.getName());
//        System.out.println(bmw.getColor());

    }

}
