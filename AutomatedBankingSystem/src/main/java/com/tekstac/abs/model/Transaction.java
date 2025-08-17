package com.tekstac.abs.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Represents the 'transactions' table in the database.
 */
@Entity
@Table(name = "transactions")
public class Transaction {

    /**
     * The unique identifier for the transaction. Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    /**
     * The type of the transaction (e.g., TRANSFER, DEPOSIT).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    /**
     * The amount of money involved in the transaction.
     */
    @Column(name = "amount", precision = 15, scale = 2)
    private BigDecimal amount;

    /**
     * Optional remarks or notes for the transaction.
     */
    @Column(name = "remarks", length = 255)
    private String remarks;

    /**
     * The status of the transaction.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TransactionStatus status;

    /**
     * The timestamp when the transaction was created.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    /**
     * The account from which money is being debited. Can be null for deposits.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account_id", referencedColumnName = "account_id")
    private Account fromAccount;

    /**
     * The account to which money is being credited. Can be null for withdrawals.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_account_id", referencedColumnName = "account_id")
    private Account toAccount;

    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER,
        LOAN_DISBURSAL,
        LOAN_REPAYMENT
    }

    public enum TransactionStatus {
        PENDING,
        COMPLETED,
        FAILED,
        CANCELLED
    }

    // --- Getters and Setters ---

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }
}