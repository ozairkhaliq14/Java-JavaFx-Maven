import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GQTest {


    @Test
    void constructorTest() {
        GenericQueue<String> strTest = new GenericQueue<String>("Constructor Test");
        GenericQueue<Integer> intTest = new GenericQueue<Integer>(2);
        assertEquals("Constructor Test", strTest.getHead().data, "incorrect value");
        assertEquals(2, intTest.getHead().data, "incorrect value");
        strTest.dumpList();
        intTest.dumpList();
    }

    @Test
    void enqueueTest() {
        String str1 = "string1";
        GenericQueue<String> strTest = new GenericQueue<String>(str1);
        strTest.enqueue("string1");
        assertEquals("string1", strTest.getHead().data, "incorrect value");
    }

    @Test
    void dequeueTest() {
        String str1 = "string1";
        GenericQueue<String> strTest = new GenericQueue<String>(str1);
        strTest.dequeue();
        assertEquals(null, strTest.getHead().data, "incorrect value");
    }
}
