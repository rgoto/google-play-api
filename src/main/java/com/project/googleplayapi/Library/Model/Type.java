package com.project.googleplayapi.Library.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Type {

    public Type() {
    }

    public Type(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "type",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<App> apps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }
}


