package com.xx.nextfilm.entity;

import javax.persistence.*;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于级联删除
 */
@Entity(name = "film_actor_map")
public class FAMEntity {

    private Long id;

    private ActorEntity actor;


    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actor_id")
    public ActorEntity getActor() {
        return actor;
    }

    public void setActor(ActorEntity actor) {
        this.actor = actor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FAMEntity famEntity = (FAMEntity) o;

        if (id != famEntity.id) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
