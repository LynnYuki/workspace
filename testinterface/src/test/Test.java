package test;


public class Test {
    public static TestInterfaceImpl testImpl = getTest();
    public static void main(String[] args) {
        testImpl.sayHello();
//        testImpl.sayHi();//子类独有方法丢失
    }

    public static TestInterfaceImpl getTest(){
        TestInterfaceImpl testDemo = new TestDemo();//向上转型
        return testDemo;
    }
}
