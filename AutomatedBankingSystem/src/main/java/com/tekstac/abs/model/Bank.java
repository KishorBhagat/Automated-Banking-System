package com.tekstac.abs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotEmpty
    @Column(name = "bank_name", length = 100, nullable = false)
    private String bankName;

    @NotEmpty
    @Size(min = 11, max = 11, message = "IFSC must be exactly 11 characters long")
    @Pattern(regexp = "^[A-Z]{4}0[0-9]{6}$", message = "Invalid IFSC format")
    @Column(name = "ifsc_code", length = 11, unique = true, nullable = false)
    private String ifscCode;

    @NotEmpty
    @Column(name = "branch", length = 100)
    private String branch;

    @NotEmpty
    @Column(name = "address")
    private String address;
}
