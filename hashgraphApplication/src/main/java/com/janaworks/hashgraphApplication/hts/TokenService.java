package com.janaworks.hashgraphApplication.hts;

import com.hedera.hashgraph.sdk.*;
import com.janaworks.hashgraphApplication.hts.tknModel.Token;
import com.janaworks.hashgraphApplication.utils.HederaClient;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public Client client = HederaClient.getHederaClientInstance();
    /*
    *Implementation of the hedera token service
    *@param
     */
    public Token createToken(Token token){
        try {
            //Create the transaction
            TokenCreateTransaction transaction = new TokenCreateTransaction()
                    .setTokenName(token.getTokenName())
                    .setTokenSymbol(token.getTokenSymbol())
                    .setTreasuryAccountId(token.getTreasuryAccountId())
                    .setInitialSupply(5000)
                    .setAdminKey(token.getAdminKey())
                    .setMaxTransactionFee(new Hbar(30)); //Change the default max transaction fee

            //Build the unsigned transaction, sign with admin private key of the token, sign with the token treasury private key, submit the transaction to a Hedera network
            TransactionResponse txResponse = transaction.freezeWith(client).sign((PrivateKey) token.getAdminKey()).sign((PrivateKey) token.getAdminKey()).execute(client);

            //Request the receipt of the transaction
            TransactionReceipt receipt = txResponse.getReceipt(client);

            //Get the token ID from the receipt
            TokenId tokenId = receipt.tokenId;
            token.setTokenId(tokenId);
            System.out.println("The new token ID is " + tokenId);
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return token;
        //v2.0.1
    }
}
