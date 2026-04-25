import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class SpellChecker {

    public void spellCheckerTest() throws IOException {
        StopWatch stopWatch = new StopWatch();
        int wordCount = 0;

        // Extra Credit: Sets to store mismatched words
        Set<String> wordNotFoundHS = new HashSet<>();
        Set<String> wordNotFoundTS = new TreeSet<>();


         //ArrayList Test Case

        System.out.println("Starting Test for words not found in dictionary using ArrayList...");
        stopWatch.start();

        List<String> dictionaryWordsAL = readWordsArrayList("./resources/words");
        List<String> documentWordsAL = readWordsArrayList("./resources/war-and-peace.txt");

        for (String word : documentWordsAL) {
            if (!dictionaryWordsAL.contains(word)) {
                wordCount++;
            }
        }

        stopWatch.stop();
        System.out.println("Word not found count: " + wordCount + ", words in document using ArrayList: " + documentWordsAL.size());
        System.out.println("Words read from dictionary using ArrayList: " + dictionaryWordsAL.size());
        System.out.println("Elapsed Time ArrayList: " + stopWatch.getElapsedTime() + " ms\n");

        stopWatch.reset();
        wordCount = 0;


         //2. HashSet Test Case
        System.out.println("Starting Test for words not found in dictionary using HashSet...");
        stopWatch.start();

        Set<String> dictionaryWordsHS = readWordsHashSet("./resources/words");
        Set<String> documentWordsHS = readWordsHashSet("./resources/war-and-peace.txt");

        for (String word : documentWordsHS) {
            if (!dictionaryWordsHS.contains(word)) {
                wordCount++;
                wordNotFoundHS.add(word); // Extra Credit tracking
            }
        }

        stopWatch.stop();
        System.out.println("Word not found count: " + wordCount + ", words in document using HashSet: " + documentWordsHS.size());
        System.out.println("Words in dictionary read using HashSet: " + dictionaryWordsHS.size());
        System.out.println("Elapsed Time HashSet: " + stopWatch.getElapsedTime() + " ms\n");

        stopWatch.reset();
        wordCount = 0;


         //3. LinkedHashSet Test Case

        System.out.println("Starting Test for words not found in dictionary using LinkedHashSet...");
        stopWatch.start();

        Set<String> dictionaryWordsLHS = readWordsLinkedHashSet("./resources/words");
        Set<String> documentWordsLHS = readWordsLinkedHashSet("./resources/war-and-peace.txt");

        for (String word : documentWordsLHS) {
            if (!dictionaryWordsLHS.contains(word)) {
                wordCount++;
            }
        }

        stopWatch.stop();
        System.out.println("Word not found count: " + wordCount + ", words in document using LinkedHashSet: " + documentWordsLHS.size());
        System.out.println("Words in dictionary read using LinkedHashSet: " + dictionaryWordsLHS.size());
        System.out.println("Elapsed Time LinkedHashSet: " + stopWatch.getElapsedTime() + " ms\n");

        stopWatch.reset();
        wordCount = 0;


         //4. TreeSet Test Case

        System.out.println("Starting Test for words not found in dictionary using TreeSet...");
        stopWatch.start();

        Set<String> dictionaryWordsTS = readWordsTreeSet("./resources/words");
        Set<String> documentWordsTS = readWordsTreeSet("./resources/war-and-peace.txt");

        for (String word : documentWordsTS) {
            if (!dictionaryWordsTS.contains(word)) {
                wordCount++;
                wordNotFoundTS.add(word); // Extra Credit tracking
            }
        }

        stopWatch.stop();
        System.out.println("Word not found count: " + wordCount + ", words in document using TreeSet: " + documentWordsTS.size());
        System.out.println("Words in dictionary read using TreeSet: " + dictionaryWordsTS.size());
        System.out.println("Elapsed Time TreeSet: " + stopWatch.getElapsedTime() + " ms\n");


         //Extra Credit: Write Log Files
        writeMismatchedWordsToLog(wordNotFoundHS, "./resources/HashsetMismatch.txt");
        writeMismatchedWordsToLog(wordNotFoundTS, "./resources/TreeSetMismatch.txt");
        System.out.println("Extra credit log files successfully written to the resources folder.");
    }

    public static void main(String[] args) throws IOException {
        SpellChecker spellCheck = new SpellChecker();
        spellCheck.spellCheckerTest();
    }

    public List<String> readWordsArrayList(String filename) throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        in.close();
        return words;
    }

    public Set<String> readWordsHashSet(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        in.close();
        return words;
    }

    public Set<String> readWordsLinkedHashSet(String filename) throws FileNotFoundException {
        Set<String> words = new LinkedHashSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        in.close();
        return words;
    }

    public Set<String> readWordsTreeSet(String filename) throws FileNotFoundException {
        Set<String> words = new TreeSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        in.close();
        return words;
    }

    public void writeMismatchedWordsToLog(Set<String> setName, String filePath) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        for (String word : setName) {
            bufferedWriter.write(word + "\n");
        }
        bufferedWriter.close();
    }
}