package example.ipcounter;


import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;

import java.io.*;
import java.util.BitSet;

import static example.ipcounter.Utils.convertIpToInt;
import static example.ipcounter.Utils.getProgressBarBuilder;
public class IpCounter {

    private final BitSet positive = new BitSet(Integer.MAX_VALUE);
    private final BitSet negative = new BitSet(Integer.MAX_VALUE);

    private long resultCountIp;

    public void counting(String filePath) {
        ProgressBarBuilder pbb = getProgressBarBuilder(filePath);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        ProgressBar.wrap(new FileInputStream(filePath), pbb)))) {
            String ip;
            long ipLong;
            while ((ip = reader.readLine()) != null) {
                ipLong = convertIpToInt(ip);
                if (ipLong < 0) negative.set(-(int) ipLong);
                if (ipLong > 0) positive.set((int) ipLong);
            }
            resultCountIp = negative.cardinality() + positive.cardinality();
        } catch (Exception e) {
            System.err.println("Ошибка обработки. Счетчик уникальных адресов обнулен.");
            resultCountIp = 0;
            e.printStackTrace();
        }
    }

    public long getResult() {
        return resultCountIp;
    }
}
