package com.workintech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address", schema = "s18d4")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    @NotNull
    private String street;

    @Column(name = "no")
    @NotNull
    private String no;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "country")
    @NotNull
    private String country;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "address")
    private Customer customer;

}
