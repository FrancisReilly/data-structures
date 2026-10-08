
import java.util.Scanner;

public class WordSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of words, then one word per line:");
        int n = Integer.parseInt(scanner.nextLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        bubbleSort(words);

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(words[i]);
        }
        System.out.println();
    }

    public static void bubbleSort(String[] words) {
        int n = words.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (words[j].length() > words[j + 1].length()) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                } else if (words[j].length() == words[j + 1].length()) {
                    for (int k = 0; k < words[j].length(); k++) {
                        if (words[j].charAt(k) > words[j + 1].charAt(k)) {
                            String temp = words[j];
                            words[j] = words[j + 1];
                            words[j + 1] = temp;
                            break;
                        } else if (words[j].charAt(k) < words[j + 1].charAt(k)) {
                            break;
                        }
                    }
                }
            }
        }
    }

}
