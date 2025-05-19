import word_occurrences.WordOccurrences;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class BasicTester {

    public static void main(String[] args) throws IOException {
        test1();
        test2();
    }

    public static void test1() throws IOException {

        System.out.println("Running test1");

        // You may have to change the file path to get it to work on your computer
        WordOccurrences occ = new WordOccurrences(new File("tests//wisdom.txt"));
        System.out.println(occ);
        System.out.println("distinct words: " + occ.distinctWords());
        System.out.println("total occurrences: " + occ.totalOccurrences());
        System.out.println();
    }

    public static void test2() throws IOException {

        System.out.println("------------------");
        System.out.println("Running test2");

        // You may have to change the file path to get it to work on your computer
        WordOccurrences occ = new WordOccurrences(new File("tests"));

        System.out.println("distinct words: " + occ.distinctWords());
        System.out.println("total occurrences: " + occ.totalOccurrences());
        System.out.println("total occurrences of love: " + occ.totalOccurrencesOfWord("love"));
        System.out.println("total occurrences of ob-la-di: " + occ.totalOccurrencesOfWord("ob-la-di"));
        System.out.println("total occurrences of detest: " + occ.totalOccurrencesOfWord("detest"));

        System.out.println("total occurrences of that's in Money.txt: "
                + occ.totalOccurrencesOfWordInFile("that's", "test_dir\\Music\\Beatles\\Money.txt"));

        System.out.println("total occurrences of ob-la-di in Money.txt: "
                + occ.totalOccurrencesOfWordInFile("ob-la-di", "test_dir\\Music\\Beatles\\Money.txt"));

        System.out.println("total occurrences of the in Funny.txt: "
                + occ.totalOccurrencesOfWordInFile("the", "test_dir\\Music\\Beatles\\Funny.txt"));

        System.out.print(occ);
        File outFile = new File("output.txt");
        PrintWriter writer = new PrintWriter(new FileOutputStream(outFile));
        writer.write(occ.toString());
    }

}
