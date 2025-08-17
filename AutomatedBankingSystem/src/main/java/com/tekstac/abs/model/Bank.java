package com.tekstac.abs.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * Represents the 'banks' table in the database.
 * Each instance of this class corresponds to a single row in the table.
 */
@Entity
@Table(name = "banks")
public class Bank {

    /**
     * The unique identifier for the bank.
     * This is the primary key and is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Long bankId;

    /**
     * The name of the bank.
     * Mapped to the 'bank_name' column with a max length of 100.
     */
    @Column(name = "bank_name", length = 100)
    private String bankName;

    /**
     * The IFSC code of the bank branch.
     * Mapped to the 'ifsc_code' column with a fixed length of 11.
     */
    @Column(name = "ifsc_code", length = 11)
    private String ifscCode;

    /**
     * The specific branch name of the bank.
     * Mapped to the 'branch' column with a max length of 100.
     */
    @Column(name = "branch", length = 100)
    private String branch;

    /**
     * The physical address of the bank branch.
     * Mapped to the 'address' column, which is of type TEXT for longer strings.
     */

    @Column(name = "address")
    private String address;

    // --- Getters and Setters ---

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
