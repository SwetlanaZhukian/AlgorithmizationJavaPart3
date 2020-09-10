package by.jonline.mod02.part03;

/*2. Даны две последовательности a1 <=a2 <= ....an и b1 <=b2 <=.... bm.Образовать из них новую последовательность
чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.*/
public class Task02 {

	public static void main(String[] args) {

		int[] mas1 = new int[] { -10, -5, -4, -1, 0, 5, 10, 100 };
		int[] mas2 = new int[] { -20, 1, 3, 5, 7, 9, 10, 50, 60, 100, 200, 300 };
		int[] mas3 = new int[mas1.length + mas2.length];

		System.out.println("Первая последовательность");
		printArray(mas1);

		System.out.println("Вторая последовательность");
		printArray(mas2);

		System.out.println("Новая последовательность");
		combine(mas1, mas2, mas3);
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

	public static void combine(int[] mas1, int mas2[], int[] mas3) {
		if (mas1 == null || mas2 == null || mas3 == null) {
			return;
		}

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < mas1.length && j < mas2.length) {
			if (mas1[i] <= mas2[j]) {
				mas3[k] = mas1[i];
				i++;

			} else {
				mas3[k] = mas2[j];
				j++;

			}

			k++;

		}

		if (i >= mas1.length) {

			for (int n = k; n < mas3.length; n++) {
				mas3[n] = mas2[j];
				j++;
			}

		} else if (j >= mas2.length) {

			for (int n = k; n < mas3.length; n++) {
				mas3[n] = mas1[i];
				i++;
			}
		}

	}

}
