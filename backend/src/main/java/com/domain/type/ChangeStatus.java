package com.domain.type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ChangeStatus {
    private String name;
    private int status;

    public String getName() {
        return name;
    }
    @JsonDeserialize
    public int getStatus() {
        return status;
    }
}
