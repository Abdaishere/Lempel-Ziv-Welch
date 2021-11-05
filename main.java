import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class main {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("""
                                                    
                    1. LZ 77
                    2. LZ 78
                    3. LZW
                   
                    """);
            int val = input.nextInt();
            switch (val){
                case 1-> LZ_77.main(new String[]{});
                case 2-> LZ_78.main(new String[]{});
                case 3-> LZW.main(new String[]{});
                default -> throw new IllegalStateException("Unexpected value: " + val);
            }
        }
    }
}
