package RPN;

import org.junit.*;

import static org.junit.Assert.*;
public class RPNTest {
    private RPN rpn;

    @Before
    public void setUP(){
        rpn = new RPN();
    }

    @Test
    public void testWyrazenie1(){
        rpn.setCiag("3 4 + 2 *");
        int x = rpn.oblicz();
        assertEquals(14, x);
    }
    @Test
    public void testWyrazenie2(){
        rpn.setCiag("5 3 4 * + 2 -");
        int x = rpn.oblicz();
        assertEquals(15, x);
    }

    @Test
    public void testBrakliczb(){
        rpn.setCiag("+ - *");
        Exception exception = assertThrows(RuntimeException.class, () -> rpn.oblicz());
        assertEquals("Stos jest pusty!", exception.getMessage());
    }

    @Test
    public void testSameLiczby(){
        rpn.setCiag("3 4 5 6");
        Exception exception = assertThrows(RuntimeException.class, () -> rpn.oblicz());
        assertEquals("Znak na końcu nie może być liczbą", exception.getMessage());
    }

    @Test
    public void testSameLiczby2(){
        rpn.setCiag("3");
        Exception exception = assertThrows(RuntimeException.class, () -> rpn.oblicz());
        assertEquals("Znak na końcu nie może być liczbą", exception.getMessage());
    }

    @Test
    public void testZaDuzoLiczb(){
        rpn.setCiag("3 4 5 *");
        Exception exception = assertThrows(RuntimeException.class, () -> rpn.oblicz());
        assertEquals("Za długi ciąg liczb", exception.getMessage());
    }

    @Test
    public void testZaMaloLiczb(){
        rpn.setCiag("3    *");
        Exception exception = assertThrows(RuntimeException.class, () -> rpn.oblicz());
        assertEquals("Stos jest pusty!", exception.getMessage());
    }

    @Test
    public void testZaDuzoOperacji(){
        rpn.setCiag("3 4 + + +  *");
        Exception exception = assertThrows(RuntimeException.class, () -> rpn.oblicz());
        assertEquals("Stos jest pusty!", exception.getMessage());
    }

    @Test
    public void testNull(){
        rpn.setCiag(null);
        Exception exception = assertThrows(RuntimeException.class, () -> rpn.oblicz());
        assertEquals("Ciąg jest pusty", exception.getMessage());
    }

    @Test
    public void testZleZnaki(){
        rpn.setCiag("bla BLA BLA/");
        Exception exception = assertThrows(RuntimeException.class, () -> rpn.oblicz());
        assertEquals("Znak nie jest liczbą ani operacją", exception.getMessage());

    }

    @Test
    public void testZleZnaki2(){
        rpn.setCiag("4 5 ++");
        Exception exception = assertThrows(RuntimeException.class, () -> rpn.oblicz());
        assertEquals("Znak nie jest liczbą ani operacją", exception.getMessage());

    }

    @Test
    public void testLiczbaDwucyfrowa() {
        rpn.setCiag("15 5 +");
        int x = rpn.oblicz();
        assertEquals(20, x);
    }
}
