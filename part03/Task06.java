package by.jonline.mod02.part03;

/*Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.Делается 
 это следующим образом: сравниваются два соседних элемента ai и ai+1. Если ai <= ai+1, то продвигаются
на один элемент вперед. Если ai > ai+1, то производится перестановка и сдвигаются на один элемент назад.
Составить алгоритм этой сортировки*/
public class Task06 {

	public static void main(String[] args) {

		int[] mas = new int[] { 2, 5, 7, 4, 3, 6, 12, -10, 3, 46, 90, 5, 67, 100, 14, 13, 18, -5 };
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

	public static void sort(int[] mas) {
		if (mas == null) {
			return;
		}

		for (int i = 0; i < mas.length - 1; i++) {

			if (mas.length > 1) {

				if (mas[i] <= mas[i + 1]) {

					continue;

				} else {

					int temp = mas[i];
					mas[i] = mas[i + 1];
					mas[i + 1] = temp;

					if (i >= 1) {
						i = i - 2;
					} else {
						i--;
					}

				}

			}
		}

	}

}
