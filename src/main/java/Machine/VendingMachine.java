package Machine;

import Products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawers;
    private double credit;
    private CoinReturn coinReturn;

    public VendingMachine(ArrayList<Drawer> drawers, CoinReturn coinReturn) {
        this.drawers = drawers;
        this.credit = 0.0;
        this.coinReturn = coinReturn;
    }

    public double getCredit() {
        return credit;
    }

    public CoinReturn getCoinReturn() {
        return coinReturn;
    }

    public boolean checkCoinValid(Coin coin){
        return coin.getType() != CoinType.ONEPENCE && coin.getType() != CoinType.TWOPENCE;
    }

    public void addCoin(Coin coin){
        if(checkCoinValid(coin)){
            this.credit += coin.getValue();
        } else {
            this.coinReturn.addCoin(coin);
        }
    }

    public Product vend(DrawerCode code){
        for (Drawer drawer : this.drawers){
            if (code == drawer.getCode() && this.credit >= drawer.getPrice()){
                this.credit = 0.0;
                return drawer.vendProduct();
            }
        }
        return null;
    }


}
