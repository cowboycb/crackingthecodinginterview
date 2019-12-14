package arrays_strings;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * Allowed Data Structures:
 * StringBuilder, HashTable, HashMap, Arrays, ArrayList,... Other Resizable Arrays
 *
 */
public class IsUnique {

    public static boolean isAllCharactersUnique(String s){
        Map<Character, Integer> map = s.chars()
                                    .mapToObj(c-> (char)c)
                                    .collect(Collectors.toMap(c -> c, c -> new Integer(1), (oldv, newv) ->  oldv+1));

        Optional<Integer> opt = map.values().stream().max(Comparator.naturalOrder());
        return opt.get()==1;
    }

    public static void main(String[] args) {
        String str = "fragile";
        boolean result = isAllCharactersUnique(str);
        System.out.printf("Is '%s' unique? %b\n", str, result);

        str = "collaborate";
        result = isAllCharactersUnique(str);
        System.out.printf("Is '%s' unique? %b\n", str, result);

        str = "compare";
        result = isAllCharactersUnique(str);
        System.out.printf("Is '%s' unique? %b\n", str, result);

    }
}
