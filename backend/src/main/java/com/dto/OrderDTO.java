package com.dto;


import com.domain.type.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    @NotEmpty(message = "You should write name for order")
    @Size(min = 2, max = 1000, message = "Order must be between 8 and 20 characters")
    private String toyName;

    @NotEmpty(message = "You should write name for order")
    @Pattern(regexp = "^[0-9]+$")
    private int quantity;

    private Priority priority;

    private Date deadline;

    public String getToyName(){
        return toyName;
    }

    public int getQuantity(){
        return quantity;
    }

    public Priority getPriority(){
        return priority;
    }

    public Date getDeadline(){
        return deadline;
    }

}
