package chapter08;

import java.io.Serializable;

public class User implements Serializable {

    //定义一个类的版本号【固定写法】
    //传输双方的版本号必须一致，如果不一致，反序列化会失败
    //传输双方还需要保证类名一致(如：chapter08.User)，否则反序列化也会失败
    //后面这个数字正负或小数均可
        private static final long serialVersionUID=-1;

    //用Java类分装多个字段
        private String name;
        private String gender;
        private transient String school;
        private String subject;
        private Integer age;
    //生成+无选择
    public User() {
    }
    //生成+ctrl进行多选
    public User(String name, String gender, String subject, String school, Integer age) {
        this.name = name;
        this.gender = gender;
        this.subject = subject;
        this.school = school;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}