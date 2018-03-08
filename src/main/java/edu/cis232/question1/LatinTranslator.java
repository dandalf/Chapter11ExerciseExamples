package edu.cis232.question1;

public class LatinTranslator {

	public static String translate(String latinWord){
		String englishWord = "";
		switch(latinWord.toLowerCase()){
			case "sinister":
				englishWord = "left";
				break;
			case "dexter":
				englishWord = "right";
				break;
			case "medium":
				englishWord = "center";
				break;
			default:
				throw new IllegalArgumentException(String.format("%s cannot be translated to english.", latinWord));
		}

		return englishWord;
	}

}
