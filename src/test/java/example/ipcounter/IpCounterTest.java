package example.ipcounter;

import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;

public class IpCounterTest {

    IpCounter ipCounter = new IpCounter();

    @Test
    public void counting() {
        ipCounter.counting("src/test/resources/test.txt");
        assertEquals(799999, ipCounter.getResult());
    }

    @Test
    public void checkConvertorIp() throws UnknownHostException {
        assertEquals(-1, Utils.ipToLong("255.255.255.255"));
    }

}