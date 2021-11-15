package main.java.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/15 13:26
 * @Description: TODO
 */
public class SoftRefQ {


    static class User{


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

    static ReferenceQueue<User> softQueue = null;

    public static class CheckRefQueue extends Thread {

        @Override
        public void run() {
            while (true){
                if(softQueue != null){
                    UserSoftReference obj = null;
                    try {
                        obj = (UserSoftReference) softQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(obj != null){
                        System.out.println("user id "+obj.uid+"is delete");
                    }
                }
            }
        }
    }

    private static class UserSoftReference extends SoftReference<User> {
        int uid;
        public UserSoftReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            uid = referent.id;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();

        User user = new User(1,"geym");

        softQueue = new ReferenceQueue<User>();

        UserSoftReference userSoftReference = new UserSoftReference(user,softQueue);

        user = null;

        System.out.println(userSoftReference.get());

        System.gc();

        System.out.println("After GC:");
        System.out.println(userSoftReference.get());

        System.out.println("try to create byte array and GC");

        byte[] bytes = new byte[1024*925*7];
        System.gc();
        System.out.println(userSoftReference.get());

        Thread.sleep(1000);

    }
}
