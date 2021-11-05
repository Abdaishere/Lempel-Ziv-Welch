import java.util.ArrayList;
import java.util.Scanner;

public class LZ_78 implements LZ {
    ArrayList<Integer> N;
    ArrayList<Character> S;
    String input;

    public LZ_78() {
        N = new ArrayList<Integer>();
        S = new ArrayList<Character>();
        input = new String();
    }

    public void decompression() {
        /// write code here
        System.out.printf("LZ_78 decomp");
    }

    public void compression() {
        /// write code here
        System.out.printf("LZ_78 comp");
    }

    private void addTag(Integer N, Character S) {
        this.N.add(N);
        this.S.add(S);
    }

    public void showTags() {

    }

    public void readTags() {
        System.out.printf("input number of tages for LZ 78 decompression: ");
        Scanner input = new Scanner(System.in);
        Integer size = input.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.print("N = ");
            Integer N = input.nextInt();
            System.out.print("S = ");
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
        while (true) {
            LZ_78 LZ = new LZ_78();
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
                case 3 -> {return;}
                default -> throw new IllegalStateException("Unexpected value: " + val);
            }

        }
    }
}
