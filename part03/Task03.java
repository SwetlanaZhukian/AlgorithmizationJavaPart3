package by.jonline.mod02.part03;

/*Сортировка выбором. Дана последовательность чисел a1 <= a2 <= ...<= an.Требуется переставить элементы так,
чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
повторяется. Написать алгоритм сортировки выбором.*/
public class Task03 {

	public static void main(String[] args) {

		int[] mas = new int[] { 1, 2, 3, 4, 6, 7, 9, 10, 30, 50 };
		sortArray(mas);
		printArray(mas);
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

	public static void sortArray(int[] mas) {
		if (mas == null) {
			return;

		}

		int max;

		for (int i = 0; i < mas.length; i++) {

			max = i;

			for (int j = i + 1; j < mas.length; j++) {
				if (mas[max] < mas[j]) {
					max = j;
				}
			}

			int temp = mas[max];
			mas[max] = mas[i];
			mas[i] = temp;

		}

	}

}
