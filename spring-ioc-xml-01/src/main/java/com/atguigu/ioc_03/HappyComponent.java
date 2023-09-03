package com.atguigu.ioc_03;

public class HappyComponent implements InterfaceHappy{
    @Override
    public void doWork(){
        System.out.println("HAPPYCOMPONENT.DOWORK...");
    }
}
