import MachineComponents.Coin;
import MachineComponents.CoinReturn;
import MachineComponents.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    Coin onePence;
    Coin twoPence;
    Coin tenPence;

    Coin fivePence;
    CoinReturn coinReturn;

    @Before
    public void before(){
        onePence = new Coin(CoinType.ONEPENCE);
        twoPence = new Coin(CoinType.TWOPENCE);
        fivePence = new Coin(CoinType.FIVEPENCE);
        tenPence = new Coin(CoinType.TENPENCE);
        coinReturn = new CoinReturn();
    }

    @Test
    public void startEmpty(){
        assertEquals(0.0, coinReturn.getValueOfCoins(), 0.01);
    }

    @Test
    public void canGetCoinTotal(){
        coinReturn.addCoin(tenPence);
        coinReturn.addCoin(onePence);
        assertEquals(0.11, coinReturn.getValueOfCoins(), 0.01);
    }
}
