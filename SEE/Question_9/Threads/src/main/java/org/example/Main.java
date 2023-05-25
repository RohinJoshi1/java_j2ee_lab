package org.example;

import com.sun.jdi.VoidValue;

/*
* Write a Java Program that creates two threads object of Thread class.
* Where one thread asks the user to enter a number not less than four digits.
* Split the digits of the number and display in words the value of the number.
*  Ex: 1 – One.
*  Second thread finding the number of vowels in a word. Ex: JAVA – Vowel - A, Count – 2.*/
public class Main {
    public static void main(String[] args) {
        NumberThread nT = new NumberThread();
        Thread t1 = new Thread(nT);
        t1.start();
        VowelThread vT = new VowelThread();
        Thread t2 = new Thread(vT);
        t2.start();
    }
}