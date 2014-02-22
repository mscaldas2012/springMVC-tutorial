package com.msc.util.net;

import java.util.StringTokenizer;
import java.util.logging.Logger;

/**
 * This code was written by Marcelo Caldas.
 * e-Mail: mscaldas@gmail.com
 * <p/>
 * \* Project: springmvc-web
 * <p/>
 * Date: 2/21/14
 * <p/>
 * Enjoy the details of life.
 */
public class CIDR {
    private static final Logger logger = Logger.getLogger(CIDR.class.getName());


    public static boolean isIPinRange(String ip, String cidr) {
        int[] cidrCluster = getCidrCluster(cidr);
        long addr = getIPAsBinary(cidrCluster);

        // Step 2. Get CIDR mask
        long mask = (-1) << (32 - cidrCluster[4]);
        // Step 3. Find lowest IP address
        long lowest = addr & mask;
        // Step 4. Find highest IP address
        long highest = lowest + (~mask);

        int[] ipCluster  =getCidrCluster(ip);
        long ipB = getIPAsBinary(ipCluster);

        return ipB >= lowest && ipB <= highest;
    }

    private static long getIPAsBinary(int[] cidrCluster) {
        return (long) (((cidrCluster[0] << 24) & 0xFF000000)
                        | ((cidrCluster[1] << 16) & 0xFF0000)
                        | ((cidrCluster[2] << 8) & 0xFF00)
                        | (cidrCluster[3] & 0xFF));
    }

    protected static int[] getCidrCluster(String cidr) {
        StringTokenizer st = new StringTokenizer(cidr, "./", false);
        int[] result = new int[5];
        int i = 0;
        while (st.hasMoreElements()) {
            result[i++] = Integer.parseInt((String) st.nextElement());
        }
        return result;
    }
}
