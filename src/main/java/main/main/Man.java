package main.main;

import main.config.ProjectConfig;
import main.model.Car;
import main.model.Dog;
import main.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;
import java.util.function.Supplier;

public class Man {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
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

        Car car[] = new Car[4];
        Car audi = new Car("audi", "red");
        Car bmw1 = new Car("bmw1", "blue");
        Car tesla =new Car("tesla", "white");
        Car bmw2 = new Car("bmw2", "black");

        car[0] = audi;
        car[1] = bmw1;
        car[2] = tesla;
        car[3] = bmw2;

//        for (Car carFromArray : car) {
//            String name = carFromArray.getName();
//            if (Objects.equals(name, "bmw")) {
//                Supplier<Car> carSupplier = () -> carFromArray;
//                context.registerBean(carFromArray.getName(), Car.class, carSupplier);
//            }
//        }

        Supplier<Car> carSupplier1 = () -> bmw1;
        context.registerBean(bmw1.getName(), Car.class, carSupplier1, bc -> bc.setPrimary(true));

        Supplier<Car> carSupplier2 = () -> bmw2;
        context.registerBean(bmw2.getName(), Car.class, carSupplier2);


        Car bmw = context.getBean(Car.class);
        System.out.println(bmw.getName());
        System.out.println(bmw.getColor());

    }

}
