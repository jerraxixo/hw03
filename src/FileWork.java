import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileWork {
    private static boolean notAWord (char c) {
        return ((c >= 32 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96));
    }
    private static int countWords (String[] words) {
        int countedWords = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!notAWord(words[i].charAt(j))) {
                    countedWords++;
                    break;
                }
            }
        }
        return countedWords;
    }
    private static String[] splitStrings (String s) {
        String[] words = s.split(" ");
        return words;
    }
    private static String readFile (File file) throws NullPointerException {
        try {
            Scanner fileScanner = new Scanner(file, "Windows-1251");
            StringBuilder contentOfFile = new StringBuilder();
            while (fileScanner.hasNextLine()) {
                contentOfFile.append(fileScanner.nextLine() + " ");
            }
            return contentOfFile.toString();
        } catch (NullPointerException e) {
            System.out.print("\nПустой файл");
        } catch (FileNotFoundException a) {
            System.out.print("\nФайл не найден");
        }
        return null;
    }
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите путь к файлу:");
        String pathName = in.next();
        File currentFile = new File(pathName);
        if (readFile(currentFile) != null) {
            System.out.print("\nКоличество слов: " + countWords(splitStrings(readFile(currentFile))));
        }
    }
}
