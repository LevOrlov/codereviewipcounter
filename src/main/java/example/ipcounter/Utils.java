package example.ipcounter;

import me.tongfei.progressbar.ProgressBarBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.Optional;

public class Utils {

    public static String EMPTY_STRING = "";

    public Utils(){
        throw new UnsupportedOperationException();
    }

    public static ProgressBarBuilder getProgressBarBuilder(String fileName) {
        return new ProgressBarBuilder()
                .setTaskName("Reading " + Path.of(fileName).getFileName())
                .setUnit("MB", 1048576);
    }

    public static int convertIpToInt(String ipAddress) throws UnknownHostException {
        return ByteBuffer.allocate(Integer.BYTES)
                .put(InetAddress.getByName(ipAddress).getAddress())
                .getInt(0);
    }

}
