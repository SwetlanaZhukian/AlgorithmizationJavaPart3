package by.jonline.mod02.part03;

/*Сортировка обменами. Дана последовательность чисел a1 <= a2<= ...<= an.Требуется переставить числа в
порядке возрастания. Для этого сравниваются два соседних числа a(i) и  a (i+1). Если ai > ai+1, то делается
перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
Составить алгоритм сортировки, подсчитывая при этом количества перестановок.*/
public class Task04 {

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

		int count = 0;
		boolean b = true;
		int temp;

		while (b) {

			b = false;

			for (int i = 0; i < mas.length - 1; i++) {

				if (mas[i] < mas[i + 1]) {
					temp = mas[i];
					mas[i] = mas[i + 1];
					mas[i + 1] = temp;
					count++;
					b = true;
				}

			}
		}

		System.out.println("Количество перестановок " + count);
	}

}
