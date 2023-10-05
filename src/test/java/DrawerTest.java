import MachineComponents.Drawer;
import MachineComponents.DrawerCode;
import Products.Sweets;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrawerTest {

    Drawer drawer;
    Sweets sweet;

    @Before
    public void before(){
        drawer = new Drawer(DrawerCode.A1, 0.65);
        sweet = new Sweets("Mars");
    }

    @Test
    public void hasCode() {
        assertEquals(DrawerCode.A1, drawer.getCode());
    }

    @Test
    public void hasPrice() {

    }

    @Test
    public void startsEmpty() {
        assertEquals(0, drawer.itemCount());
    }

    @Test
    public void canAddItem(){
        drawer.addItem(sweet);
        assertEquals(1, drawer.itemCount());
    }

    @Test
    public void canVendItem(){
        drawer.addItem(sweet);
        Sweets sweet = (Sweets) drawer.vendProduct();
        assertEquals("Mars", sweet.getName());
    }
}
