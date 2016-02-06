package com.mobiledev.todolist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tomas on 2/5/16.
 */
public class DayLinkedListST<Integer, String> implements Iterable<Integer> {

    private Node mFirstDay;
    private int mNumberDays;

    private class Node {
        private Integer day;
        private String editText;
        private Node next;

        public Node(Integer day, String todo, Node next) {
            this.day = day;
            this.editText = todo;
            this.next = next;
        }
    }

    public int size() {
        return mNumberDays;
    }

    public boolean contains(Integer day) {
        for (Node x = mFirstDay; x != null; x = x.next) {
            if (day.equals(x.day))
                return true;
        }
        return false;
    }

    public void put(Integer day, String todo) {
        for (Node x = mFirstDay; x != null; x = x.next) {
            if (day.equals(x.day)) {
                x.editText = todo;
                return;
            }
        }
        mFirstDay = new Node(day, todo, mFirstDay);
        mNumberDays++;
    }

    public String remove(Integer day) {
        if (mFirstDay == null)
            return null;

        if (day.equals(mFirstDay.day)) {
            String note = mFirstDay.editText;
            mFirstDay = mFirstDay.next;
            mNumberDays--;
            return note;
        }

        for (Node x = mFirstDay; x.next != null; x = x.next) {
            if (day.equals(x.next.day)) {
                String note = x.next.editText;
                x.next = x.next.next;
                mNumberDays--;
                return note;
            }
        }

        return null;
    }

    public String get(Integer day) {
        for (Node x = mFirstDay; x.next != null; x = x.next) {
            if (day.equals(x.day))
                return x.editText;
        }

        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator(mFirstDay);
    }

    private class ListIterator implements Iterator<Integer> {

        private Node mCurrentDay;

        public ListIterator(Node first) {
            mCurrentDay = first;
        }

        public boolean hasNext(){
            return mCurrentDay!=null;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Integer next(){
            if(!hasNext())
                throw new NoSuchElementException();
            Integer day = mCurrentDay.day;
            mCurrentDay = mCurrentDay.next;
            return day;
        }

    }

}
