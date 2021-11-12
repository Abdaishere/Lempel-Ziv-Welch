import java.util.ArrayList;
import java.util.Scanner;

public class LZ_77 implements LZ{
    ArrayList<Integer> P;
    ArrayList<Integer> L;
    ArrayList<Character> S;
    String input;

    public LZ_77() {
        P = new ArrayList<Integer>();
        L = new ArrayList<Integer>();
        S = new ArrayList<Character>();
        input = new String();
    }

    public void decompression() {
        String tmp = new String();
        for (int i = 0; i < P.size(); i++) {
            if ((P.get(i) == 0 & L.get(i) == 0)) {
                tmp += S.get(i);
            } else {
                int pointerTag = P.get(i);
                int lengthTag = L.get(i);
                Character charTag = S.get(i);
                String substr;
                substr = tmp.substring(tmp.length() - pointerTag, tmp.length() - pointerTag + lengthTag);
                tmp += substr;

                if (charTag != '0') {
                    tmp += charTag;
                }
            }
        }
        System.out.println(tmp);
        input = tmp;
    }

    public void compression() {
        boolean flag;
        String sub_str, sub_str2;
        int startidx;
        for (int i = 0; i < input.length(); ++i) {// i -> start index of sub_str
            startidx = i;
            for (int j = i + 1; j <= input.length(); ++j) {// j -> end index of sub_str
                sub_str = input.substring(i, j);
                flag = false;
                for (int k = i - sub_str.length(); k >= 0; --k) {// k -> start index of sub2
                    sub_str2 = input.substring(k, k + sub_str.length());
                    if (sub_str.equals(sub_str2)) {
                        flag = true;
                        startidx = k;
                        break;
                    }
                }
                if (!flag) {
                    this.addTag(i - startidx, sub_str.length() - 1, input.charAt(i + sub_str.length() - 1));
                    i += sub_str.length() - 1;
                    break;
                } else if (j == input.length()) {
                    this.addTag(i - startidx, sub_str.length(), (char) '0');
                    i += sub_str.length() - 1;
                    break;
                }
            }

        }
        showTags();
    }

    private void addTag(Integer P, Integer L, Character S) {
        this.P.add(P);
        this.L.add(L);
        this.S.add(S);
    }

    public void readTags() {
        P.clear();
        L.clear();
        S.clear();
        System.out.println("tag<P,L,S> = P L S");
        System.out.print("input number of tages for LZ 77 decompression: ");
        Scanner input = new Scanner(System.in);
        Integer size = input.nextInt();
        for (int i = 0; i < size; i++) {
            Integer P = input.nextInt();
            Integer L = input.nextInt();
            Character S = input.next().charAt(0);
            addTag(P, L, S);
        }
    }

    public void showTags() {
        Integer size = P.size();
        System.out.println(size);

        for (int i = 0; i < size; i++) {
            System.out.print(P.get(i) + " ");
            System.out.print(L.get(i) + " ");
            System.out.println(S.get(i));
        }
    }

    public void readInput() {
        System.out.printf("input string for LZ 77 compression: ");
        Scanner input = new Scanner(System.in);
        this.input = input.nextLine();
    }

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        while (true) {
            LZ_77 LZ = new LZ_77();
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
