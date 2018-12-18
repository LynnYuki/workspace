
public class Main {

    public static void main(String[] args) {
        Integer a = 1000,b = 1000;
        Integer c = 100,d = 100;
        Integer e = 128,f = 128;
        Integer g = -128,h = -128;
        Character m = 128,n = 128;
        Character j = 127,k = 127;
        //Long ,Short 类似，valueof()方法中缓存范围是[-128,128),否则创建新对象
        System.out.println(a.equals(b));//true
        System.out.println(a == b);//false
        System.out.println(c == d);//true
        System.out.println(e.equals(f));//true
        System.out.println(e == f);//false
        System.out.println(g == h);//true
        System.out.println(m == n);//false
        System.out.println(j == k);//true
    }
}
