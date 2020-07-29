package com.twu;

public class Hot{
    private String desc;
    private int pot;
    private int factor;
    private int money = 0;
    private int fixlevel = 0;

//    public Hot(String desc, int pot) {
//        setDesc(desc);
//        setPot(pot);
//    }

    public Hot(String desc, int pot, int factor) {
        setDesc(desc);
        setPot(pot);
        setFactor(factor);
    }

    public String getDesc() {
        return desc;
    }

    public int getPot() {
        return pot;
    }

    public int getFactor() {
        return factor;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public int getFixlevel() {
        return this.fixlevel;
    }

    public void setFixlevel(int level){
        this.fixlevel = level;
    }
}

