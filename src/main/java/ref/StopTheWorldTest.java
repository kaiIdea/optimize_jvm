package main.java.ref;

import java.util.HashMap;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/15 14:58
 * @Description: TODO
 */
public class StopTheWorldTest {

    public static class MyThread extends Thread{
        HashMap map = new HashMap();
        @Override
        public void run() {
            try {
                while (true){
                    if(map.size()*512/1024/1024 >= 800){
                        map.clear();
                        System.out.println("clean map");
                    }
                    byte[] b1;
                    for (int i = 0; i < 100; i++) {
                        b1 = new byte[512];
                        map.put(System.nanoTime(),b1);
                    }
                    //System.out.println(map.size());
                    Thread.sleep(1);
                }
            } catch (Exception e) {
            }
        }
    }

    public static class PrintThread extends Thread{
        public static final long startTime = System.currentTimeMillis();

        @Override
        public void run() {
            try {
               while (true){
                   long t= System.currentTimeMillis() - startTime;
                   System.out.println(t/1000+"."+t%1000);
                   Thread.sleep(100);
               }
            } catch (Exception e) {
            }
        }
    }


    public static void main(String[] args) {
        MyThread t = new MyThread();
        PrintThread p = new PrintThread();
        t.setName("accept RAM");
        t.start();
        p.start();
    }
}
