package com.zzj.muxin.db;


import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "zzj_user")
public class User extends BaseEntity{

    @Expose
    @Column
    private String name;
    @Expose
    @Column
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
