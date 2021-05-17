package com.janaworks.hashgraphApplication.hts;

import com.hedera.hashgraph.sdk.AccountId;
import com.hedera.hashgraph.sdk.Key;
import com.janaworks.hashgraphApplication.hts.tknModel.Token;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    Token token;
    TokenService tokenService;
    public TokenController(){
        token=new Token();
        tokenService=new TokenService();
    }

    @PostMapping("")
    public Token createToken(@RequestParam String tokenName, String tokenSymbol, AccountId treasuryAccountId, Key adminKey){
        token.setTokenName(tokenName);
        token.setTokenSymbol(tokenSymbol);
        token.setTreasuryAccountId(treasuryAccountId);
        token.setAdminKey(adminKey);

        return tokenService.createToken(token);
    }

}
