package com.pipichao.spring.dataaccess.transactionmanagement.xmlbased;


public class MService {

    public String index(){
        return "";
    }

//    @Transactional
    public void insertFoo(Foo foo)throws Exception{
        //insert  db
        throw new Exception();
        //如何看出回滚还是没回滚

    }
}
