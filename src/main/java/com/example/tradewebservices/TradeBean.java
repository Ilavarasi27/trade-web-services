package com.example.tradewebservices;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class TradeBean {

    @Id
    @GeneratedValue
    private Long id;

    private String tradeId;

    @Version
    private int version;
    private String counterPartyId;
    private String bookId;
    private Date maturityDate;
    private Date createdDate;
    private char expiry;

    protected TradeBean(){

    }

    public TradeBean(Long id, String tradeId, int version, String counterPartyId, String bookId, Date maturityDate, Date createdDate, char expiry) {
        this.id = id;
        this.tradeId = tradeId;
        this.version = version;
        this.counterPartyId = counterPartyId;
        this.bookId = bookId;
        this.maturityDate = maturityDate;
        this.createdDate = createdDate;
        this.expiry = expiry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setCounterPartyId(String counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setExpiry(char expiry) {
        this.expiry = expiry;
    }

    public String getTradeId() {
        return tradeId;
    }

    public int getVersion() {
        return version;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    public String getBookId() {
        return bookId;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public char getExpiry() {
        return expiry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TradeBean)) return false;
        TradeBean tradeBean = (TradeBean) o;
        return getId() == tradeBean.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TradeBean{" +
                " id='" + id + '\'' +
                ", tradeId='" + tradeId + '\'' +
                ", version=" + version +
                ", counterPartyId='" + counterPartyId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", maturityDate=" + maturityDate +
                ", createdDate=" + createdDate +
                ", expiry=" + expiry +
                '}';
    }



}
