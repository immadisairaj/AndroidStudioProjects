package com.example.immadisairaj.codeforcessubmissions.Api.Submission;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Problem {

    @SerializedName("contestId")
    private Integer contestId;
    @SerializedName("index")
    private String index;
    @SerializedName("name")
    private String name;
    @SerializedName("tags")
    private List<String> tags;

    public Problem(Integer contestId, String index, String name, List<String> tags) {
        this.contestId = contestId;
        this.index = index;
        this.name = name;
        this.tags = tags;
    }

    public Integer getContestId() {
        return contestId;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public List<String> getTags() {
        return tags;
    }
}
