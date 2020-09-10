package by.jonline.mod02.part03;

/* Пусть даны две неубывающие последовательности действительных чисел a1 <= a2<=...<= an и b1<=b2 <=... <=bm.
Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2<= ... <= bm в первую
последовательность так, чтобы новая последовательность оставалась возрастающей.*/

public class Task07 {

	public static void main(String[] args) {
		int[] mas1 = new int[] { -1, 0, 2, 3, 4, 5, 6, 7, 8, 60, 100 };
		int[] mas2 = new int[] { -4, 6, 10, 11, 50, 70, 90 };

		int[] mas3 = new int[mas1.length + mas2.length];
		for (int i = 0; i < mas1.length; i++) {
			mas3[i] = mas1[i];

		}

		System.out.println("Первая последовательность");
		printArray(mas1);

		System.out.println("Вторая последовательность");
		printArray(mas2);

		combine(mas1, mas2, mas3);
		System.out.println("Новая последовательность");
		printArray(mas3);

	}

	public static void printArray(int[] mas) {
		if (mas == null) {
			return;
		}

		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");

		}

		System.out.println();

	}

	public static int search(int[] mas, int index, int element) {
		if (mas == null) {
			return 0;
		}

		int firstIndex = 0;
		int lastIndex = index;

		while (firstIndex < lastIndex) {
			int mid = (firstIndex + lastIndex) / 2;
			if (mas[mid] == element) {
				return mid;
			} else if (mas[mid] < element) {
				firstIndex = mid + 1;
			} else if (mas[mid] > element) {
				lastIndex = mid - 1;
			}
			if (lastIndex == firstIndex) {
				break;
			}
		}

		if (mas[firstIndex] < element && mas.length > 1) {

			return firstIndex + 1;

		} else {

			return firstIndex;
		}

	}

	public static void combine(int[] mas1, int[] mas2, int[] mas3) {
		if (mas2 == null || mas3 == null) {
			return;
		}

		int index = 0;

		for (int i = 0; i < mas3.length; i++) {
			if (mas1.length > 1 && mas3.length > mas1.length) {
				if (mas3[i] > mas3[i + 1]) {
					index = i;
					break;
				}
			}

		}

		for (int i = 0; i < mas2.length; i++) {

			int j = search(mas3, index, mas2[i]);

			System.out.println(i + " элемент второй последовательности нужно вставить на " + j
					+ " место новой последовательности ");

			for (int j2 = index + 1; j2 > j && j2 < mas3.length; j2--) {

				mas3[j2] = mas3[j2 - 1];

			}

			mas3[j] = mas2[i];

			index++;

		}

	}

}
