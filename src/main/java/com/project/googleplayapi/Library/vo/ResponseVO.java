package com.project.googleplayapi.Library.vo;

import java.io.Serializable;
import java.util.List;

public class ResponseVO implements Serializable {

    public ResponseVO(List<AppVO> apps, Long hits) {
        this.apps = apps;
        this.hits = hits;
    }

    private List<AppVO> apps;
    private Long hits;

    public List<AppVO> getApps() {
        return apps;
    }

    public void setApps(List<AppVO> apps) {
        this.apps = apps;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }
}
