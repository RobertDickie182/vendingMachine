import Products.Crisps;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrispsTest {

    Crisps crisps;

    @Before
    public void before(){
        crisps = new Crisps("Walkers", "Cheese and Onion");
    }

    @Test
    public void hasName() {
        assertEquals("Walkers", crisps.getName());
    }


    @Test
    public void hasFlavour(){
        assertEquals("Cheese and Onion", crisps.getFlavour());
    }
}
