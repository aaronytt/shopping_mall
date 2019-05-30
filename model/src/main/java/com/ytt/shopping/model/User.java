package com.ytt.shopping.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Data
public class User implements Serializable {

    private Long id;

    private String username;

    private String password;

    @Min(value = 18, message = "未满18岁禁止入内")
    private int age;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//        User rUser = (User) o;
//        return Objects.equals(getUsername(), rUser.getUsername()) &&
//                Objects.equals(getPassword(), rUser.getPassword()) &&
//                Objects.equals(getAge(),rUser.getAge());
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(getUsername(), getPassword(), getAge());
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", age='" + age + '\'' +
//                '}';
//    }
}
