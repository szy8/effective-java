package com.xiaozhuayuan.effectjava.ch11.level75;

import com.xiaozhuayuan.effectjava.ch11.util.SerializeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by xiaozhu on 17/1/17.
 */
public class ReasonableStringListTest {

    @Test
    public void testAdd() {
        ReasonableStringList stringList = new ReasonableStringList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        Assert.assertEquals(stringList.toString(), "1,2,3,");
    }

    @Test
    public void serializeCostTime() {
        ReasonableStringList stringList = new ReasonableStringList();
        Date startTime = new Date();
        for (int i = 0; i < 1000; i++) {
            stringList.add("1234567890");
        }
        SerializeUtil.serialize(stringList, "/tmp/reasonableStringList.ser");
        Date endTime = new Date();
        long costMilliSeconds = endTime.getTime() - startTime.getTime();
        System.out.println("cost time is " + costMilliSeconds + " ms");
    }
}
