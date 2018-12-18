package test;


public class TestDemo implements TestInterfaceImpl {
    @Override
    public void sayHello() {
        System.out.println("Hello");
    }

    public void sayHi() {
        System.out.println("Hi");
    }
}
