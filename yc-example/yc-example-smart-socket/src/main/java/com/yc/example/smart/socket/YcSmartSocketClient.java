package com.yc.example.smart.socket;

import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.transport.AioQuickClient;
import org.smartboot.socket.transport.AioSession;
import org.smartboot.socket.transport.WriteBuffer;

import java.io.IOException;

/**
 * @description:
 * @author: youcong
 */
public class YcSmartSocketClient {

    public static void main(String[] args) throws IOException {
        MessageProcessor<String> processor = new MessageProcessor<String>() {
            @Override
            public void process(AioSession session, String msg) {
                System.out.println("receive from server: " + msg);
            }
        };
        AioQuickClient client = new AioQuickClient("localhost", 8888, new YcSmartSocketProtocol(), processor);
        AioSession session = client.start();
        WriteBuffer writeBuffer = session.writeBuffer();
        byte[] data = "hello smart-socket".getBytes();
        writeBuffer.writeInt(data.length);
        writeBuffer.write(data);
        writeBuffer.flush();
    }
}
