package ifmt.cba;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExemploBeforeClassAfterClassTest {
    private static int cont;


    @BeforeClass
    public static void beforeClassCont () {
        cont = 1;
        System.out.println("BeforeClass " + cont);
    }

    @Before
    public void beforeCont() {
        cont++;
        System.out.println("Before " + cont);
    }

    @AfterClass
    public static void afterClassCont() {
        System.out.println("After " + cont);
    }

    @After
    public void afterCont() {
        System.out.println("After " + cont);
    }

    @Test
    public void caso1Test() {
        cont += 1;
        assertEquals(3, cont);
    }
    
    @Test
    public void caso2Test() {
        cont += 2;
        assertEquals(6, cont);
    }

    @Test
    public void caso3Test() {
        cont += 3;
        assertEquals(10, cont);
    }
}
