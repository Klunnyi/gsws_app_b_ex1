package tests;

import main.config.ProjectConfig;
import main.model.Dog;
import main.model.Parrot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that a Parrot instance " +
            "with the attribute name having the value Koko " +
            "has been added to the Spring context.")
    public void testKokoIsInTheSpringContext() {
        Parrot p = context.getBean(Parrot.class);

        assertEquals("Koko", p.getName());
    }

    @Test
    @DisplayName("Test that the String 'hello' " +
            "has been added to the Spring context.")
    public void testHelloIsInTheSpringContext() {
        String s = context.getBean(String.class);

        assertEquals("Hello", s);
    }

    @Test
    @DisplayName("Test that the Integer 10 " +
            "has been added to the Spring context.")
    public void test10IsInTheSpringContext() {
        Integer i = context.getBean(Integer.class);

        assertEquals(10, i);
    }

    @Test
    @DisplayName("Test that the Parrot instance parrot1 named Koko is primary")
    public void testParrot1IsPrimary() {
        Parrot p = context.getBean(Parrot.class);

        assertEquals("Koko", p.getName());
    }

    @Test
    @DisplayName("Test that the Parrot instance parrot1 has name Koko")
    public void testParrot1HasTheNameKoko() {
        Parrot parrot1 = context.getBean("koko", Parrot.class);

        assertEquals("Koko", parrot1.getName());
    }

    @Test
    @DisplayName("Test that a Dog instance without a name has been added to the Spring context")
    public void testDogWasAdded() {
        Dog dog = context.getBean(Dog.class);

        assertNotNull(dog);
       //assertNull(dog.getName());
    }

    @Test
    @DisplayName("Test that a Dog instance with a name 'Rex' has been added to the Spring context")
    public void testInDogWasAddedPostContract() {
        Dog dog = context.getBean(Dog.class);

        assertNotNull(dog);
        assertEquals("Rex", dog.getName());
    }


}
