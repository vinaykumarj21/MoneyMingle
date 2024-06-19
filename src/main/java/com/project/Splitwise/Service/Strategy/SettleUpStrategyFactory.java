package com.project.Splitwise.Service.Strategy;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategy(){
        return new HeapBasedSettleUpStrategy();
    }
}
