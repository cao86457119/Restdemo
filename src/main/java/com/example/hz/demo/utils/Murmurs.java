package com.example.hz.demo.utils;

//import com.sun.java.util.jar.pack.Instruction;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;

public class Murmurs {
  
    /** 
     * murmur hash算法实现 
     */  
    public static Long hash(byte[] key) {  
  
        ByteBuffer buf = ByteBuffer.wrap(key);
        int seed = 0x1234ABCD;  
  
        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);  
  
        long m = 0xc6a4a7935bd1e995L;  
        int r = 47;
        long h = seed ^ (buf.remaining() * m);
        Arrays.sort(new int[]{1, 2, 3, 4, 5});
        long k;
        String a ="+";

        while (buf.remaining() >= 8) {  
            k = buf.getLong();  
  
            k *= m;  
            k ^= k >>> r;  
            k *= m;  
  
            h ^= k;  
            h *= m;  
        }  
  
        if (buf.remaining() > 0) {  
            ByteBuffer finish = ByteBuffer.allocate(8).order(  
                    ByteOrder.LITTLE_ENDIAN);  
            // for big-endian version, do this first:  
            // finish.position(8-buf.remaining());  
            finish.put(buf).rewind();  
            h ^= finish.getLong();  
            h *= m;  
        }  
  
        h ^= h >>> r;  
        h *= m;  
        h ^= h >>> r;  
  
        buf.order(byteOrder);  
        return h;  
    }  
  
    public static Long hash(String key) {  
        return hash(key.getBytes());  
    }  
  
  
  
    /** 
     * Long转换成无符号长整型（C中数据类型） 
     */  
    public static BigDecimal readUnsignedLong(long value) {
        if (value >= 0)  
            return new BigDecimal(value);  
        long lowValue = value & 0x7fffffffffffffffL;  
        return BigDecimal.valueOf(lowValue).add(BigDecimal.valueOf(Long.MAX_VALUE)).add(BigDecimal.valueOf(1));  
    }  
  
    /** 
     * 返回无符号murmur hash值 
     */  
    public static BigDecimal hashUnsigned(String key) {  
        return readUnsignedLong(hash(key));  
    }  
    public static BigDecimal hashUnsigned(byte[] key) {  
        return readUnsignedLong(hash(key));  
    }  
}  