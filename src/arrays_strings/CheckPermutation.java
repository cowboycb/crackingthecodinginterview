package arrays_strings;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 * For Example "abcd" and "dbca" are permutation of each other.
 */
public class CheckPermutation {

    private static Map<Character, Integer> convertStringToCountMap(String s){
        return s.chars().mapToObj(c->(char)c).collect(Collectors.toMap(c->c, d->new Integer(1), (oldv, newv) -> oldv+1));
    }

    public static boolean checkPermutationOfEachOther(String s1, String s2){
        Map<Character, Integer> map1 = convertStringToCountMap(s1);
        Map<Character, Integer> map2 = convertStringToCountMap(s2);

        if (map1.size() != map2.size()) return false;
        else {
            AtomicBoolean result = new AtomicBoolean(true);
            map1.forEach((k, v) -> {
                if (!v.equals(map2.get(k))){
                    result.set(false);
                }
            });
            return result.get();
        }
    }

    public static void main(String[] args) {
        System.out.println(checkPermutationOfEachOther("abc", "cab")); // true
        System.out.println(checkPermutationOfEachOther("abcd", "cab")); // false
        System.out.println(checkPermutationOfEachOther("abc", "cabd")); // false
        System.out.println(checkPermutationOfEachOther("abc", "abx")); // false
    }

}
