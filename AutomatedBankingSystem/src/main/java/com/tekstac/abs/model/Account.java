package com.tekstac.abs.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


/**
 * Represents the 'accounts' table in the database.
 * Each instance of this class corresponds to a single row in the table.
 */
@Entity
@Table(name = "accounts")
public class Account {

    /**
     * The unique identifier for the account.
     * This is the primary key and is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    /**
     * The ID of the customer who owns the account.
     */
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    /**
     * The unique account number.
     * Mapped to the 'account_number' column with a max length of 20.
     */
    @Column(name = "account_number", length = 20, unique = true, nullable = false)
    private String accountNumber;

    /**
     * The type of the account (e.g., SAVINGS, CHECKING).
     * Stored as a string in the database.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    /**
     * The initial balance when the account was opened.
     * Using BigDecimal for precise financial calculations.
     */
    @Column(name = "opening_balance", precision = 15, scale = 2)
    private BigDecimal openingBalance;

    /**
     * The current cached balance of the account.
     * Using BigDecimal for precision.
     */
    @Column(name = "cached_balance", precision = 15, scale = 2)
    private BigDecimal cachedBalance;

    /**
     * The status of the account (e.g., ACTIVE, INACTIVE, CLOSED).
     * Stored as a string in the database.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AccountStatus status;

    /**
     * The timestamp when the account was created.
     * Automatically set by Hibernate upon creation.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    /**
     * The timestamp when the account was last updated.
     * Automatically set by Hibernate upon update.
     */
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * Establishes a many-to-one relationship with the Bank entity.
     * An account belongs to one bank, but a bank can have many accounts.
     * The 'bank_id' column in the 'accounts' table is the foreign key.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", referencedColumnName = "bank_id")
    private Bank bank;

    // --- Enums for AccountType and AccountStatus ---

    public enum AccountType {
        SAVINGS,
        CHECKING,
        LOAN
    }

    public enum AccountStatus {
        ACTIVE,
        INACTIVE,
        CLOSED
    }

    // --- Getters and Setters ---

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBalance) {
        this.openingBalance = openingBalance;
    }

    public BigDecimal getCachedBalance() {
        return cachedBalance;
    }

    public void setCachedBalance(BigDecimal cachedBalance) {
        this.cachedBalance = cachedBalance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}

