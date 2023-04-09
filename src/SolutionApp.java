import java.util.HashMap;
import java.util.Map;

public class SolutionApp {

    public static void main(String[] args) {

        String s = "xyzzaz";
        String sTwo = "aababcabc";
        int k = 3;

        System.out.println(solution(s, k));
        System.out.println(solution(sTwo, k));

        /*
        Constraints:
         1 <= s.length <= 100
         s consists of lowercase English letters.

         Time Complexity = O(n)
         Space Complexity = O(1)
         */
    }

    public static int solution(String s, int k) {
        int counter = 0;
        int start = 0;
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            characterMap.put(s.charAt(i), characterMap.getOrDefault(s.charAt(i), 0) + 1);
            if (i >= k - 1) {
                if (characterMap.size() == k){
                    counter++;
                }
                if (characterMap.get(s.charAt(start)) > 1) {
                    characterMap.put(s.charAt(start), characterMap.getOrDefault(s.charAt(start), 0) - 1);
                } else {
                    characterMap.remove(s.charAt(start));
                }
                start++;
            }
        }
        return counter;
    }
}
