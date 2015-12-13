import java.util.Arrays;

public class Permutator {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		permutation(arr, arr.length);
	}

	public static void permutation(int[] list, int size) {
		if(size == 1) {
			System.out.println(Arrays.toString(list));
		} else {
			for(int k = 0 ; k < size ; k++) {
				swap(list, k, size - 1);
				permutation(list, size - 1);
				swap(list, k, size - 1);
			}
		}
	}

	public static int[] swap(int[] listTemp, int index0, int index1) {
		int tmp = listTemp[index0];
		listTemp[index0] = listTemp[index1];
		listTemp[index1] = tmp;
		return listTemp;
	}
}
