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

        /*Level 2: Intermediate
        * Focus on reduce, distinct, flatMap, and collectors.*/

        /*Ex-11 Sum of squares of evens
        Data: List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        Task: Sum squares of even numbers.
        Expected: 2²+4²+6² = 4+16+36 = 56*/

        List<Integer> nums7 = Arrays.asList(1,2,3,4,5,6);
        int sum=nums7.stream()
                .filter(num->num%2==0)
                .map(x -> x*x)
                .reduce(Integer::sum)
                .get();
        System.out.println("Exercise 11: Sum of squares of even numbers\n" + sum);

        /*Ex-12 Product with reduce
          Data: List<Integer> nums = Arrays.asList(2,3,4,5);
          Task: Product via reduce.
          Expected: 120   */

        List<Integer> nums8 = Arrays.asList(2,3,4,5);
        int prod=nums8.stream()
                .reduce((a,b)->a*b).orElse(0);
        //use reduce without identity for reduce so it will return optional that will be ideal for empty list case.
        //using reduce with neutral identity will provide 1 as the answer when list is empty.
        System.out.println("Exercise 12: Prod of all numbers\n" + prod);

        /*Ex-13 Distinct words (case-insensitive)
        Data:
        List<String> sentences = Arrays.asList(
         "Java Stream API provides a fluent interface.",
         "Streams support functional-style operations.",
         "Count distinct WORDS across sentences!"
        );
        Task: Count distinct words (lowercase, strip punctuation).
        Expected: e.g., ~13–18 (depends on tokenization; aim for robust normalization).*/

        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface.",
                "Streams support functional-style operations.",
                "Count distinct WORDS across sentences!"
        );
        int distinct_count=(int)sentences.stream()
                //split each sentences into word
                .flatMap(str->Arrays.stream(str.split(" ")))
                //normalize: lowercase+remove other cases
                .map(str->str.toLowerCase().replaceAll("[^a-z]", ""))
                .distinct()
                .count();
        System.out.println("Exercise 13: Distinct count\n" + distinct_count);

        /*Ex-14 First 5 evens
        Data: List<Integer> nums = Arrays.asList(2,4,6,8,10,12,14);
        Task: Take first 5 even numbers.
        Expected: [2,4,6,8,10]*/
        List<Integer> nums9 = Arrays.asList(2,4,6,8,10,12,14);
        List<Integer> result14=nums9.stream()
                .filter(obj->obj%2==0)
                .limit(5)
                .toList();
        System.out.println("Exercise 14: Filter evens\n" + result14);

        /*Ex-15 Longest string
        Data: List<String> arr = Arrays.asList("bear","tiger","hippopotamus","cat");
        Task: Longest string.
        Expected: "hippopotamus"
        * */
        List<String> arr = Arrays.asList("bear","tiger","hippopotamus","cat");
        String str=arr.stream()
                .max(Comparator.comparing(String::length))
                .get();
        System.out.println("Exercise 15: Longest String in a list\n" + str);



        /*Ex-16 Given a list of numbers, return the second highest element.
        * Second highest
        Data: List<Integer> nums = Arrays.asList(10, 20, 5, 30, 25, 30);
        Task: Second highest distinct value.
        Expected: 25
        * */
        List<Integer> nums10 = Arrays.asList(10, 20, 5, 30, 25, 30);
        int secondHighest=nums10
                .stream()
                .distinct()
                .sorted(
                        Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("Exercise 16: Second Highest List\n" + secondHighest);

        /*Ex-17 Average word length
        Data: List<String> words = Arrays.asList("alpha","beta","gamma","delta");
        Task: Average length as double.
        Expected: (5+4+5+5)/4 = 4.75
        * */
        List<String> words2 = Arrays.asList("alpha","beta","gamma","delta");
        double avgWordsCount=words2.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
        System.out.println("Exercise 17: Words count Avg\n" + avgWordsCount);

        /*Ex-18 Partition odd/even
        Data: List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Task: Map<Boolean,List<Integer>> by evenness.
        Expected: {true=[2,4,6,8], false=[1,3,5,7,9]}*/
        List<Integer> nums11 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Map<Boolean,List<Integer>> evenes=nums11.stream()
                .collect(
                        Collectors.partitioningBy(x->x%2==0));
        System.out.println("Exercise 18: partition odd & even\n" + evenes);

        /*Ex-19 Word → length map
        Data: List<String> words = Arrays.asList("red","green","blue","green");
        Task: Map word→length, handle duplicates (pick first or use merge fn).
        Expected: {"red":3,"green":5,"blue":4}
        * */
        List<String> words3 = Arrays.asList("red","green","blue","green");
        //Map<String,Integer> wordLength=words3.stream().distinct().collect(Collectors.toMap(Object::toString,String::length));
        Map<String,Integer> wordLength=words3.stream()
                .collect(Collectors.toMap(
                        word->word,
                        String::length,
                        (len1,len2)->len1
                ));
        System.out.println("Exercise 19: word->length\n" + wordLength);

        /*Ex-20 Sort by length then alpha
        Data: List<String> words = Arrays.asList("to","tea","ted","ten","a","i");
        Task: Sort by length asc, then lexicographically.
        Expected: [a,i,to,tea,ted,ten]
        * */
        List<String> words4 = Arrays.asList("to","tea","ted","ten","i","a");
        List<String> sortedByCustomOrder=words4.stream()
                .sorted(
                        Comparator.comparing(String::length)
                                .thenComparing(Comparator.naturalOrder()))
                .toList();
        System.out.println("Exercise 20: Sorted by length then alpha\n"+sortedByCustomOrder);


        /*Level 3 — Grouping, flatMap, collectors*/

        /*EX-21 Group by first char
        Data: List<String> words = Arrays.asList("apple","ant","bat","ball","cat","car");
        Task: Map<Character,List<String>>.
        Expected: {a=[apple,ant], b=[bat,ball], c=[cat,car]}
        * */
        List<String> words5 = Arrays.asList("apple","ant","bat","ball","cat","car");
        Map<Character,List<String>> resultMap=words5.stream()
                .collect(Collectors.groupingBy(word->word.charAt(0)));
        System.out.println("Exercise 21: Group by first character\n" + resultMap);


        /*Ex-22 Top 3 longest words from sentences
        Data:

        List<String> sentences = Arrays.asList(
         "Streams are powerful and expressive.",
         "Collectors enable grouping and reduction.",
         "Functional programming in Java is fun!"
        );
        Task: Normalize, split, distinct, sort by length desc, take 3.
        Expected: e.g., ["programming","collectors","expressive"] (varies by normalization).*/

        List<String> sentences2 = Arrays.asList(
                "Streams are powerful and expressive.",
                "Collectors enable grouping and reduction.",
                "Functional programming in Java is fun!"
        );
       List<String> topThreeWord= sentences2.stream()
                .flatMap(st->Arrays.stream(st.replaceAll("[.!]","").split(" ")))
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(3)
                .toList();
       System.out.println("Exercise 22: Top 3 words\n" + topThreeWord);


        /*Ex-23 Group names by length
        Data: List<String> names = Arrays.asList("Amy","Bob","Chris","Dan","Eve","Frank");
        Task: Map<Integer,List<String>> by name length.*/
        List<String> names3 = Arrays.asList("Amy","Bob","Chris","Dan","Eve","Frank");
        Map<Integer,List<String>> groupByLength=names3.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Exercise 23: Group by length\n" + groupByLength);


       /* EX-24 Employees grouped by dept
        Data:
        record Employee(String name, String dept, double salary) {}
        List<Employee> es = Arrays.asList(
                new Employee("Alice","IT", 90000),
                new Employee("Bob","HR", 65000),
                new Employee("Charlie","IT", 110000),
                new Employee("Dana","Finance", 80000),
                new Employee("Evan","HR", 72000)
        );
        Task: Group names by department: Map<String,List<String>>.*/
        record Employee(String name, String dept, double salary) {}
        List<Employee> es = Arrays.asList(
                new Employee("Alice","IT", 90000),
                new Employee("Bob","HR", 65000),
                new Employee("Charlie","IT", 110000),
                new Employee("Dana","Finance", 80000),
                new Employee("Evan","HR", 72000)
        );
        Map<String,List<String>> empNames=es.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        Collectors.mapping(
                                Employee::name,
                                Collectors.toList())
                ));
        System.out.println("Exercise 24: employees group by dep\n" + empNames);


        /*Ex-25 Top earner per dept
        Data: (reuse es above)
        Task: Map<String, Optional<Employee>> or Map<String,Employee> of max salary by dept.
        Expected: IT→Charlie, HR→Evan, Finance→Dana*/

        Map<String,Optional<Employee>> topEarnerDep=es.stream()
                .collect(Collectors.groupingBy(Employee::dept,
                        Collectors.maxBy(Comparator.comparing(Employee::salary))));
        System.out.println("Exercise 25: top earner per dept\n "+topEarnerDep);

        /*Ex-26 Average salary per dept
        Data: (reuse es)
        Task: Map<String, Double> dept→avg salary.  */

        Map<String,Double> avgSalPerDep=es.stream().
                collect(Collectors.groupingBy(Employee::dept,Collectors.averagingDouble(Employee::salary)));
        System.out.println("Exercise 26: Avg salary per dept\n"+ avgSalPerDep);

        /*Flatten nested lists
        Data:
        List<List<Integer>> nested = Arrays.asList(
         Arrays.asList(1,2),
         Arrays.asList(3,4,5),
         Arrays.asList(6)
        );
        Task: Flatten to [1,2,3,4,5,6].*/
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(3,4,5),
                Arrays.asList(6)
        );

        List<Integer> flatMap=nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Exercise 27: flatMap\n" + flatMap);


        /*Ex-28 Word frequency in a sentence
        Data: String s = "to be or not to be that is the question";
        Task: Map<String,Long> frequency.
        Expected: to=2, be=2, or=1, ...*/


        String s = "to be or not to be that is the question";
        Map<String,Long> wordFreq=Arrays.asList(s.split(" "))
                .stream()
                .collect(
                        Collectors.groupingBy
                                (Object::toString,
                                        Collectors.counting()));
        System.out.println("Exercise 28: wordFreq\n" + wordFreq);

        /*Transactions total by type
        Data
        enum Type { CREDIT, DEBIT }
        record Txn(String id, Type type, double amount) {}
        List<Txn> txns = Arrays.asList(
         new Txn("t1", Type.CREDIT, 120.0),
         new Txn("t2", Type.DEBIT, 45.0),
         new Txn("t3", Type.CREDIT, 80.0),
         new Txn("t4", Type.DEBIT, 20.0)
        );
        Task: Map<Type,Double> totals.
        Expected: CREDIT=200.0, DEBIT=65.0*/
        enum Type { CREDIT, DEBIT }
        record Txn(String id, Type type, double amount) {}
        List<Txn> txns = Arrays.asList(
                new Txn("t1", Type.CREDIT, 120.0),
                new Txn("t2", Type.DEBIT, 45.0),
                new Txn("t3", Type.CREDIT, 80.0),
                new Txn("t4", Type.DEBIT, 20.0)
        );
        Map<Type,Double> typeTotal=txns.stream()
                .collect(Collectors.groupingBy(Txn::type
                ,Collectors.summingDouble(Txn::amount)));
        System.out.println("Exercise 29: typeTotal\n" + typeTotal);


        /* Ex-30
        Concatenate first 2 even-length words
        Data: List<String> words = Arrays.asList("alpha","beta","to","on","gamma");
        Task: First 2 even-length, join.
        Expected: "beta"(4) + "to"(2) → "betato" (if you pick in order)
        * */
        List<String> words6 = Arrays.asList("alpha","beta","to","on","gamma");
        String concatEvenLengthWords=words6.stream().filter(x->x.length()%2==0).limit(2).collect(Collectors.joining());
        System.out.println("Exercise 30: Concat even lengthChars\n"+concatEvenLengthWords);
    }
}