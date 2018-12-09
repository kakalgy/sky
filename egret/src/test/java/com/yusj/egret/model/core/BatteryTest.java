package com.yusj.egret.model.core;

import org.junit.Test;

import java.nio.ByteOrder;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 14:20
 **/
public class BatteryTest {

    @Test
    public void testBattery() {
        Battery battery = new Battery();
    }

    @Test
    public void testByteOrder(){
        System.out.println(ByteOrder.nativeOrder().toString());
    }
}
