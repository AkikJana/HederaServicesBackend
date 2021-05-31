package com.janaworks.hashgraphApplication.HCS;

import com.hedera.hashgraph.sdk.*;
import com.janaworks.hashgraphApplication.utils.HederaClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class ConsensusService {
    public Client client = HederaClient.getHederaClientInstance();

    public byte[] createTopic() throws PrecheckStatusException, TimeoutException, ReceiptStatusException {
        //Create the transaction
//        TopicCreateTransaction transaction = new TopicCreateTransaction()
//                .setTopicMemo("HCS topic with submit key")
//                .setSubmitKey(submitPublicKey);



////Sign with the client operator private key and submit the transaction to a Hedera network
//        TransactionResponse txResponse = transaction.execute(client);
//
////Request the receipt of the transaction
//        TransactionReceipt receipt = txResponse.getReceipt(client);
//
////Get the topic ID
//        TopicId newTopicId = receipt.topicId;
//
//        System.out.println("The new topic ID is " + newTopicId);

//v2.0.0
        //return receipt.toBytes();

        return new byte[0];
    }
}
