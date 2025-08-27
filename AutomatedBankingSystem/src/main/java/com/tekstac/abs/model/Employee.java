package com.tekstac.abs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @NotEmpty
    @Column(name = "employee_number", unique = true, length = 20, nullable = false)
    private String employeeNumber;

    @NotEmpty
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    @NotEmpty
    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @NotEmpty
    @Column(name = "phone", length = 20)
    private String phone;

    @NotEmpty
    @Column(name = "address", columnDefinition = "CLOB")
    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "role", nullable = false)
    private Role role = Role.OFFICER;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EmployeeStatus status = EmployeeStatus.ACTIVE;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public enum Role {
        OFFICER, ADMIN, MANAGER
    }

    public enum EmployeeStatus {
        ACTIVE, INACTIVE, SUSPENDED
    }
}
