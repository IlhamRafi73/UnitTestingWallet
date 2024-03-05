import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifeCycle {

    @BeforeAll
    void initClass()
    {
        System.out.println("Hello");
    }

    @BeforeEach
    void initMethod()
    {
        System.out.println("Init Method");
    }

    @Test
    void Method1()
    {
        System.out.println("This is method 1");
    }

    @Test
    void Method2()
    {
        System.out.println("This is method 2");
    }

    @AfterEach
    void cleanMethod()
    {
        System.out.println("clean method");
    }

    @AfterAll
    void cleanClassMethod()
    {
        System.out.println("Goodbye");
    }

}
