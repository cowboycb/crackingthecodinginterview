package arrays_strings;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * For Example:
 * Input:   Tact Coa
 * Output:  false
 */
public class PalindromePermutation {

    public static boolean isPermutationPalindrome(String str) {

        Map<Character, Integer> mapCharCounts = str.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(Character::toLowerCase, d -> 1, (oldv, newv) -> oldv + 1));
        System.out.println(mapCharCounts + " - length " + str.length());
        if (str.length() % 2 == 0){
            return mapCharCounts.values().stream().noneMatch(i -> i % 2 != 0);
        }else{
            return mapCharCounts.values().stream().filter(i->i%2!=0).count()==1;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPermutationPalindrome("baba"));
        System.out.println(isPermutationPalindrome("code"));
        System.out.println(isPermutationPalindrome("Tact coa")); // both of " " and "o" characters occurs just once and this is inappropriate the algorithm..
    }

}
