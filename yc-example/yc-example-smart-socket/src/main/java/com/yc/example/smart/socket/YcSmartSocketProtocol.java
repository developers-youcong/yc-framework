package com.yc.example.smart.socket;

import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;

/**
 * @description:
 * @author: youcong
 */
public class YcSmartSocketProtocol implements Protocol<String> {
    @Override
    public String decode(ByteBuffer readBuffer, AioSession session) {
        int remaining = readBuffer.remaining();
        if (remaining < Integer.BYTES) {
            return null;
        }
        readBuffer.mark();
        int length = readBuffer.getInt();
        if (length > readBuffer.remaining()) {
            readBuffer.reset();
            return null;
        }
        byte[] b = new byte[length];
        readBuffer.get(b);
        readBuffer.mark();
        return new String(b);
    }
}
