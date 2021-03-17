package com.domain.type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ChangeStatus {
    private int id;
    private int status;

    public int getId() {
        return id;
    }
    @JsonDeserialize
    public int getStatus() {
        return status;
    }
}
