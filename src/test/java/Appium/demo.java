package Appium;

import java.util.Arrays;

import static java.util.Arrays.*;
public class demo {
    public static void main(String[] args) {
        String  s = "the sky is blue";
        String rev="";
        String[] words = s.trim().split(" ");
            for (int i = words.length-1; i>=0 ; i--) {
                rev=rev+words[i]+" ";

        }

    }
}
/* int candies[] = {4, 6, 1};
         int m=0;
         for (int i = 0; i <candies.length ; i++) {
        if(m<candies[i]){ //0>4
        m=candies[i];
        }
        }
        System.out.println(m);
        int extraCandies = 2;
        for (int i = 0; i < candies.length; i++) {
        int no = candies[i] + extraCandies;
        if(no>m || no>=m){ //5<4
        System.out.println("true");
        }else{
        System.out.println("false");
        }
        }*/