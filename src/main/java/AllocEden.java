package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/16 15:32
 * @Description: TODO
 */
public class AllocEden {

    private static final int _1M=1024*1024;
    private static final int _1k=1024;

    public static void main(String[] args) {
        Map<Integer,byte[]> map = new HashMap<>();
        for (int i = 0; i < 5*_1k; i++) {
            byte[] bytes = new byte[_1k];
            map.put(i,bytes);
        }


        for (int k = 0; k < 17; k++) {
            for (int i = 0; i < 300; i++) {
                byte[] bytes = new byte[_1M];
            }
        }
    }
}
