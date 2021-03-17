package com.domain.type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ChangePriority {
    private int id;
    private String priority;

    public int getId() {
        return id;
    }
    @JsonDeserialize
    public String getPriority() {
        return priority;
    }
}
