package com.domain.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderStatus {
    ACTIVE, DONE
}
