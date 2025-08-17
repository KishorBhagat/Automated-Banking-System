package com.tekstac.abs.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Represents the 'ledger_entries' table. Each transaction will have
 * corresponding debit/credit entries in this table.
 */
@Entity
@Table(name = "ledger_entries")
public class LedgerEntry {

    /**
     * The unique identifier for the ledger entry. Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private Long entryId;

    /**
     * The type of entry (DEBIT or CREDIT).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "entry_type")
    private EntryType entryType;

    /**
     * The amount for this entry.
     */
    @Column(name = "amount", precision = 15, scale = 2)
    private BigDecimal amount;

    /**
     * Optional remarks for this specific ledger entry.
     */
    @Column(name = "remarks", length = 255)
    private String remarks;

    /**
     * The timestamp when the ledger entry was created.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    /**
     * The transaction to which this ledger entry belongs.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id")
    private Transaction transaction;

    /**
     * The account affected by this ledger entry.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;

    public enum EntryType {
        DEBIT,
        CREDIT
    }

    // --- Getters and Setters ---

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}