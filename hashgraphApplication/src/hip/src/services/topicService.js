import { hederaClient } from "./client";
import {TopicMessageQuery, TopicMessageSubmitTransaction} from "@hashgraph/sdk";

const {
    TopicCreateTransaction
} = require("@hashgraph/sdk");

export async function topicCreate(){
    try{
        const client = hederaClient();
        const transactionId = await new TopicCreateTransaction().setTopicMemo("abcd").execute(client);
        const receipt=await transactionId.getReceipt(client);
        //Get the topic ID
        const newTopicId = receipt.topicId;

        console.log("The new topic ID is " + newTopicId);
        return newTopicId;
        // fetch("/api/topic/create",{method:'POST',body:transactionId.toBytes()})
        //     .then((response) => response.arrayBuffer())
        //     .then((data) => {
        //         console.log(data);
        //     });
    }
    catch (e) {
        console.log(e);
    }
}

export async function submitMessage(topicId, msg){
    try{
        const client = hederaClient();
       const txResponse = await new TopicMessageSubmitTransaction({
            topicId: topicId,
            message: msg,
        }).execute(client);
       const receipt=txResponse.getReceipt(client);
       const transactionStatus=receipt.status;
       console.log(transactionStatus);
    }
    catch (e) {
        console.log(e);
    }
}

export async function getTopicMessages(topicId){
    //Create the query
    const client = hederaClient();
    const topicMessages=new TopicMessageQuery()
        .setTopicId(topicId)
        .setStartTime(0)
        .subscribe(
            client,
            (message) => console.log(Buffer.from(message.contents, "utf8").toString())
        );
    console.log(topicMessages);
//v2.0.0
}