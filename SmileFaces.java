import java.util.*;

public class SmileFaces {

    public static int countSmileys(List<String> arr) {
        // Just Smile :)
        if (arr.size() == 0) {
            return 0;
        }

        int count = 0;
        for (String str : arr) {
            if (str.length() != 2 && str.length() != 3) {
                continue;
            }

            if (str.charAt(0) != ':' && str.charAt(0) != ';') {
                continue;
            }

            if (str.charAt(str.length() - 1) != ')' && str.charAt(str.length() - 1) != 'D') {
                continue;
            }

            if (str.length() == 3 && str.charAt(1) != '-' && str.charAt(1) != '~') {
                continue;
            }
            count++;
        }
        return count;
        //return (int)arr.stream().filter( x -> x.matches("[:;][-~]?[)D]")).count();   
        // countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
        // countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
        // countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;

    }
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add(":)"); a.add(":)"); a.add("x-]"); a.add(":ox"); a.add(";-("); a.add(";-)"); a.add(";~("); a.add(":~D");a.add("9;-D");a.add(";-D9");

        System.out.println(SmileFaces.countSmileys(a));
    }
}