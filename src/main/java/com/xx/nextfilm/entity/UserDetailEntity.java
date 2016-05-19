package com.xx.nextfilm.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by CuiH on 2016/5/13.
 */
@Entity(name = "user_detail")
public class UserDetailEntity {

    private Long id;
    private String cityCode;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthday;
    private UserEntity user;


    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Basic
    @Column(name = "city_code")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }


    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userDetail")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetailEntity that = (UserDetailEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        return result;
    }
}
