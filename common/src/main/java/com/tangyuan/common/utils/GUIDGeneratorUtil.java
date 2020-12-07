package com.tangyuan.common.utils;

import java.math.BigInteger;
import java.util.UUID;

/**
 * Created by tangyuan
 * on 2019/11/14 10:41
 */
public class GUIDGeneratorUtil {

    private GUIDGeneratorUtil(){}


    public static String javaGUID() {
        UUID uuid = UUID.randomUUID();
        long lsb = uuid.getLeastSignificantBits();
        byte bytes[] = new byte[16];
        populateBytes(bytes, 15, lsb);
        long msb = uuid.getMostSignificantBits();
        populateBytes(bytes, 7, msb);

        BigInteger bi = new BigInteger(1, bytes);

        return bi.toString(36).toUpperCase();
    }

    /**
     * Private method to copy bytes in the reverse endian way.
     */
    private static void populateBytes(byte [] bytes, int startIdx, long lbytes){
        int endIdx = startIdx - 8;
        for (int i = startIdx; i > endIdx; i--) {
            bytes[i] = (byte) (lbytes & 0xFF);
            lbytes = lbytes >> 8;
        }
    }
}
