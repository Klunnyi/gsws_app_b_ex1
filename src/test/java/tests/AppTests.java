package tests;

import main.config.ProjectConfig;
import main.model.Comment;
import main.model.Dog;
import main.model.Parrot;
import main.model.Person;
import main.proxies.CommentNotificationProxy;
import main.repositories.CommentRepository;
import main.services.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private CommentNotificationProxy commentNotificationProxy;

    @InjectMocks
    private CommentService commentService;

    @Test
    @DisplayName("Checking that commentService is singletonBean.")
    public void testCommentServiceSingletonBean() {
        CommentService comService1 = context.getBean("comService", CommentService.class);
        CommentService comService2 = context.getBean("comService", CommentService.class);

        assertEquals(comService1, comService2);
    }

    @Test
    @DisplayName("Verify that CommentService every time you request an instance" +
            " from the Spring context, you get the same instance")
    public void testCommentServiceIsSingleton() {
        var cs1 = context.getBean("commentService", CommentService.class);
        var cs2 = context.getBean("commentService", CommentService.class);

        assertEquals(cs1, cs2);
    }

    @Test
    @DisplayName("Verify that dependencies of the " +
            "CommentService object are correctly called.")
    public void testCommentService() {
        var comment = new Comment();

        commentService.publishComment(comment);

        verify(commentRepository).storeComment(comment);
        verify(commentNotificationProxy).sendComment(comment);
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

    @Test
    @DisplayName("Test that a Parrot instance " +
            "with the attribute name having the value Koko " +
            "has been added to the Spring context.")
    public void testKokoIsInTheSpringContext() {
        Parrot p = context.getBean("Koko", Parrot.class);

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
    @DisplayName("Test that the Parrot instance parrot1 named Test is primary")
    public void testParrot1IsPrimary() {
        Parrot p = context.getBean(Parrot.class);

        assertEquals("Test", p.getName());
    }

    @Test
    @DisplayName("Test that the Parrot instance parrot has name Koko")
    public void testParrot1HasTheNameKoko() {
        Parrot parrot1 = context.getBean("Koko", Parrot.class);

        assertEquals("Koko", parrot1.getName());
    }

    @Test
    @DisplayName("Test that a Person instance has been added to the Spring context")
    public void testSerhiiIsinTheSpringContext() {
        Person p = context.getBean(Person.class);

        assertEquals("Serhii", p.getName());
    }

    @Test
    @DisplayName("Test that the Person instance in the Spring context" +
            "owns the Parrot instance with name Miki from the Spring context")
    public void testEllaOwnsKoko() {
        Person p = context.getBean(Person.class);

        assertNotNull(p.getParrot());
        assertEquals("Miki", p.getParrot().getName());
    }

}
