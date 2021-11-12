import java.util.ArrayList;
import java.util.Scanner;

public class LZW implements LZ {
    ArrayList<Integer> N;
    String input;

    public LZW() {
        N = new ArrayList<>();
        input = "";
    }

    public void decompression() {
        ArrayList<String> dictionary = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            dictionary.add(String.valueOf((char) i));
        }
        int length = N.size();
        int k = N.get(0);
        StringBuilder str = new StringBuilder(dictionary.get(k));
        String w = str.toString();
        for (int i = 1; i < length; i++) {
            k = this.N.get(i);
            String tmp;
            if (k >= dictionary.size()) {
                tmp = w + w.charAt(0);
            } else
                tmp = dictionary.get(k);
            str.append(tmp);
            dictionary.add(w + tmp.charAt(0));
            w = tmp;
        }
        System.out.println(str);
    }

    public void compression() {
        ArrayList<String> dictionary = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            dictionary.add(String.valueOf((char) i));
        }
        int length = input.length();
        String T = "";
        for (int i = 0; i < length; i++) {
            char S = input.charAt(i);
            if (dictionary.contains(T + S)) {
                T += S;
            } else {
                addTag(dictionary.indexOf(T));
                dictionary.add(T + S);
                T = String.valueOf(S);
            }
        }
        addTag(dictionary.indexOf(T));
        showTags();
    }

    private void addTag(Integer N) {
        this.N.add(N);
    }

    public void showTags() {
        Integer size = N.size();
        System.out.println(size);

        for (Integer integer : N) {
            System.out.println(integer);
        }
    }

    public void readTags() {
        N.clear();
        System.out.print("input number of tages for LZW decompression: ");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        for (int i = 0; i < size; i++) {
            Integer N = input.nextInt();
            addTag(N);
        }
    }

    public void readInput() {
        System.out.print("input string for LZW compression: ");
        Scanner input = new Scanner(System.in);
        this.input = input.nextLine();
    }

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        LZW LZ = new LZW();
        while (true) {
            System.out.print("""
                                        
                    1. compression
                    2. decompression
                    3. Exist
                    """);
            int val = input.nextInt();
            switch (val) {
                case 1 -> {
                    LZ.readInput();
                    LZ.compression();
                }
                case 2 -> {
                    LZ.readTags();
                    LZ.decompression();
                }
                case 3 -> {
                    return;
                }
                default -> throw new IllegalStateException("Unexpected value: " + val);
            }
        }
    }
}

