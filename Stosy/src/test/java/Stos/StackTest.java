package Stos;

import org.junit.*;

import static org.junit.Assert.*;
public class StackTest {

    private Stack stack;
    @Before
    public void setUp() {
        stack = new Stack();
    }

    @Test
    public void testPush() {
        stack.push("Test");
        assertArrayEquals(new String[] {"Test"}, stack.getStos());

    }

    @Test
    public void testPush2() {
        stack.push("Test");
        stack.push("Test2");
        assertArrayEquals(new String[] {"Test","Test2"}, stack.getStos());

    }


    @Test
    public void testPush3() {
        stack.push("Test");
        stack.push("Test2");
        stack.push("A");
        stack.push("B");
        stack.push("BLA/");
        assertArrayEquals(new String[] {"Test","Test2","A","B","BLA/"}, stack.getStos());
    }

    @Test
    public void testPushError(){
        Exception exception = assertThrows(RuntimeException.class, () -> stack.push(null));
        assertEquals("Element nie moze byc pusty", exception.getMessage());
    }

    @Test
    public void testPushError2(){
        stack.push("Test");
        stack.push("Test2");
        assertThrows(RuntimeException.class, () -> stack.push(null));
        assertArrayEquals(new String[] {"Test","Test2"}, stack.getStos());
    }
    @Test
    public void testPop(){
        stack.push("Test");
        stack.push("Test2");
        stack.pop();
        assertArrayEquals(new String[] {"Test"}, stack.getStos());
    }

    @Test
    public void testPopError(){
        Exception exception = assertThrows(RuntimeException.class, () -> stack.pop());
        assertEquals("Stos jest pusty!", exception.getMessage());
    }

    @Test
    public void testPop2(){
        stack.push("Test");
        stack.push("Test2");
        String x = stack.pop();
        assertEquals("Test2",x);
    }

    @Test
    public void testPeek(){
        stack.push("Test");
        stack.push("Test2");
        String x = stack.peek();
        assertEquals("Test2",x);
    }

    @Test
    public void testPeek2(){
        stack.push("Test");
        stack.push("Test2");
        stack.peek();
        assertArrayEquals(new String[] {"Test","Test2"}, stack.getStos());
    }

    @Test
    public void testPeekError(){
        Exception exception = assertThrows(RuntimeException.class, () -> stack.peek());
        assertEquals("Stos jest pusty!", exception.getMessage());
    }
}
