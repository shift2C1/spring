package com.pipichao.spring.core.data_buffer_and_codecs;

import org.springframework.core.codec.Decoder;
import org.springframework.core.codec.Encoder;
import org.springframework.core.io.buffer.*;

public class Test {
    public static void main(String[] args) {
        DataBufferFactory dataBufferFactory=new DefaultDataBufferFactory();
        DataBuffer dataBuffer=new DataBufferWrapper(null);
        PooledDataBuffer pooledDataBuffer;
//        DataBufferUtils.*;
        Encoder<String> encoder;
        Decoder<String> decoder;
        DataBuffer dataBuffer1=dataBufferFactory.allocateBuffer();
        DataBufferUtils.release(dataBuffer1);
    }
}
