package com.yc.common.core.base.utils;

/**
 * @description:
 * @author: youcong
 */
public class JudgeSysUtil {

    private static final String OS_NAME = "os.name";

    private static final String LINUX_SYS = "linux";

    private static final String WINDOWS_SYS = "windows";

    private static final String OTHER_SYS = "other system";

    /**
     * Linux
     *
     * @return
     */
    public static boolean isLinux() {
        return System.getProperty(OS_NAME).toLowerCase().contains("linux");
    }

    /**
     * Windows
     *
     * @return
     */
    public static boolean isWindows() {
        return System.getProperty(OS_NAME).toLowerCase().contains("windows");
    }

    /**
     * 判断当前操作系统
     *
     * @return
     */
    public static String JudgeSystem() {
        if (isLinux()) {
            return LINUX_SYS;
        } else if (isWindows()) {
            return WINDOWS_SYS;
        } else {
            return OTHER_SYS;
        }
    }

    public static void main(String[] args) {
        System.out.println("current system is:" + JudgeSysUtil.JudgeSystem());
    }
}
