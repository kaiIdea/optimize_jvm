package main.java.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/15 14:06
 * @Description: TODO
 */
public class TraceCanReliveObj {


    public static TraceCanReliveObj obj;

    static ReferenceQueue<TraceCanReliveObj> phantomQueue = null;

    public static class CheckRefQueue extends Thread{

        @Override
        public void run() {
            while (true){
                if(phantomQueue != null){
                    PhantomReference<TraceCanReliveObj> objt = null;
                    try {
                        objt = (PhantomReference<TraceCanReliveObj>) phantomQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(objt != null){
                        System.out.println("TraceCanReliveObj is delete by GC");
                    }
                }
            }
        }

    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("TraceCanReliveObj finalize called...");
        obj = this;
    }

    @Override
    public String toString() {
        return "I am TraceCanReliveObj";
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();


        phantomQueue = new ReferenceQueue<>();
        obj = new TraceCanReliveObj();
        PhantomReference<TraceCanReliveObj> phantomReference = new PhantomReference<>(obj,phantomQueue);


        obj = null;
        System.gc();
        Thread.sleep(1000);
        if(obj == null){
            System.out.println("1.obj is null");
        }else {
            System.out.println("1.obj 可用");
        }


        System.out.println("****第二次 GC");
        obj = null;
        System.gc();
        Thread.sleep(1000);
        if(obj == null){
            System.out.println("2.obj is null");
        }else {
            System.out.println("2.obj 可用");
        }
    }
}
