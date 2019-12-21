package arrays_strings;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * For Example:
 * Input: "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
public class URLify {

    public static String urlify(char[] str, int trueLength){
        AtomicInteger atomFullLength = new AtomicInteger(str.length);
        AtomicInteger atomTrueLength = new AtomicInteger(trueLength);
        IntStream.range(0, trueLength-1).forEach(i -> {
            int index = atomTrueLength.get() - i - 1;
//            System.out.println(str[index]);
            if (str[index] == ' '){
                str[atomFullLength.get()-1] = '0';
                str[atomFullLength.get()-2] = '2';
                str[atomFullLength.get()-3] = '%';
                atomFullLength.getAndAdd(-3);
            }else{
                str[atomFullLength.get()-1] = str[index];
                atomFullLength.getAndDecrement();
            }
        });

        return IntStream.range(0, str.length).mapToObj(i->String.valueOf(str[i])).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println("\"Mr John Smith    \" = " + urlify("Mr John Smith    ".toCharArray(), 13));
        System.out.println("\"Any  Design  Pat tern          \" = " + urlify("Any  Design  Pat tern          ".toCharArray(), 21));
    }


}
