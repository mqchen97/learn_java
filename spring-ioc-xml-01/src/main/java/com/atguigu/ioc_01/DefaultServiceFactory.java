package com.atguigu.ioc_01;

public class DefaultServiceFactory {
    private ClientServiceImp imp = new ClientServiceImp();

    public ClientServiceImp createInstance(){
        return imp;
    }
}
