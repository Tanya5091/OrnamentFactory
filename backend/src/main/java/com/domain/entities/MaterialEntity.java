package com.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "materialstable")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    public int getQuantity(){
        return quantity;
    }
}
