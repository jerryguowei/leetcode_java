package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 752. Open the Lock
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 *
 *
 */
public class N0752_OpenTheLock {

    @Test
    public void test(){
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target ="0202";
        System.out.println(openLock1(deadends,target));
    }

    public int openLock(String[] deadends, String target) {
        Queue<String> q1 = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));
        q1.offer("0000");
        if(visited.contains("0000")) return -1;
        int step = 0;
        while(q1.size() > 0) {
            int size = q1.size();
            for(int i = 0; i < size; i++) {
                String temp = q1.poll();
                if(temp.equals(target)) return step;
                Set<String> p1 = plusOne(temp, visited);
                for(String t : p1) {
                    q1.offer(t);
                    visited.add(t);
                }
                Set<String> m1 = minusOne(temp, visited);
                for(String t : m1) {
                    q1.offer(t);
                    visited.add(t);
                }
            }
            step++;
        }
        return -1;

    }

    public int openLock1(String[] deadends, String target) {

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));
        q1.add("0000");
        q2.add(target);
        if (visited.contains("0000") || visited.contains(target)) return -1;
        int step = 0;
        while (q1.size() > 0 && q2.size() > 0) {
            Set<String> tempSet = new HashSet<>();
            for (String cur : q1) {
                if (q2.contains(cur)) return step;
                visited.add(cur);
                Set<String> p1 = plusOne(cur, visited);
                tempSet.addAll(p1);
                Set<String> m1 = minusOne(cur, visited);
                tempSet.addAll(m1);
            }
            step++;
            q1 = q2;
            q2 = tempSet;
        }
        return -1;
    }

      private Set<String> plusOne(String value, Set<String> visited) {
        Set<String> result = new HashSet<>();
        char[] chars = value.toCharArray();
        for(int i = 0; i < 4; i++) {
            char temp = chars[i];
            if(temp == '9'){
                chars[i] = '0';
            } else {
                chars[i]+=1;
            }
            String tempString = new String(chars);
            chars[i] = temp;
            if(visited.contains(tempString)) continue;
            // visited.add(tempString);
            result.add(tempString);

        }
        return result;
    }

    private Set<String> minusOne(String value, Set<String> visited) {
        Set<String> result = new HashSet<>();
        char[] chars = value.toCharArray();
        for(int i = 0; i < 4; i++) {
            char temp = chars[i];
            if(temp == '0') {
                chars[i] = '9';
            } else {
                chars[i] -= 1;
            }
            String tempString = new String(chars);
            chars[i] = temp;
            if(visited.contains(tempString)) continue;
            // visited.add(tempString);
            result.add(tempString);
        }
        return result;
    }
}
