package org.example;

import java.util.*;
public class NumberThread implements Runnable{
    HashMap<Integer,String> map = new HashMap<>();
    public NumberThread(){
        this.map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(5,"five");
        map.put(6,"six");
        map.put(7,"seven");
        map.put(8,"eight");
        map.put(9,"nine");
        map.put(0,"zero");

    }
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter >=4 digit number");
        String num = sc.nextLine();
        if(num.length()<4){
            System.out.println("Enter number with greater than or equal to 4 digits");
            num = sc.nextLine();
        }
        for(int i=0;i<num.length();i++){
            if(!Character.isDigit(num.charAt(i))){
                System.out.println("Invalid entry");
                break;
            }
            int digit = Integer.parseInt(""+num.charAt(i));
            System.out.println(digit+":"+map.get(digit));
        }



    }
}
