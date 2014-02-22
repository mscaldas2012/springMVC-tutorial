package com.msc.util.net;

import org.apache.commons.net.util.SubnetUtils;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;
//import org.apache.commons.utils.net

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
public class CIDRTest {
    private static final Logger logger = Logger.getLogger(CIDRTest.class.getName());

    @org.junit.Test
    public void testIsIPinRange() throws Exception {
        boolean isIPInRange = CIDR.isIPinRange("158.111.147.23", "158.111.0.0/16");
        System.out.println("isIPInRange = " + isIPInRange);
        assertTrue(isIPInRange);

        boolean isIPNotInRange = CIDR.isIPinRange("158.111.147.23", "159.111.0.0/16");
        System.out.println("isIPNotInRange = " + isIPNotInRange);
        assertTrue(!isIPNotInRange);

        boolean isIPInRange2 = CIDR.isIPinRange("172.25.67.0/22", "172.25.67.224");
        System.out.println("isIPInRange2 = " + isIPInRange2);
       // assertTrue(isIPInRange2);

        SubnetUtils su = new SubnetUtils("172.25.64.0/22");
        boolean commons = su.getInfo().isInRange("172.25.67.224");
        System.out.println("count: " + su.getInfo().getAddressCount());
        System.out.println("low: " + su.getInfo().getLowAddress());
        System.out.println("High: " + su.getInfo().getHighAddress());
        System.out.println("commons = " + commons);

    }
}
