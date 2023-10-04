import Products.Drink;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    Drink drink;

    @Before
    public void before(){
        drink = new Drink("Cola");
    }

    @Test
    public void hasName() {
        assertEquals("Cola", drink.getName());
    }
}
