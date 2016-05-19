package com.xx.nextfilm.entity;

import javax.persistence.*;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于级联删除
 */
@Entity(name = "film_director_map")
public class FDMEntity {

    private Long id;

    private ActorEntity director;


    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "director_id")
    public ActorEntity getDirector() {
        return director;
    }

    public void setDirector(ActorEntity director) {
        this.director = director;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FDMEntity fdmEntity = (FDMEntity) o;

        if (id != fdmEntity.id) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
