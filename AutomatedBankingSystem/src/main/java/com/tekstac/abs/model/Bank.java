package com.tekstac.abs.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "banks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Long bankId;

    @Column(name = "bank_name", length = 100, nullable = false)
    private String bankName;

    @Column(name = "ifsc_code", length = 11, unique = true, nullable = false)
    private String ifscCode;

    @Column(name = "branch", length = 100)
    private String branch;

    @Column(name = "address")
    private String address;
}
