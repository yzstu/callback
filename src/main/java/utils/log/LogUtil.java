package utils.log;


import utils.DateUtil;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LogUtil {

    public static LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(Integer.MAX_VALUE);
    public static ThreadPoolExecutor excecutor = new ThreadPoolExecutor(1, 1, 1000l, TimeUnit.MILLISECONDS, queue);

    public static void write2file(final String str, final String fileName) {

            excecutor.execute(new Runnable() {

                @Override
                public void run() {
                    if (SystemUtil.isLinux()) {
                        checkDirectory("/home/data/linuxLog/server1000");
                        FileUtil.write("/home/data/linuxLog/server1000" + fileName + ".txt",
                                DateUtil.getDateTime() + ":" + str + "\r\n");
                    } else {
                        checkDirectory("D:/winLog/server1000");
                        FileUtil.write("D:/winLog/server1000" + fileName + ".txt",
                                DateUtil.getDateTime() + ":" + str + "\r\n");
                    }
                }
            });

        }

    public static void checkDirectory(String path) {
        File file = new File(path);
        //如果文件夹不存在则创建
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
    }


    public static void shutDown() {
        if (excecutor.isShutdown()) {
        } else {
            excecutor.shutdown();
        }

    }

}
