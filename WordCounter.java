import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        try {
            // Step 1: Prompt the user for input
            System.out.println("Enter a text or provide a file to count words:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String input = reader.readLine();

            // If the user enters a file name, read the file content
            if (input.endsWith(".txt")) {
                input = readFile(input);
            }

            // Step 3: Split the string into an array of words
            String[] words = input.split("[\\s\\p{Punct}]+");

            // Step 4: Initialize a counter variable
            int wordCount = 0;

            // Step 6: Count words
            Map<String, Integer> wordFrequency = new HashMap<>();
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount++;
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            // Step 7: Ignore common words (e.g., "the", "and", "is")
            // Add your list of common words to ignore here

            // Step 5: Display the total count of words
            System.out.println("Total word count: " + wordCount);

            // Step 8: Display statistics like the number of unique words and word frequency
            System.out.println("Number of unique words: " + wordFrequency.size());

            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the input or file.");
        }
    }

    // Utility function to read the content of a file
    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = fileReader.readLine()) != null) {
            content.append(line).append("\n");
        }

        fileReader.close();
        return content.toString();
    }
}
