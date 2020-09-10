package by.jonline.mod02.part03;

/*Даны дроби p1/q1, p2/q2, ... pn/qn,( pi qi  - натуральные). Составить программу, которая приводит эти дроби
 к общему знаменателю и упорядочивает их в порядке возрастания.*/
public class Task08 {

	public static void main(String[] args) {

		Fraction[] fr = new Fraction[] { new Fraction(-3, 9), new Fraction(1, 2), new Fraction(3, 16),
				new Fraction(7, 10), new Fraction(5, 8) };

		int lcm = 0;

		for (int i = 0; i < fr.length; i++) {
			if (fr[i] == null) {
				continue;
			}

			lcm = fr[i].denominator;
			break;

		}

		for (int i = 0; i < fr.length; i++) {
			if (fr[i] == null) {
				continue;
			}

			lcm = findLeastCommonMultiple(lcm, fr[i].denominator);
		}

		System.out.println("Общий знаменатель = " + lcm);

		reduceToCommonDenominator(fr, lcm);
		sort(fr);
		printArray(fr);

	}

	public static int findGreatestCommonDivisor(int a, int b) {

		int gcd = 0;

		if (a == b) {
			return a;
		}

		while (a != 0 && b != 0) {

			if (a > b) {

				a = a % b;

			} else {

				b = b % a;
			}
		}

		if (a == 0) {
			gcd = b;
		}
		if (b == 0) {
			gcd = a;
		}

		return gcd;
	}

	public static int findLeastCommonMultiple(int a, int b) {
		int lcm;

		lcm = a / findGreatestCommonDivisor(a, b) * b;

		return lcm;

	}

	public static void reduceToCommonDenominator(Fraction[] mas, int lcm) {
		if (mas == null) {
			return;
		}

		for (int i = 0; i < mas.length; i++) {
			if (mas[i] == null) {
				continue;
			}

			int number = lcm / mas[i].denominator;

			mas[i].numerator = mas[i].numerator * number;
			mas[i].denominator = mas[i].denominator * number;

		}

	}

	public static void printArray(Fraction[] mas) {
		if (mas == null) {
			return;
		}
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] == null) {
				continue;
			}

			System.out.print(mas[i].numerator + "/" + mas[i].denominator + "  ");

		}
		System.out.println();

	}

	public static void sort(Fraction[] mas) {
		if (mas == null) {
			return;
		}
		int max;
		Fraction temp;

		for (int i = 0; i < mas.length; i++) {
			if (mas[i] == null) {
				continue;
			}

			max = i;

			for (int j = i + 1; j < mas.length; j++) {
				if (mas[j] == null) {
					continue;
				}
				if (mas[max].numerator > mas[j].numerator) {
					max = j;

				}

			}

			temp = mas[i];
			mas[i] = mas[max];
			mas[max] = temp;

		}

	}

}

class Fraction {

	public int numerator;
	public int denominator;

	public Fraction(int num, int den) {
		numerator = num;

		if (den == 0) {
			denominator = 1;
		} else {
			denominator = den;
		}
	}
}
