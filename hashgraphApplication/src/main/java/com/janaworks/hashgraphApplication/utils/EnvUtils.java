package com.janaworks.hashgraphApplication.utils;

import com.hedera.hashgraph.sdk.AccountId;
import com.hedera.hashgraph.sdk.PrivateKey;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Objects;

public class EnvUtils {
    static Dotenv getEnv() {
       return Dotenv.configure().directory("E:\\hashgraphApplication\\hashgraphApplication").load();

        //return Dotenv.load();
    }

    public static Hedera_Environment getHederaEnvironment() {
        String _env = Objects.requireNonNull(getEnv().get("HEDERA_ENVIRONMENT"));
        return Hedera_Environment.valueOf(_env);
    }

    public static String getMirrorNodeAddress() {
        return Objects.requireNonNull(getEnv().get("MIRROR_NODE_ADDRESS"));
    }

    public static AccountId getOperatorId() {
        return AccountId.fromString(Objects.requireNonNull(getEnv().get("OPERATOR_ID")));
    }

    public static PrivateKey getOperatorKey() {
        return PrivateKey.fromString(Objects.requireNonNull(getEnv().get("OPERATOR_KEY")));
    }

    public enum Hedera_Environment {
        TESTNET,
        MAINNET
    }
}
