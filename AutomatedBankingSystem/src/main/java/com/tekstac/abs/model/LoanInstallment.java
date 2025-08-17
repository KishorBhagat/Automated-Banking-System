package com.tekstac.abs.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Represents the 'loan_installments' table in the database.
 */
@Entity
@Table(name = "loan_installments")
public class LoanInstallment {

    /**
     * The unique identifier for the installment. Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "installment_id")
    private Long installmentId;

    /**
     * The date when the installment is due.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private Date dueDate;

    /**
     * The amount due for this installment.
     */
    @Column(name = "amount_due", precision = 15, scale = 2)
    private BigDecimal amountDue;

    /**
     * The amount that has been paid for this installment.
     */
    @Column(name = "amount_paid", precision = 15, scale = 2)
    private BigDecimal amountPaid;

    /**
     * The date when the payment was made.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "payment_date")
    private Date paymentDate;

    /**
     * The status of the installment payment.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InstallmentStatus status;

    /**
     * The timestamp when the installment record was created.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    /**
     * The timestamp when the installment record was last updated.
     */
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * The loan to which this installment belongs.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id", referencedColumnName = "loan_id")
    private Loan loan;

    public enum InstallmentStatus {
        DUE,
        PAID,
        OVERDUE,
        PARTIALLY_PAID
    }

    // --- Getters and Setters ---

    public Long getInstallmentId() {
        return installmentId;
    }

    public void setInstallmentId(Long installmentId) {
        this.installmentId = installmentId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public InstallmentStatus getStatus() {
        return status;
    }

    public void setStatus(InstallmentStatus status) {
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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}