import java.util.ArrayList;
import java.util.Scanner;

public class LZ_77 implements LZ {
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
        /// write code here
        System.out.printf("LZ_77 decomp");
    }

    public void compression() {
        /// write code here
        System.out.printf("LZ_77 comp");
    }

    private void addTag(Integer P, Integer L, Character S) {
        this.P.add(P);
        this.L.add(L);
        this.S.add(S);
    }

    public void readTags() {
        System.out.printf("input number of tages for LZ 77 decompression: ");
        Scanner input = new Scanner(System.in);
        Integer size = input.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.print("P = ");
            Integer P = input.nextInt();
            System.out.print("L = ");
            Integer L = input.nextInt();
            System.out.print("S = ");
            Character S = input.next().charAt(0);
            addTag(P, L, S);
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
                default -> throw new IllegalStateException("Unexpected value: " + val);
            }

        }
    }
}
