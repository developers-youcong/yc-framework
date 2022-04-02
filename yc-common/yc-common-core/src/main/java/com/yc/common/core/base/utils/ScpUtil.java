package com.yc.common.core.base.utils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;

import java.io.IOException;
import java.net.InetAddress;


/**
 * @description: SCP操作
 * @author: youcong
 */
public class ScpUtil {
    /**
     * 从本地上传至服务器
     *
     * @param userName
     * @param password
     * @param ipAddr
     * @param loadFilePath
     * @param serverPath
     * @return
     */
    public static boolean localToServer(String userName, String password, String ipAddr, String loadFilePath, String serverPath) {
        boolean isAuthed = false;
        try {
            if (InetAddress.getByName(ipAddr).isReachable(1500)) {
                Connection conn = new Connection(ipAddr);
                conn.connect();
                isAuthed = conn.authenticateWithPassword(userName, password);
                if (isAuthed) {
                    SCPClient scpClient = conn.createSCPClient();
                    scpClient.put(loadFilePath, serverPath);
                    conn.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isAuthed;
    }

    /**
     * 从服务器拉取文件到本地
     *
     * @param userName
     * @param password
     * @param ipAddr
     * @param serverPath
     * @param localPath
     * @return
     */
    public static boolean serverToLocal(String userName, String password, String ipAddr, String serverPath, String localPath) {
        boolean isAuthed = false;
        boolean status = false;
        try {
            status = InetAddress.getByName(ipAddr).isReachable(1500);
            System.out.println(status);
            if (status) {
                Connection conn = new Connection(ipAddr);
                conn.connect();
                isAuthed = conn.authenticateWithPassword(userName, password);
                System.out.println(isAuthed);
                if (isAuthed) {
                    Session session = conn.openSession();
                    SCPClient scpClient = conn.createSCPClient();
                    scpClient.get(serverPath, localPath);
                    session.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isAuthed;
    }
}
