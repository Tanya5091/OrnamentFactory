package com.domain.type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ChangePriority {
    private String name;
    private int priority;

    public String getName() {
        return name;
    }
    @JsonDeserialize
    public int getPriority() {
        return priority;
    }
}
