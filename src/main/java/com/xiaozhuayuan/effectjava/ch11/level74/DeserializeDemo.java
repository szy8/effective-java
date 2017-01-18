package com.xiaozhuayuan.effectjava.ch11.level74;

import com.xiaozhuayuan.effectjava.ch11.util.SerializeUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by xiaozhu on 17/1/17.
 */
public class DeserializeDemo {

    public static void main(String[] args) {
        Foo foo = SerializeUtil.deSerialize("/tmp/foo.ser");

        System.out.println("x is " + foo.getX());
        System.out.println("y is " + foo.getY());
    }
}
