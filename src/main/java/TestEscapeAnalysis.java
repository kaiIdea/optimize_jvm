package main.java;

import main.java.model.ChineseName;
import main.java.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/12 11:28
 * @Description: 逃逸分析
 */
public class TestEscapeAnalysis {

    public void getUserData(){
        System.out.println("-free before:"+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        List<User> list = new ArrayList<>();
        for(long i= 0;i<3000;i++){
            User user = new User(i+1, ChineseName.getUserName(),new Random(80).nextInt());
            list.add(user);
            System.out.println("-free processing:"+Runtime.getRuntime().freeMemory()/1024/1024+"M"+",i:"+i);
        }
        System.out.println("-free after:"+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        System.gc();
    }

    public static void main(String[] args) {
        System.out.println("-Xmx"+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        TestEscapeAnalysis escapeAnalysis = new TestEscapeAnalysis();
        escapeAnalysis.getUserData();
        System.out.println("-freeGC"+Runtime.getRuntime().freeMemory()/1024/1024+"M");

        //System.gc();

    }
}
