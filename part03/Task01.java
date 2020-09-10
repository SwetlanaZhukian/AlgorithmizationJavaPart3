package by.jonline.mod02.part03;

import java.util.Random;
import java.util.Scanner;

/*Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
дополнительный массив.*/
public class Task01 {

	public static void main(String[] args) {
		int n;
		int m;
		int k;
		int[] mas1;
		int[] mas2;
		int[] mas3;

		n = enterFromConsole("Введите количество элементов первого массива >> ");
		while (n < 2) {
			n = enterFromConsole("Введите количество элементов первого массива >> ");
		}

		m = enterFromConsole("Введите количество элементов второго массива >> ");

		mas1 = new int[n];
		mas2 = new int[m];
		mas3 = new int[n + m];

		initArray(mas1);
		System.out.println("Первый массив");
		printArray(mas1);

		initArray(mas2);
		System.out.println("Второй массив");
		printArray(mas2);

		k = enterFromConsole("Введите номер элемента первого массива >> ");
		if (k >= n - 1) {
			k = enterFromConsole("Введите номер элемента первого массива >> ");
		}

		combine(mas1, mas2, mas3, k);
		System.out.println("Объединённый массив");
		printArray(mas3);

	}

	public static int enterFromConsole(String str) {
		int value;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print(str);

			while (!sc.hasNextInt()) {
				sc.next();
				System.out.print(str);

			}

			value = sc.nextInt();

		} while (value < 0 || value > 20);

		return value;

	}

	public static void initArray(int[] mas) {
		if (mas == null) {
			return;
		}
		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			mas[i] = rand.nextInt(20);
		}

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

	public static void combine(int[] mas1, int mas2[], int[] mas3, int k) {
		if (mas1 == null || mas2 == null || mas3 == null) {
			return;
		}

		int j = 0;

		for (int i = 0; i < k + 1; i++) {
			mas3[i] = mas1[i];

		}
		for (int i = k + 1; i < k + 1 + mas2.length; i++) {
			mas3[i] = mas2[j];
			j++;

		}

		for (int i = k + 1 + mas2.length; i < mas3.length; i++) {
			mas3[i] = mas1[k + 1];
			k++;

		}

	}

}
