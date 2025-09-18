package com.project.MoneyMingle.Service.Strategy;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategy(){
        return new HeapBasedSettleUpStrategy();
    }
}
