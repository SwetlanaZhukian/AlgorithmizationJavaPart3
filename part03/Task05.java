package by.jonline.mod02.part03;

/*Сортировка вставками. Дана последовательность чисел   a1 ,a2 ,... ,an. Требуется переставить числа в порядке
возрастания. Делается это следующим образом. Пусть a1, a2, ai - упорядоченная последовательность, т. е.
a1 <= a2 <=... <= an. Берется следующее число a (i +1)и вставляется в последовательность так, чтобы новая
последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.*/
public class Task05 {

	public static void main(String[] args) {
		int[] mas = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 0, -9, 4, 56, 19, 45, 10, 346, 12 };

		System.out.println("Исходный массив");
		printArray(mas);

		sort(mas);
		System.out.println("Отсортированный массив");
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

	public static int search(int[] mas, int index, int element) {
		if (mas == null) {
			return 0;
		}

		int firstIndex = 0;
		int lastIndex = index;

		while (firstIndex < lastIndex) {
			int middleIndex = (lastIndex + firstIndex) / 2;

			if (mas[middleIndex] < element) {
				firstIndex = middleIndex + 1;

			} else if (mas[middleIndex] > element) {
				lastIndex = middleIndex - 1;

			} else if (mas[middleIndex] == element) {
				return middleIndex;

			}
			if (lastIndex == firstIndex) {
				break;
			}

		}

		if (mas[firstIndex] < element) {
			return firstIndex + 1;
		} else {
			return firstIndex;
		}
	}

	public static void sort(int[] mas) {
		if (mas == null) {
			return;
		}

		int index = 0;

		for (int i = 0; i < mas.length; i++) {

			if (i + 1 < mas.length) {

				if (mas[i] > mas[i + 1]) {
					index = i;
					break;
				}

			} else {

				break;
			}

		}

		int j;

		for (int i = index + 1; i < mas.length; i++) {

			if (mas[i] < mas[index]) {

				int temp = mas[i];

				j = search(mas, index, temp);

				for (int k = index + 1; k > j; k--) {

					mas[k] = mas[k - 1];
				}

				mas[j] = temp;
			}

			index++;

		}

	}

}
