import java.util.Arrays;

public class Task10 {

    public static void main(String[] args) {
        int[] arr = {15, 10, 0, -6, -5 , 3, 0, -34, 0, 32, 56, 0, 24, -52};
        System.out.println(Arrays.toString(putZerosLast(arr)));
    }

    public static int[] putZerosLast(int[] in) {
        if (in == null) {
            return null;
        }

        int[] out = new int[in.length];
        // элементы нового массива инициализируются нулем, поэтому нужно скопировать только ненулевые элементы
        int outIndex = 0;
        for (int element: in) {
            if (element != 0) {
                out[outIndex] = element;
                outIndex++;
            }
        }
        return out;
    }
}
