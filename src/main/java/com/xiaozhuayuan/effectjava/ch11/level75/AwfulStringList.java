package com.xiaozhuayuan.effectjava.ch11.level75;

import java.io.Serializable;

/**
 * Created by xiaozhu on 17/1/17.
 */
public final class AwfulStringList implements Serializable{

    private int size = 0;
    private Entry head = null;

    private static class Entry implements Serializable {
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

    private Entry getLastEntry() {
        Entry tempEntry = head;
        while (null != tempEntry.next) {
            tempEntry = tempEntry.next;
        }
        return tempEntry;
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
