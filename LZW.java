import java.util.ArrayList;
import java.util.Scanner;

public class LZW implements LZ {
    ArrayList<Integer> N;
    String input;

    public LZW() {
        N = new ArrayList<Integer>();
        input = new String();
    }

    public void decompression() {
        /// write code here
        System.out.printf("LZW decomp");
    }

    public void compression() {
        /// write code here
        System.out.printf("LZW comp");
    }

    private void addTag(Integer N) {
        this.N.add(N);
    }

    public void showTags(){

    }

    public void readTags() {
        System.out.printf("input number of tages for LZW decompression: ");
        Scanner input = new Scanner(System.in);
        Integer size = input.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.print("N = ");
            Integer N = input.nextInt();
            addTag(N);
        }
    }

    public void readInput() {
        System.out.printf("input string for LZW compression: ");
        Scanner input = new Scanner(System.in);
        this.input = input.nextLine();
    }

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        while (true) {
            LZW LZ = new LZW();
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

