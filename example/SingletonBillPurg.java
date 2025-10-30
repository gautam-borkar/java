package example;

public class SingletonBillPurg {
    private SingletonBillPurg(){

    }

    private static class InnerSingletonBillPurg {
        private static final SingletonBillPurg instance = new SingletonBillPurg();
    }

    public static SingletonBillPurg getInstance(){
        return InnerSingletonBillPurg.instance;
    }

}
