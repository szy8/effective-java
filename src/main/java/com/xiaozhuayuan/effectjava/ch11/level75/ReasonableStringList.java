package com.xiaozhuayuan.effectjava.ch11.level75;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by xiaozhu on 17/1/17.
 */
public final class ReasonableStringList implements Serializable {

    private transient int size = 0;
    private transient Entry head = null;

    private Entry getLastEntry() {
        Entry tempEntry = head;
        while (null != tempEntry.next) {
            tempEntry = tempEntry.next;
        }
        return tempEntry;
    }

    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    public final void add(String s) {
        Entry entry = new Entry();
        entry.data = s;
        if (null == head) {
            head = entry;
        } else {
            Entry lastEntry = getLastEntry();
            lastEntry.next = entry;
            entry.previous = lastEntry;
        }
        size++;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        for (Entry e = head; e != null; e = e.next) {
            s.writeObject(e.data);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        for (int i = 0; i < numElements; i++) {
            add((String) s.readObject());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Entry entry = head;
        while (null != entry) {
            stringBuilder.append(entry.data).append(",");
            entry = entry.next;
        }
        return stringBuilder.toString();
    }
}
