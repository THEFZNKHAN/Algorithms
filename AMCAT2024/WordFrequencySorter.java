import java.util.*;

public class WordFrequencySorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        scanner.close();
        String[] result = sortWordsByFrequency(input);
        System.out.println(Arrays.toString(result));
    }

    public static String[] sortWordsByFrequency(String input) {
        String[] words = input.trim().split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list by frequency (descending) and then lexicographically (ascending)
        entries.sort((entry1, entry2) -> {
            int freqCompare = Integer.compare(entry2.getValue(), entry1.getValue());
            if (freqCompare == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return freqCompare;
        });

        // Extract the sorted words into an array
        String[] sortedWords = new String[entries.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            sortedWords[index++] = entry.getKey();
        }

        return sortedWords;
    }
}
