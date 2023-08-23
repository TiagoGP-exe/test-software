package ifmt.cba;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExemploBeforeAfterTest{ 
   private int cont;

    @Before
    public void beforeCont() {
        this.cont = 1;
        System.out.println("Before " + this.cont);
    }

    @After
    public void afterCont() {
        System.out.println("After " + this.cont);
    }

    @Test
    public void caso1Test() {
        this.cont += 1;
        assertEquals(2, this.cont);
    }
    
    @Test
    public void caso2Test() {
        this.cont += 2;
        assertEquals(3, this.cont);
    }

    @Test
    public void caso3Test() {
        this.cont += 3;
        assertEquals(4, this.cont);
    }

}
