import Machine.VendingMachine;
import MachineComponents.*;
import Products.Sweets;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    Coin onePence;
    Coin twoPence;
    Coin tenPence;
    Coin fivePence;
    Coin fiftyPence;
    Drawer drawer;
    CoinReturn coinReturn;
    VendingMachine machine;
    Sweets sweet;

    @Before
    public void before(){
        onePence = new Coin(CoinType.ONEPENCE);
        twoPence = new Coin(CoinType.TWOPENCE);
        tenPence = new Coin(CoinType.TENPENCE);
        fivePence = new Coin(CoinType.FIVEPENCE);
        fiftyPence = new Coin(CoinType.FIFTYPENCE);
        drawer = new Drawer(DrawerCode.A1, 0.50);
        sweet = new Sweets("Mars");
        drawer.addItem(sweet);
        ArrayList<Drawer> drawers = new ArrayList<>();
        drawers.add(drawer);
        coinReturn = new CoinReturn();
        machine = new VendingMachine(drawers, coinReturn);
    }

    @Test
    public void canAcceptCoins() {
        machine.addCoin(tenPence);
        assertEquals(0.10, machine.getCredit(), 0.01);
    }

    @Test
    public void cannotAcceptInvalidCoins(){
        machine.addCoin(onePence);
        machine.addCoin(twoPence);
        assertEquals(0.0, machine.getCredit(), 0.01);
        assertEquals(0.03, machine.getCoinReturn().getValueOfCoins(), 0.01);
    }

    @Test
    public void invalidCoinReturns(){
        machine.addCoin(onePence);
        assertEquals(0.01, machine.getCoinReturn().getValueOfCoins(), 0.01);
    }

    @Test
    public void canBuyProduct(){
        machine.addCoin(fiftyPence);
        Sweets product = (Sweets) machine.vend(DrawerCode.A1);
        assertEquals("Mars", product.getName());
        assertEquals(0.00, machine.getCredit(), 0.01);
    }




//    @Test
//    public void notEnoughMoneyReturnsNull(){
//        machine.addCoin(tenPence);
//        machine.addCoin(tenPence);
//        Sweets sweet = (Sweets)machine.vend(DrawerCode.A1);
//        assertNull(sweet);
//    }
}
