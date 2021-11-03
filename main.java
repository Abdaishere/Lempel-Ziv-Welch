import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class main {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.printf("""
                    1. compression
                    2. decompression
                    """);
            int val = input.nextInt();
            switch (val) {
                case 1, 2 -> {
                    int val2 = 0;
                    while (val2 != 4) {
                        System.out.println("""
                                
                                1. LZ 77
                                2. LZ 78
                                3. LZW
                                4. Back
                                """);
                        val2 = input.nextInt();
                        switch (val2) {
                            case 1 -> {
                                if (val == 1)
                                    LZ_77.compression();
                                else
                                    LZ_77.decompression();
                            }
                            case 2 -> {
                                if (val == 1)
                                    LZ_78.compression();
                                else
                                    LZ_78.decompression();
                            }
                            case 3 -> {
                                if (val == 1)
                                    LZW.compression();
                                else
                                    LZW.decompression();
                            }
                            default -> {
                                if (val2 != 4) throw new IllegalStateException("Unexpected value: " + val2);
                            }
                        }
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + val);
            }
        }
    }
}
