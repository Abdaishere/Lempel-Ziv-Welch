import java.util.ArrayList;
import java.util.Scanner;

public class LZ_78 implements LZ {
    ArrayList<Integer> N;
    ArrayList<Character> S;
    String input;

    public LZ_78() {
        N = new ArrayList<>();
        S = new ArrayList<>();
        input = "";
    }

    public void decompression() {
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("");
        int length = N.size();
        String tmp = "";
        for (int i = 0; i < length; i++) {
            String dic = dictionary.get(N.get(i));
            char s = S.get(i);
            if (s != '0') {
                dic += s;
            }
            tmp += dic;
            dictionary.add(dic);
        }
        System.out.println(input + ' ' + tmp);
        System.out.println(input.equals(tmp));
        input = tmp;
    }

    public void compression() {
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("");
        int length = input.length();
        String T = "";
        for (int i = 0; i < length; i++) {
            char S = input.charAt(i);
            if (dictionary.contains(T + S)) {
                T += S;
            } else {
                addTag(dictionary.indexOf(T), S);
                dictionary.add(T + S);
                T = "";
            }
        }
        // last element
        if (!T.equals("")) {
            char S = '0';
            if (dictionary.contains(T + S)) {
                T += S;
            } else {
                addTag(dictionary.indexOf(T), S);
                dictionary.add(T + S);
            }
        }
        System.out.println(dictionary);
        showTags();
    }

    private void addTag(Integer N, Character S) {
        this.N.add(N);
        this.S.add(S);
    }

    public void showTags() {
        Integer size = N.size();
        System.out.println(size);

        for (int i = 0; i < size; i++) {
            System.out.print(N.get(i) + " ");
            System.out.println(S.get(i));
        }
    }

    public void readTags() {
        N.clear();
        S.clear();
        System.out.printf("input number of tages for LZ 78 decompression: ");
        Scanner input = new Scanner(System.in);
        Integer size = input.nextInt();
        for (int i = 0; i < size; i++) {
            Integer N = input.nextInt();
            Character S = input.next().charAt(0);
            addTag(N, S);
        }
    }

    public void readInput() {
        System.out.printf("input string for LZ 78 compression: ");
        Scanner input = new Scanner(System.in);
        this.input = input.nextLine();
    }

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        LZ_78 LZ = new LZ_78();
        while (true) {
            System.out.printf("""
                                        
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
