package com.janaworks.hashgraphApplication.hts;

import com.janaworks.hashgraphApplication.hts.tknModel.Token;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/token")
public class TokenController {
    //Token token;
    TokenService tokenService;
    public TokenController(){
        //token=new Token();
        tokenService=new TokenService();
    }

    @PostMapping("/create")
    public byte[] createToken(@RequestBody byte[] token){
//        token.setTokenName(tokenName);
//        token.setTokenSymbol(tokenSymbol);
//        token.setTreasuryAccountId(treasuryAccountId);
//        token.setAdminKey(adminKey);
//        String tokenName, String tokenSymbol, AccountId treasuryAccountId, Key adminKey
        return tokenService.createToken(token);
    }

    @PostMapping("/getInfo")
    public Token tokenInfo(@RequestBody Token token){
        return tokenService.tokenInfo(token);
    }
}
