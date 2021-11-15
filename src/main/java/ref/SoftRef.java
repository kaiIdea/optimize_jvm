package main.java.ref;

import java.lang.ref.SoftReference;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/15 10:49
 * @Description: 软引用
 */
public class SoftRef {

    public static class User{

        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("freeHeap:"+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        User user = new User(1,"geym");
        SoftReference<User> userSoftReference = new SoftReference<>(user);
        user = null;
        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftReference.get());
        //Thread.sleep(9000);


        byte[] b = new byte[1024*925*7];
        System.gc();
        System.out.println("result:"+userSoftReference.get());
    }
}
