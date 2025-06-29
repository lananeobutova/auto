// StringOperationsTest.java

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StringOperationsTest {

    StringOperations stringOps;

    @BeforeTest
    public void setUp() {
        stringOps = new StringOperations();
        System.out.println("Настройка теста...");
    }

    @Test
    public void testConcatenate() {
        String result = stringOps.concatenate("Hello, ", "World!");
        Assert.assertEquals(result, "Hello, orld!", "Метод concatenate работает некорректно!");
        System.out.println(result);
    }

    @Test
    public void testGetLength() {
        int length = stringOps.getLength("Hello");
        Assert.assertEquals(length, 7, "Метод getLength работает некорректно!");
        System.out.println(length);
    }

    @AfterTest
    public void tearDown() {
        stringOps = null;
        System.out.println("Тест завершен...");
    }
}
