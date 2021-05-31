package com.janaworks.hashgraphApplication.hts.tknModel;

import java.io.Serializable;
import java.time.Instant;

public class Token implements Serializable {
    private String autoRenewAccount;

    private int decimals;
    private String name;
    private String symbol;
    private String treasury;
    private String adminKey;
    private String kycKey;
    private String freezeKey;
    private String wipeKey;
    private String supplyKey;
    private boolean defaultFreezeStatus;
    private String key;
    private Instant ExpirationTime;
    private String TokenMemo;
    private String tokenId;
    private long totalSupply;

    public String getAutoRenewAccount() {
        return autoRenewAccount;
    }

    public void setAutoRenewAccount(String autoRenewAccount) {
        this.autoRenewAccount = autoRenewAccount;
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTreasury() {
        return treasury;
    }

    public void setTreasury(String treasury) {
        this.treasury = treasury;
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }

    public String getKycKey() {
        return kycKey;
    }

    public void setKycKey(String kycKey) {
        this.kycKey = kycKey;
    }

    public String getFreezeKey() {
        return freezeKey;
    }

    public void setFreezeKey(String freezeKey) {
        this.freezeKey = freezeKey;
    }

    public String getWipeKey() {
        return wipeKey;
    }

    public void setWipeKey(String wipeKey) {
        this.wipeKey = wipeKey;
    }

    public String getSupplyKey() {
        return supplyKey;
    }

    public void setSupplyKey(String supplyKey) {
        this.supplyKey = supplyKey;
    }

    public boolean isDefaultFreezeStatus() {
        return defaultFreezeStatus;
    }

    public void setDefaultFreezeStatus(boolean defaultFreezeStatus) {
        this.defaultFreezeStatus = defaultFreezeStatus;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Instant getExpirationTime() {
        return ExpirationTime;
    }

    public void setExpirationTime(Instant expirationTime) {
        ExpirationTime = expirationTime;
    }

    public String getTokenMemo() {
        return TokenMemo;
    }

    public void setTokenMemo(String tokenMemo) {
        TokenMemo = tokenMemo;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public long getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(long totalSupply) {
        this.totalSupply = totalSupply;
    }

    @Override
    public String toString() {
        return "Token{" +
                "autoRenewAccount='" + autoRenewAccount + '\'' +
                ", decimals=" + decimals +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", treasury='" + treasury + '\'' +
                ", adminKey='" + adminKey + '\'' +
                ", kycKey='" + kycKey + '\'' +
                ", freezeKey='" + freezeKey + '\'' +
                ", wipeKey='" + wipeKey + '\'' +
                ", supplyKey='" + supplyKey + '\'' +
                ", defaultFreezeStatus=" + defaultFreezeStatus +
                ", key='" + key + '\'' +
                ", ExpirationTime=" + ExpirationTime +
                ", TokenMemo='" + TokenMemo + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", totalSupply=" + totalSupply +
                '}';
    }
}
