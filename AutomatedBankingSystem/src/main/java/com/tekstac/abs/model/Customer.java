package com.tekstac.abs.model;
import jakarta.persistence.*;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Represents the 'customers' table in the database.
 */
@Entity
@Table(name = "customers")
public class Customer {

    /**
     * The unique identifier for the customer. Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    /**
     * The full name of the customer.
     */
    @Column(name = "full_name", length = 50)
    private String fullName;

    /**
     * The unique email address of the customer.
     */
    @Column(name = "email", length = 255, unique = true)
    private String email;

    /**
     * The hashed password for customer authentication.
     */
    @Column(name = "password_hash", length = 255)
    private String passwordHash;

    /**
     * The phone number of the customer.
     */
    @Column(name = "phone", length = 20)
    private String phone;

    /**
     * The physical address of the customer.
     */
    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    /**
     * The status of the customer's profile.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CustomerStatus status;

    /**
     * The timestamp when the customer was created.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    /**
     * The timestamp when the customer was last updated.
     */
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public enum CustomerStatus {
        ACTIVE,
        INACTIVE,
        SUSPENDED
    }

    // --- Getters and Setters ---

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}