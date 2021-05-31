package com.janaworks.hashgraphApplication.hts;

import com.hedera.hashgraph.sdk.*;
import com.hedera.hashgraph.sdk.proto.TokenCreateTransactionBody;
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
    public byte[] createToken(byte[] token){
        TokenCreateTransactionBody tx=null;
        TokenCreateTransaction transaction=null;
        try {
            //Create the transaction
             transaction= (TokenCreateTransaction) Transaction.fromBytes(token);
//            tx.toBuilder();
//            transaction=  new TokenCreateTransaction()
//                    .setTokenName(token.getName())
//                    .setTokenSymbol(token.getSymbol())
//                    .setDecimals(token.getDecimals())
//                    .setTreasuryAccountId(AccountId.fromString(token.getTreasury()))
//                    .setInitialSupply(5000);

//                    .setAutoRenewAccountId(AccountId.fromString(token.getAutoRenewAccount()))
//                    .setAdminKey(PrivateKey.fromString(token.getAdminKey()))
//                    .setMaxTransactionFee(new Hbar(30)); //Change the default max transaction fee
            //TokenCreateTransactionBody tx = TokenCreateTransactionBody.newBuilder(transaction).build();

            //Build the unsigned transaction, sign with admin private key of the token, sign with the token treasury private key, submit the transaction to a Hedera network
            //TransactionResponse txResponse = transaction.freezeWith(client).sign(PrivateKey.fromString(token.getAdminKey())).execute(client);
            //TokenCreateTransaction tx=new TokenCreateTransaction().signWithOperator().execute();

            transaction.signWithOperator(client);
            //Request the receipt of the transaction
//            TransactionReceipt receipt = txResponse.getReceipt(client);
//
//            //Get the token ID from the receipt
//            TokenId tokenId = receipt.tokenId;
//            token.setTokenId(String.valueOf(tokenId));
//            System.out.println("The new token ID is " + tokenId);
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return transaction.toBytes();
        //v2.0.1
    }
    public Token tokenInfo(Token token){
        Token tokenResponse=token;
        try {
            //Create the query
            TokenInfoQuery query = new TokenInfoQuery()
                    .setTokenId(TokenId.fromString(token.getTokenId()));

//Sign with the client operator private key, submit the query to the network and get the token supply
            long tokenSupply = query.execute(client).totalSupply;
            tokenResponse.setTotalSupply(tokenSupply);
            System.out.println("The token info is " +tokenSupply);

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return tokenResponse;
    }

//    public void tokenTransactionWithAmount(Client client,Transaction transaction,Instruction instruction,Key key){
//
//    }
}
