package main.java.model;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/12 11:29
 * @Description:
 */
public class User {

    private Long id;

    private String userName;

    private Integer age;


    public User(Long id, String userName, Integer age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
}
