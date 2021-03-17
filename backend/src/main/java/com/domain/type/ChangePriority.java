package com.domain.type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ChangePriority {
    private int id;
    private int priority;

    public int getId() {
        return id;
    }
    @JsonDeserialize
    public int getPriority() {
        return priority;
    }
}
