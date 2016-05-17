package com.xx.nextfilm.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
@Entity(name = "film")
public class FilmEntity {

    private Long id;
    private String name;
    private String alias;
    private String brief;
    private String language;
    private String length;
    private Date onDate;
    private String imageUrl;
    private String category;
    private String type;

    private List<ActorEntity> directors = new ArrayList<ActorEntity>();
    private List<ActorEntity> actors = new ArrayList<ActorEntity>();


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
    @Column(name = "alias")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    @Basic
    @Column(name = "length")
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }


    @Basic
    @Column(name = "on_date")
    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
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
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_actor_map",
            joinColumns = { @JoinColumn(name = "film_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
    public List<ActorEntity> getActors() {
        return actors;
    }

    public void setActors(List<ActorEntity> actors) {
        this.actors = actors;
    }


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_director_map",
            joinColumns = { @JoinColumn(name = "film_id") },
            inverseJoinColumns = { @JoinColumn(name = "director_id") })
    public List<ActorEntity> getDirectors() {
        return directors;
    }

    public void setDirectors(List<ActorEntity> directors) {
        this.directors = directors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmEntity that = (FilmEntity) o;

        if (id != that.id) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        return result;
    }

}
