import java.util.Arrays;

public class Permutator {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        permutation(arr, arr.length);
    }

    public static void permutation(int[] list, int size) {
        if (size < list.length - 1 || list.length == 1) {
            System.out.println(Arrays.toString(list));
        } else {
            for (int k = 0; k < size; k++) {
                int[] arr = swap(list, k, size-1);
                permutation(arr, size - 1);
            }
        }
    }

    public static int[] swap(int[] list, int index0, int index1) {
        int tmp = list[index0];
        list[index0] = list[index1];
        list[index1] = tmp;
        return list;
    }

}
