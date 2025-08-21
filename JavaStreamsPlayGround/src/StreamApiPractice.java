import java.time.Instant;
import java.util.*;
import java.util.stream.*;

public class StreamApiPractice {

    public static void main(String[] args) {
        // EX-1: Squares
          /*Squares of numbers
          Data: List<Integer> nums = Arrays.asList(1,2,3,4,5);
          Task: Return a list of squares.
          Expected: [1, 4, 9, 16, 25]*/
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result1 = nums1.stream().map(a -> a * a).toList();
        System.out.println("Exercise 1: Squares of numbers\n" + result1);

          /*Ex-2: Filter even numbers from a list.
          * Filter evens
            Data: List<Integer> nums = Arrays.asList(3,6,7,8,10,11,14);
            Task: Keep only even numbers.
            Expected: [6, 8, 10, 14]
          * */
        List<Integer> nums2 = Arrays.asList(3, 6, 7, 8, 10, 11, 14);
        List<Integer> result2 = nums2.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println("Exercise 2: Filter Evens\n" + result2);

        /*Ex-3 Uppercase all
        Data: List<String> words = Arrays.asList("java","Stream","api","Practice");
        Task: Uppercase all strings.
        Expected: ["JAVA","STREAM","API","PRACTICE"]
        * */
        List<String> words = Arrays.asList("java", "Stream", "api", "Practice");
        List<String> result3 = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Exercise 3: UpperCase all\n" + result3);

        /*Ex-4 Lengths of strings
          Data: List<String> names = Arrays.asList("Alice","Bob","Charlie","David");
          Task: Map to lengths.
          Expected: [5,3,7,5]
        * */
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<Integer> result4 = names.stream().map(a -> a.length()).toList();
        System.out.println("Exercise 4: Lengths of strings\n" + result4);

        /*Ex-5 Count > 10
          Data: List<Integer> nums = Arrays.asList(4,11,9,15,21,8,10,12);
          Task: Count numbers strictly greater than 10.
          Expected: 4*/
        List<Integer> nums3 = Arrays.asList(4, 11, 9, 15, 21, 8, 10, 12);
        int result5 = (int) nums3.stream().filter(num -> num > 10).count();
        System.out.println("Exercise 5: Count >10\n" + result5);

        /*Ex-6 Ascending & descending sort
        Data: List<Integer> nums = Arrays.asList(9,1,5,3,7,2,8);
        Task: Return ascending and descending lists.
        Expected: asc [1,2,3,5,7,8,9], desc [9,8,7,5,3,2,1]*/
        List<Integer> nums4 = Arrays.asList(9, 1, 5, 3, 7, 2, 8);
        List<Integer> result6Asc = nums4.stream().sorted().toList();
        List<Integer> result6Desc = nums4.stream().sorted((a, b) -> b - a).toList();
        System.out.println("Exercise 6: Ascending & Descending\nasc " + result6Asc + " desc " + result6Desc);

        /* Ex-7 Min/Max
        Data: List<Integer> nums = Arrays.asList(42,17,68,3,29);
        Task: Print min and max.
        Expected: min=3, max=68
        * */
        List<Integer> nums5 = Arrays.asList(42, 17, 68, 3, 29);
        int max = nums5.stream().max(Integer::compare).get();
        int min = nums5.stream().min(Integer::compare).get();
        System.out.println("Exercise 7: Min/Max\nMin " + min + " max " + max);

        /* Ex-8 Remove duplicates
         * Data: List<Integer> nums = Arrays.asList(1,2,2,3,3,3,4,1,5);
         * Task: Distinct list.
         * Expected: [1,2,3,4,5]
         * */
        List<Integer> nums6 = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 1, 5);
        List<Integer> result8 = nums6.stream().distinct().toList();
        System.out.println("Exercise 8: Distinct distinct numbers\n" + result8);

        /* Ex-9 Join strings
        Data: List<String> pieces = Arrays.asList("Java","streams","are","cool");
        Task: Join with space.
        Expected: "Java streams are cool"
        * */
        List<String> pieces = Arrays.asList("Java", "streams", "are", "cool");
        String joinedString = pieces.stream().collect(Collectors.joining(" "));
        System.out.println("Exercise 9: Joined String\n" + joinedString);

        /*Any starts with A
        Data: List<String> names = Arrays.asList("bob","ALICE","andrew","david");
        Task: Case-insensitive check if any starts with “A”.
        Expected: true
        * */
        List<String> names2 = Arrays.asList("bob", "ALICE", "andrew", "david");
        boolean result = names2.stream().anyMatch(obj -> obj.toUpperCase().startsWith("A"));
        System.out.println("Exercise 10: Matches\n" + result);
    }
}