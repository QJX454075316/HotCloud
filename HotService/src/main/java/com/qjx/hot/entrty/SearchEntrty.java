package com.qjx.hot.entrty;

import java.util.List;

public class SearchEntrty {
    private long id;
    private String title;
    private String url;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private List<RankEntrty> ranks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<RankEntrty> getRanks() {
        return ranks;
    }

    public void setRanks(List<RankEntrty> ranks) {
        this.ranks = ranks;
    }
}
