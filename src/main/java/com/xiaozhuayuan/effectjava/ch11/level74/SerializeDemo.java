package com.xiaozhuayuan.effectjava.ch11.level74;

import com.xiaozhuayuan.effectjava.ch11.util.SerializeUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by xiaozhu on 17/1/17.
 */
public class SerializeDemo {

    public static void main(String[] args) {
        Foo foo = new Foo(1, 2);

        SerializeUtil.serialize(foo, "/tmp/foo.ser");
    }
}
