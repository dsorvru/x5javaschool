import java.util.Arrays;

public class Task9 {

    public static void main(String[] args) {
        int[] arr = {15, 10, 51, -6, -5, 3, -10, -34, 0, 32, 56, -12, 24, -52};
        System.out.println(Arrays.toString(reverse(arr)));
    }

    public static int[] reverse(int[] in) {
        if (in == null) {
            return null;
        }

        int[] out = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            out[i] = in[in.length - 1 - i];
        }
        return out;
    }
}
