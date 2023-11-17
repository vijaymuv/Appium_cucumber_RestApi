package objectsitbusinessbook;

import org.testng.annotations.Test;

public class Java_School_geeksforgeeks {

    void firstLetterUpperCase() {
        String str = "i love programming";
        String Word = "";
        String[] eachWord = str.split(" ");
        for (String word : eachWord) {
            Word = Word + word.substring(0, 1).toUpperCase() + word.substring(1, word.length()) + " ";

        }
        System.out.println(Word);
    }

    @Test
    void Seperate_number() {
        String s = "123 789 jav";
        String total = "";

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (Character.isDigit(c1)) {
                total = total + Character.getNumericValue(c1);
            }
        }
        System.out.println(total);
    }
@Test
    void missingNumber(){
        int A[] = {1,2,3,5};
        int dup=0;
        int sum1=0;
        int sum2=0;
    int  missingNo=0;
    for (int i = 0; i < A.length; i++) {

            sum1=sum1+A[i];
       // System.out.println(sum1);
    }
    for (int i = 0; i < A.length; i++) {
        for (int j = i+1; j < A.length; j++) {

            if (A[i]<A[j]) {//0<2
                dup = A[j];

            }
        }

    }
    for (int i = 1; i <=dup ; i++) {
        sum2=sum2+i;
    }
    System.out.println(dup);
    missingNo =sum2-sum1;
    System.out.println(missingNo);
    }
}