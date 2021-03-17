package com.dto;


import com.domain.type.OrderStatus;
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

    private Integer id;

    @NotEmpty(message = "You should write name for order")
    @Size(min = 2, max = 1000, message = "Order must be between 8 and 20 characters")
    private String toyName;

    @NotEmpty(message = "You should write name for order")
    @Pattern(regexp = "^[0-9]+$")
    private int quantity;

    private Priority priority;

    private Date deadline;

    private String status;

    public OrderDTO(String toyName, int quantity, Priority priority, Date deadline, String status, int id) {
        this.deadline = deadline;
        this.priority = priority;
        this.quantity = quantity;
        this.toyName = toyName;
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }


    public String getToyName() {
        return toyName;
    }

    public String getStatus() {
        return status;
    }

    public int getQuantity() {
        return quantity;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getDeadline() {
        return deadline;
    }

}
