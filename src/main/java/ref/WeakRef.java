package main.java.ref;

import java.lang.ref.WeakReference;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/15 13:52
 * @Description: 弱引用,只要发现，就会回收。
 */
public class WeakRef {

    public static class User{
        private Integer id;
        private String name;

        public User(Integer id, String name) {
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

    public static void main(String[] args) {
        User user = new User(1,"geym");
        WeakReference<User> weakReference = new WeakReference<>(user);
        user = null;

        System.out.println(weakReference.get());
        System.gc();

        System.out.println("After GC:");
        System.out.println(weakReference.get());
    }
}
