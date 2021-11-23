package model;

import java.util.List;

public class Trades {
    List<Trade> trades;

    public Trades() {
    }

    public Trades(List<Trade> trades) {
        this.trades = trades;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }
}
