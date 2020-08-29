package ru.epam.jonline.module3.string_as_array;

public class Tasks {

//	Дан массив названий переменных в camelCase. Преобразовать названия в snake_case

	public static void firstTask(String[] arrStrings) {
		System.out.printf("%nAnswer firstTask: %n");

		printStringArray(arrStrings);

		int countCapitalLetter;

		for (int i = 0; i < arrStrings.length; i++) {

			countCapitalLetter = countCapitalLetter(arrStrings[i]);

			char[] chArr = arrStrings[i].toCharArray();

			chArr = increaseSizeCharArray(chArr, countCapitalLetter);

			for (int j = 0; j < chArr.length; j++) {
				if (chArr[j] >= 65 && chArr[j] <= 90) {
					shiftElemsInArray(chArr, j + 1, 1);
					chArr[j + 1] = (char) (chArr[j + 1] + 32);
					chArr[j] = 95;
				}
			}
			arrStrings[i] = new String(chArr);
		}

		printStringArray(arrStrings);
	}

//	Замените в строке все вхождения 'word' на 'letter'

	public static void secondTask(String str) {
		System.out.printf("%nAnswer secondTask: %n");
		System.out.println(str);

		char[] chArr = str.toCharArray();

		for (int i = 0; i < chArr.length; i++) {
			if (chArr[i] == 119 && chArr[i + 1] == 111 && chArr[i + 2] == 114 && chArr[i + 3] == 100) {

				chArr = increaseSizeCharArray(chArr, 2);
				shiftElemsInArray(chArr, i + 1, 2);

				chArr[i] = 108;
				chArr[i + 1] = 101;
				chArr[i + 2] = 116;
				chArr[i + 3] = 116;
				chArr[i + 4] = 101;
				chArr[i + 5] = 114;
			}
		}
		str = new String(chArr);
		System.out.println(str);
	}

//  В строке найти количество цифр

	public static void thirdTask(String str) {
		System.out.printf("%nAnswer thirdTask: %n");
		System.out.println(str);

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 49 && str.charAt(i) <= 57) {
				count++;
			}
		}

		System.out.printf("В строке %d цифр(ы) %n", count);
	}

//  В строке найти количество чисел

	public static void fourthTask(String str) {
		System.out.printf("%nAnswer fourthTask: %n");
		System.out.println(str);

		boolean check = false;
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 49 && str.charAt(i) <= 57) {
				check = true;
			} else {
				if (check) {
					count++;
					check = false;
				}
			}
		}
		if (check) {
			count++;
		}

		System.out.printf("В строке %d числа(чисел) %n", count);
	}

//    Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы. 
//    Крайние пробелы в строке удалить

	public static void fifthTask(String str) {
		System.out.printf("%nAnswer fifthTask: %n");
		System.out.println(str);

		System.out.printf("Длина строки %d символов %n", str.length());

		char[] chArr = str.toCharArray();
		boolean startCheck = true;
		int count = 0;

		for (int i = 0; i < chArr.length; i++) {
			if (chArr[i] == 32) {
				count++;
			} else {
				if (count > 0) {
					if (!startCheck) {
						count--;
					}
					shiftElemsInArray(chArr, i, -count);
					startCheck = false;
					i = i - count;
					count = 0;
				}
			}
		}
		chArr = decreaseSizeCharArray(chArr, count);
		str = new String(chArr);

		System.out.println(str);
		System.out.printf("Длина строки %d символов %n", str.length());
	}

	/*----------------------------*/

	static void printStringArray(String[] arrStrings) {
		for (int i = 0; i < arrStrings.length; i++) {
			System.out.print(arrStrings[i] + " ");
		}
		System.out.println();
	}

	private static int countCapitalLetter(String str) {

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				count++;
			}
		}
		return count;
	}

	private static char[] increaseSizeCharArray(char[] arr1, int n) {
		char[] arr = new char[arr1.length + n];
		for (int i = 0; i < arr1.length; i++) {
			arr[i] = arr1[i];
		}
		return arr;
	}

	private static char[] decreaseSizeCharArray(char[] arr1, int n) {
		char[] arr = new char[arr1.length - n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr1[i];
		}
		return arr;
	}

	private static void shiftElemsInArray(char[] chArr, int startPos, int countPos) {
		if (countPos == 0) {
			return;
		}
		if (countPos > 0) {
			for (int i = (chArr.length - 1) - countPos; i >= startPos - 1; i--) {
				chArr[i + countPos] = chArr[i];
			}
		} else {
			for (int i = startPos; i < chArr.length; i++) {
				chArr[i + countPos] = chArr[i];
			}
		}

	}

}
