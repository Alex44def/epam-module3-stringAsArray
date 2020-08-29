package ru.epam.jonline.module3.string_as_array;

public class Main {

	public static void main(String[] args) {

		System.out.println("Strings. Строка как массив символов");

		String[] arrStrings1 = new String[] { "stringsAsArray", "subPrograms", "oneDimensionalArraysSorting" };
		Tasks.firstTask(arrStrings1);
		Tasks.secondTask("First there was the word and the word was with God and the word was God");
		Tasks.thirdTask("22 plus 2 equals 24");
		Tasks.fourthTask("23 plus 2 equals 25 or 26?");
		Tasks.fifthTask("   23  plus 2   equals  25 or 26 ?     ");

	}

}
