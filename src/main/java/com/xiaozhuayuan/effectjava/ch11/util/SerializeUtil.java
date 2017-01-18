package com.xiaozhuayuan.effectjava.ch11.util;

import com.xiaozhuayuan.effectjava.ch11.level74.Foo;

import java.io.*;

/**
 * Created by xiaozhu on 17/1/17.
 */
public class SerializeUtil {

    public static void serialize(Object o, String filePath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /tmp/foo.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T deSerialize(String filePath) {
        T t = null;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            t = (T) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
}
