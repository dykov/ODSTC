package com.netcracker.tc.server.persistence.model.user;

import java.io.Serializable;

/**
 * Created by unconsionable on 28.07.2014.
 */
public class Role implements Serializable {

    private Long id;
    private String description;

    public Role(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Role(String description) {
        this.description = description;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}