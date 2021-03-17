package com.domain.type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ChangeStatus {
    private int id;
    private String status;

    public int getId() {
        return id;
    }
    @JsonDeserialize
    public String getStatus() {
        return status;
    }
}
