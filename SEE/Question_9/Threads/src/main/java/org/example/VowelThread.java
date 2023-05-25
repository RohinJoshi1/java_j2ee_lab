package org.example;

import java.util.*;

public class VowelThread implements Runnable{
    HashMap<Character,Integer> map = new HashMap<>();
    public VowelThread() {
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        //Find vowels and keep count
        System.out.println("Enter string");
        String s = sc.nextLine();
        for (char c : s.toCharArray()) {
            if (map.containsKey(Character.toLowerCase(c))) {
                map.put(c, map.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("vowel: " + entry.getKey() + "count: " + entry.getValue());
        }
    }
}
