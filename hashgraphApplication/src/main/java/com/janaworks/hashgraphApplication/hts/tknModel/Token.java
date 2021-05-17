package com.janaworks.hashgraphApplication.hts.tknModel;

import com.hedera.hashgraph.sdk.AccountId;
import com.hedera.hashgraph.sdk.Key;
import com.hedera.hashgraph.sdk.TokenId;

import java.io.Serializable;
import java.time.Instant;

public class Token implements Serializable {
    private String tokenName;
    private String tokenSymbol;
    private AccountId TreasuryAccountId;
    private Key AdminKey;
    private Key KycKey;
    private Key FreezeKey;
    private Key WipeKey;
    private Key SupplyKey;
    private boolean FreezeDefault;
    private Instant ExpirationTime;
    private String TokenMemo;
    private TokenId tokenId;

    public TokenId getTokenId() {
        return tokenId;
    }

    public void setTokenId(TokenId tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenSymbol() {
        return tokenSymbol;
    }

    public void setTokenSymbol(String tokenSymbol) {
        this.tokenSymbol = tokenSymbol;
    }

    public AccountId getTreasuryAccountId() {
        return TreasuryAccountId;
    }

    public void setTreasuryAccountId(AccountId treasuryAccountId) {
        TreasuryAccountId = treasuryAccountId;
    }

    public Key getAdminKey() {
        return AdminKey;
    }

    public void setAdminKey(Key adminKey) {
        AdminKey = adminKey;
    }

    public Key getKycKey() {
        return KycKey;
    }

    public void setKycKey(Key kycKey) {
        KycKey = kycKey;
    }

    public Key getFreezeKey() {
        return FreezeKey;
    }

    public void setFreezeKey(Key freezeKey) {
        FreezeKey = freezeKey;
    }

    public Key getWipeKey() {
        return WipeKey;
    }

    public void setWipeKey(Key wipeKey) {
        WipeKey = wipeKey;
    }

    public Key getSupplyKey() {
        return SupplyKey;
    }

    public void setSupplyKey(Key supplyKey) {
        SupplyKey = supplyKey;
    }

    public boolean isFreezeDefault() {
        return FreezeDefault;
    }

    public void setFreezeDefault(boolean freezeDefault) {
        FreezeDefault = freezeDefault;
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
//private AccountId AutoRenewAccountId;
}
