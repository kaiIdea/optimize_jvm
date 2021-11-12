package main.java;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/12 10:45
 * @Description:
 */
public class TestStackGc {

    public void localvarGc1(){
        byte[] bytes = new byte[6*1024*1024];
        System.gc();
    }
    public void localvarGc2(){
        byte[] bytes = new byte[6*1024*1024];
        bytes = null;
        System.gc();
    }
    public void localvarGc3(){
        {
            byte[] bytes = new byte[6*1024*1024];
        }
        System.gc();
    }
    public void localvarGc4(){
        {
            byte[] bytes = new byte[6*1024*1024];
        }
        int c = 10;
        System.gc();
    }
    public void localvarGc5(){
        localvarGc1();
        System.gc();
    }

    public static void main(String[] args) {
        TestStackGc stackGc = new TestStackGc();
        stackGc.localvarGc3();
    }
}
