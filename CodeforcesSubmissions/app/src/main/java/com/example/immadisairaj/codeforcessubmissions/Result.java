package com.example.immadisairaj.codeforcessubmissions;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("verdict")
    private String verdict;
    @SerializedName("problem")
    private Problem problem;
    @SerializedName("programmingLanguage")
    private String programmingLanguage;
    @SerializedName("timeConsumedMillis")
    private Integer timeConsumedMillis;
    @SerializedName("memoryConsumedBytes")
    private Integer memoryConsumedBytes;

    public Result(String verdict, Problem problem, String programmingLanguage, int timeConsumedMillis, int memoryConsumedBytes) {
        this.verdict = verdict;
        this.problem = problem;
        this.programmingLanguage = programmingLanguage;
        this.timeConsumedMillis = timeConsumedMillis;
        this.memoryConsumedBytes = memoryConsumedBytes;
    }

    public String getVerdict() {
        return verdict;
    }

    public Problem getProblem() {
        return problem;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public Integer getTimeConsumedMillis() {
        return timeConsumedMillis;
    }

    public Integer getMemoryConsumedBytes() {
        return memoryConsumedBytes;
    }
}
