package main.java;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/12 09:46
 * @Description:
 */
public class TestStackDeep {

    private static int count = 0;

    public static void recursion(long a,long b,long c){
        long e=1,f=2,g=3,h=4,i=5,j=6,k=7,l=8,m=9,n=10;
        count++;
        recursion(a, b, c);
    }

    public static void recursion(){
        count++;
        recursion();
    }

    public static void main(String[] args) {
        System.out.println("-Xmx"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
        try {
            //recursion(0L,0L,0L);
            recursion();
        } catch (Throwable e) {
            System.out.println("deep of calling="+count);
            e.printStackTrace();
        }
    }
}
