package Arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    public static String encode(List<String> strs) {
        String str = "";
        for(String s : strs){
            int len = s.length();
            str=str.concat(len+"#"+s);
        }
        return str;
    }

    public static List<String> decode(String str) {
        List<String> ls = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // 1. Find the delimiter '#' starting from index i
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // 2. The number between i and j is the length of the string
            int length = Integer.parseInt(str.substring(i, j));

            // 3. Move the pointer to the start of the actual string (after '#')
            int startOfWord = j + 1;
            int endOfWord = startOfWord + length;

            // 4. Extract the substring and add to list
            ls.add(str.substring(startOfWord, endOfWord));

            // 5. Move i to the beginning of the next length-prefix
            i = endOfWord;
        }

        return ls;
    }

    public static void main(String[] args) {
        List<String> st = new ArrayList<>();
        st.add("Hello");
        st.add("world");
        String s = encode(st);
        System.out.println(s);

        System.out.println(decode(s));
    }
}
