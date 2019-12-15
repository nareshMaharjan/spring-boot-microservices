package com.naresh.moviedataservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieSummary {
    private final String id;
    private final String title;
    private final String overview;

    @JsonCreator
    public MovieSummary(@JsonProperty("id") String id,
                        @JsonProperty("original_title") String title,
                        @JsonProperty("overview") String overview) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
