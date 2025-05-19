
package word_occurrences;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordOccurrences {

    // Maps words -> filename -> sets of their Positions in the file.
    private final TreeMap<String, TreeMap<String, TreeSet<FilePosition>>> occMap;

    /**
     * Create a new object that stores word occurrence information of
     * the contents of all files at or below the given document or directory
     * in the file hierarchy.
     *
     * @param docOrRootDir the single file to be read, or the root directory
     *                     containing the (sub)files to be read
     * @throws IOException if there is a problem accessing the given files
     */
    public WordOccurrences(File docOrRootDir) throws IOException {
        occMap = new TreeMap<>();
        buildMap(docOrRootDir);
    }

    /**
     * Helper method that adds the occurrence information to the occurrence
     * map for the given file if it is a text document, or for all subfiles
     * below if it is a directory.  This method should not access the occMap
     * map directly, but rather, it should make use of the addMapEntry method
     * to manage the occMap
     *
     * @param docOrDir the single file to be read, or the root directory
     *                 containing the (sub)files to be read
     * @throws IOException if there is a problem accessing the given files
     */
    private void buildMap(File docOrDir) throws IOException {
        if(docOrDir.isFile()){
            try(BufferedReader buffer = new BufferedReader(new FileReader(docOrDir))){
                int character;
                int row = 1;
                int column = 0;
                String path = docOrDir.getAbsolutePath();
                do{
                    StringBuilder string = new StringBuilder();
                    int columnOfWOrd = 0;
                    do{
                        character = buffer.read();
                        column++;
                        if(Syntax.isInWord((char)character)){
                            string.append((char)character);
                            columnOfWOrd++;
                        }
                    }
                    while(Syntax.isInWord((char)character));
                    if(!Syntax.isNewLine((char)character) && string.length() != 0){
                        addMapEntry(string.toString(), path, new FilePosition(row, column-columnOfWOrd));
                    }
                    if(Syntax.isNewLine((char)character)){
                        row++;
                        column = 0;
                    }
                }
                while(character != -1);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            File[] files = docOrDir.listFiles();
            for(File file : files){
                buildMap(file);
            }
        }
        // TODO: Implement me!!!
    }


    /**
     * Helper method for buildMap, which records the occurrence of the
     * given word, in the given file, at the given position in occMap.
     * Note that because occMap is a two-level map.... i.e., it is a map
     * whose values are also maps, new maps may need to be added as values
     * to the occMap whenever a new word is encountered while the input
     * files are being read
     *
     * @param word the word whose occurrence should be recorded
     * @param filePath the path of the file in which the current word
     *                 occurrence is located
     * @param pos the position of the word in the given file
     */
    private void addMapEntry(String word, String filePath, FilePosition pos) {
        word = word.toLowerCase();
        if(totalOccurrencesOfWord(word) == 0){
            TreeSet<FilePosition> tempSet = new TreeSet<>();
            tempSet.add(pos);
            TreeMap<String, TreeSet<FilePosition>> tempMap = new TreeMap<>();
            tempMap.put(filePath,tempSet);
            occMap.put(word,tempMap);
        }
        else{
            TreeMap<String, TreeSet<FilePosition>> existingMap = occMap.get(word);
            TreeSet<FilePosition> existingPos = existingMap.get(filePath);
            if(existingPos != null){
                existingPos.add(pos);
            }
            else{
                TreeSet<FilePosition> tempSet = new TreeSet<>();
                tempSet.add(pos);
                existingMap.put(filePath, tempSet);
            }
        }
        // TODO: Implement me!!!
    }


    /**
     * @return the number of distinct words found in the files
     */
    public int distinctWords() {
        int words = 0;
        for(Map.Entry<String, TreeMap<String, TreeSet<FilePosition>>> traverseMap : occMap.entrySet()){
            words++;
        }
        // TODO: Implement me!!!
        return words;
    }

    /**
     * @return the number of total word occurrences across all files
     */
    public int totalOccurrences() {
        int words = 0;
        for(Map.Entry<String, TreeMap<String, TreeSet<FilePosition>>> traverseMap : occMap.entrySet()){
            TreeMap<String, TreeSet<FilePosition>> traverseMapMap = traverseMap.getValue();
            for(TreeSet<FilePosition> position : traverseMapMap.values()) {
                words += position.size();
            }
        }
        // TODO: Implement me!!!
        return words;
    }

    /**
     * Finds the total number of occurrences of a given word across
     * all files.  If the word is not found among the occurrences,
     * simply return 0.
     *
     * @param word whose occurrences we are counting
     * @return the number of occurrences
     */
    public int totalOccurrencesOfWord(String word) {
        int words = 0;
            TreeMap<String, TreeSet<FilePosition>> existingMap = occMap.get(word);
            if (existingMap != null) {
            Set<Map.Entry<String, TreeSet<FilePosition>>> entries = existingMap.entrySet();
            for (Map.Entry<String, TreeSet<FilePosition>> entry : entries) {
                TreeSet<FilePosition> positions = entry.getValue();
                words += positions.size();
            }
        }
        // TODO: Implement me!!!
        return words;
    }

    /**
     * Finds the total number of occurrences of a given word in the given file.
     * If the file is not found in Occurrences, or if the word does not occur
     * in the file, simply return 0.
     *
     * @param word whose occurrences we are counting
     * @param filepath of the file
     * @return the number of occurrences
     */
    public int totalOccurrencesOfWordInFile(String word, String filepath) {
        int words = 0;
        TreeMap<String, TreeSet<FilePosition>> pathOfWord = occMap.get(word);
        if(pathOfWord != null){ 
            TreeSet<FilePosition> posInPath  = pathOfWord.get(filepath);
            if(posInPath !=null){
                words = posInPath.size();
            }
        }
        // TODO: Implement me!!!
        return words;
    }

    /**
     *
     * @return a string representation of the contents of the occurrence map
     */
    public String toString() {
        StringBuilder text = new StringBuilder();
        for(Map.Entry<String, TreeMap<String, TreeSet<FilePosition>>> traverseMap : occMap.entrySet()){
            String word = traverseMap.getKey();
            text.append("\"" + word + "\"" + " has " + totalOccurrencesOfWord(word) + " occurrence(s):\n");
            TreeMap<String, TreeSet<FilePosition>> value = traverseMap.getValue();
            for(Map.Entry<String, TreeSet<FilePosition>> fileEntry : value.entrySet()){
                String path = fileEntry.getKey();
                TreeSet<FilePosition> posTree = fileEntry.getValue(); 
                    for(FilePosition pos : posTree){
                        text.append("   ( file: \"" + path + "\"; " + pos.toString() + " )"+"\n");
                    }
            }
        }
        // TODO: Implement me!!!
        return text.toString();
    }
}


