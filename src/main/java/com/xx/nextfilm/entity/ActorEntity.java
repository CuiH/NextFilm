package com.xx.nextfilm.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
@Entity(name = "actor")
public class ActorEntity {

    private Long id;
    private String name;
    private String imageUrl;
    private String brief;
    private Date birthday;

    private List<FDMEntity> fdms;         // 用于级联删除
    private List<FAMEntity> fams;         // 用于级联删除


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }


    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "director", cascade = CascadeType.REMOVE)
    public List<FDMEntity> getFdms() {
        return fdms;
    }

    public void setFdms(List<FDMEntity> fdms) {
        this.fdms = fdms;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actor", cascade = CascadeType.REMOVE)
    public List<FAMEntity> getFams() {
        return fams;
    }

    public void setFams(List<FAMEntity> fams) {
        this.fams = fams;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorEntity that = (ActorEntity) o;

        if (id != that.id) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        return result;
    }

}
