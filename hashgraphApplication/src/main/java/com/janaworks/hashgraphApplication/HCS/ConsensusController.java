package com.janaworks.hashgraphApplication.HCS;

import com.hedera.hashgraph.sdk.PrecheckStatusException;
import com.hedera.hashgraph.sdk.ReceiptStatusException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeoutException;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/topic")
public class ConsensusController {

    ConsensusService consensusService;
    public ConsensusController(){
        consensusService=new ConsensusService();
    }
    @PostMapping("/create")
    public String createTopic(byte[] transaction) throws ReceiptStatusException, PrecheckStatusException, TimeoutException {
        return "Hello Future";
        //return consensusService.createTopic();
    }
}
