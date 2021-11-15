package main.java.ref;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/15 10:28
 * @Description: TODO
 */
public class CanReliveObj {

    private static CanReliveObj obj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("CanReliveObj finalize called...");
        obj = this;
    }

    public static void main(String[] args) throws InterruptedException {

        obj = new CanReliveObj();
        obj = null;
        System.gc();
        Thread.sleep(1000);

        if(obj == null){
            System.out.println("1.obj is null");
        }else{
            System.out.println("1.obj 可用");
        }

        System.out.println("*******第二次 GC");

        obj = null;
        System.gc();
        Thread.sleep(1000);
        if(obj == null){
            System.out.println("2.obj is null");
        }else{
            System.out.println("2.obj 可用");
        }



        StringBuffer str = new StringBuffer("Hello world");
        StringBuffer str1 = str;
        if(str == str1){
            System.out.println("equal...");
        }

        str.append("1");

        System.out.println(str1);
    }
}
