package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateCharacter {
    /*
     * Find all duplicate characters in a String and print each of them.
     */
    public static void printDuplicateCharacters(String word) {
        char[] characters = word.toCharArray();
        // build HashMap with character and number of times they appear in String
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }
        // Iterate through HashMap to print all duplicate characters of String
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }

    public static void printDuplicateCharactersBufferReader() {
        String ch;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Statement:");
        try {
            ch = br.readLine();
            int count = 0, len = 0;
            do {
                try {
                    char name[] = ch.toCharArray();
                    len = name.length;
                    count = 0;
                    for (int j = 0; j < len; j++) {
                        if ((name[0] == name[j]) && ((name[0] >= 65 && name[0]

                                <= 91) || (name[0] >= 97 && name[0] <= 123)))
                            count++;
                    }
                    if (count != 0)
                        System.out.println(name[0] + " " + count + " Times");
                    ch = ch.replace("" + name[0], "");
                } catch (Exception ex) {
                }
            } while (len != 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Find longest Substring that contains 2 unique characters
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if (map.size() > 2) {

                max = Math.max(max, i - start);
                while (map.size() > 2) {
                    char t = s.charAt(start);
                    int count = map.get(t);
                    if (count > 1) {
                        map.put(t, count - 1);
                    } else {
                        map.remove(t);
                    }
                    start++;
                }
            }
        }
        max = Math.max(max, s.length() - start);
        return max;
    }

    // Solution for K Unique Characters
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0)
            return 0;
        if (s.length() < k)
            return s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = k;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if (map.size() > k) {
                maxLen = Math.max(maxLen, i - left);
                while (map.size() > k) {
                    char fc = s.charAt(left);
                    if (map.get(fc) == 1) {
                        map.remove(fc);
                    } else {
                        map.put(fc, map.get(fc) - 1);
                    }
                    left++;
                }
            }
        }
        maxLen = Math.max(maxLen, s.length() - left);
        return maxLen;
    }

    // Find substring with concatenation of all the words in Java
    public static List findSubstring(String s, String[] words) {
        ArrayList result = new ArrayList();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        // frequency of words
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }
        int len = words[0].length();
        for (int j = 0; j < len; j++) {
            HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = j;// start index of start
            int count = 0;// count totoal qualified words so far
            for (int i = j; i <= s.length() - len; i = i + len) {
                String sub = s.substring(i,
                        i + len);
                if (map.containsKey(sub)) { // set frequency in current map
                    if (currentMap.containsKey(sub)) {
                        currentMap.put(sub, currentMap.get(sub) + 1);
                    } else {
                        currentMap.put(sub, 1);
                    }
                    count++;
                    while (currentMap.get(sub) > map.get(sub)) {

                        String left = s.substring(start, start + len);
                        currentMap.put(left, currentMap.get(left) - 1);
                        count--;
                        start = start + len;
                    }

                    if (count == words.length) {
                        result.add(start); // add to result
                        // shift right and reset currentMap, count & start point
                        String left = s.substring(start, start + len);
                        currentMap.put(left, currentMap.get(left) - 1);
                        count--;
                        start = start + len;
                    }
                } else {
                    currentMap.clear();
                    start = i + len;
                    count = 0;
                }
            }
        }
        return result;
    }

    public static String shortestSubstringWithCharacters(String s, String t) {
        // Initialize a set to keep track of characters in the current window
        // Set<Character> windowChars = new HashSet<>();

        // // Initialize two pointers for the sliding window: left and right
        // int left = 0;
        // int right = 0;

        // // Initialize variables to keep track of the minimum substring found so far
        // int minLength = Integer.MAX_VALUE;
        // String minSubstring = "";

        // // Convert the characters string to a set for faster lookups
        // Set<Character> targetChars = new HashSet<>();
        // for (char c : characters.toCharArray()) {
        // targetChars.add(c);
        // }

        // while (right < s.length()) {
        // // Expand the window to the right
        // windowChars.add(s.charAt(right));

        // // Check if the current window contains all the target characters
        // while (windowChars.containsAll(targetChars)) {
        // // Update the minimum substring found so far
        // if (right - left + 1 < minLength) {
        // minLength = right - left + 1;
        // minSubstring = s.substring(left, right + 1);
        // }

        // // Move the left pointer to shrink the window
        // windowChars.remove(s.charAt(left));
        // left++;
        // }

        // // Move the right pointer to expand the window
        // right++;
        // }

        // return minSubstring;
        int[] map = new int[256];
        int begin = 0, end = 0; // for substring window
        int head = begin; // for getting the output substring
        for (int i = 0; i < t.length(); i++) { // fill the map with freq of chars in t
            map[t.charAt(i)]++;
        }
        int count = t.length(); // size of t as we have to have this count check
        int min = Integer.MAX_VALUE;
        while (end < s.length()) { // System.out.println(s.charAt(end) + "t" +
            map[s.charAt(end)]++; // System.out.println("Step
            // 1t"+count+"t"+begin+"t"+end+"t"+head+"t"+min);
            if (map[s.charAt(end++)] == 0)
                // {
                // if it is present in map decrease count

                count--;
            // System.out.println("Step
            // 2t"+count+"t"+begin+"t"+end+"t"+head+"t"+min);
            while (count == 0) { // t is found in s
                if (end - begin < min) { // update min and head
                    min = end - begin;
                    head = begin;
                }
                if (map[s.charAt(begin++)]++ == 0) { // shrink the window
                    count++;
                }
            }
            // System.out.println("Step
            // 3t"+count+"t"+begin+"t"+end+"t"+head+"t"+min);
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }

    public static String reverseRecursively(String str) {
        // base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }
        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2)// if not consistant with previous ones
                    return false;
            } else {
                if (map.containsValue(c2)) // if c2 is already being mapped
                    return false;
                map.put(c1, c2);
            }
        }
        return true;
    }

    public static void main(String args[]) {
        // printDuplicateCharacters("Programming");
        // printDuplicateCharacters("Combination");
        // printDuplicateCharacters("Java");
        //
        // printDuplicateCharactersBufferReader();
        String[] a = { "anh", "mot" };
        // System.out.println(lengthOfLongestSubstringKDistinct(
        // "qqqqqqqqqqqqqqqqqqqqqqqqqertyuiopasdfghj", 9));
        //System.out.println(reverseRecursively("abcbbbccbban"));
        System.out.println(isIsomorphic("adfd", "addc"));

    }
    // Print all the characters in string only once in a reverse order.
    /*
     * lặp và kiểm tra tồn tại ký tự trong HashSet, nếu chưa tồn tại thêm thêm áo
     * HashSet, add vào chuỗi đảo ngươc
     */
}
