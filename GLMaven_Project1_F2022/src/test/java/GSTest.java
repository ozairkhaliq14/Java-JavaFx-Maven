import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GSTest {
    @Test
    void constructorTest() {
        GenericStack<String> strTest = new GenericStack<String>("Constructor Test");
        GenericStack<Integer> intTest = new GenericStack<Integer>(2);
        assertEquals("Constructor Test", strTest.getHead().data, "incorrect value");
        assertEquals(2, intTest.getHead().data, "incorrect value");
        strTest.dumpList();
        intTest.dumpList();
    }

    @Test
    void pushTest() {
        String str1 = "string1";
        GenericStack<String> strTest = new GenericStack<String>(str1);
        strTest.push("string1");
        assertEquals("string1", strTest.getHead().data, "incorrect value");
    }

    @Test
    void popTest() {
        String str1 = "string1";
        GenericStack<String> strTest = new GenericStack<String>(str1);
        strTest.pop();
        assertEquals(null, strTest.getHead().data, "incorrect value");
    }
}
