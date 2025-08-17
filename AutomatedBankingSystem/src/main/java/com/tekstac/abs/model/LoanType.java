package com.tekstac.abs.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Represents the 'loan_types' table in the database.
 */
@Entity
@Table(name = "loan_types")
public class LoanType {

    /**
     * The unique identifier for the loan type. Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_type_id")
    private Long loanTypeId;

    /**
     * The name of the loan type (e.g., Personal Loan).
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * A detailed description of the loan type.
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    /**
     * The standard interest rate for this loan type.
     */
    @Column(name = "interest_rate", precision = 5, scale = 2)
    private BigDecimal interestRate;

    /**
     * The minimum amount that can be borrowed for this loan type.
     */
    @Column(name = "min_amount", precision = 15, scale = 2)
    private BigDecimal minAmount;

    /**
     * The maximum amount that can be borrowed for this loan type.
     */
    @Column(name = "max_amount", precision = 15, scale = 2)
    private BigDecimal maxAmount;

    /**
     * The timestamp when the loan type was created.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    /**
     * The timestamp when the loan type was last updated.
     */
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    // --- Getters and Setters ---

    public Long getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(Long loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
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