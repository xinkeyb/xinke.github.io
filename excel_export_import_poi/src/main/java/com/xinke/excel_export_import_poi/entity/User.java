package com.xinke.excel_export_import_poi.entity;

/**
 * @program: excele_eport_import
 * @description: 导出模板
 * @author: zhaoxinke
 * @create: 2019-08-15 20:47
 * @version: 1.0
 * @update: [1][2019-08-15] [zhaoxinke][新建]
 **/
public class User {
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", motto='" + motto + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public User(String name, Integer age, String gender, String motto) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.motto = motto;
    }

    public User() {
    }

    /** 姓名 */
    private String name;
    /** 年龄 */
    private Integer age;
    /** 性别 */
    private String gender;
    /** 座右铭 */
    private String motto;


}
