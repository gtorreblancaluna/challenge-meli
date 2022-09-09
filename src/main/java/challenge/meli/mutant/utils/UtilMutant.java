package challenge.meli.mutant.utils;

import java.util.Arrays;
import challenge.meli.mutant.exceptions.BusinessException;
import challenge.meli.mutant.exceptions.InvalidArgumentException;
import challenge.meli.mutant.vos.DnaVO;

public abstract class UtilMutant {
	
	private final static Integer VALID_LENGTH_PER_STRING = 6;
	private final static String[] lettersValid = {"A","T","C","G"};
	
	public static char[][] getArrayCharFromDNA (final DnaVO dnaVO) {
		
		int vectorLength = dnaVO.getDna().size();
		char[][] dna = new char[vectorLength][vectorLength];
		for (int i = 0; i < vectorLength; i++) {
			String dnaRow = dnaVO.getDna().get(i);
			dna[i] = dnaRow.toUpperCase().toCharArray();
		}
		
		return dna;
		
	}
		
	public static String[] getArrayLetters (final String letters) {
		return letters.toUpperCase().trim().split("");
	}
	
	public static void validateArray (final DnaVO dnaVO) throws BusinessException {
		
		if (dnaVO == null || dnaVO.getDna() == null || dnaVO.getDna().isEmpty()) {
			throw new InvalidArgumentException("DNA Array is empty");
		}
		
		
		for (String letters : dnaVO.getDna()) {
			String[] arrayLetters = getArrayLetters(letters);
			if (arrayLetters.length != VALID_LENGTH_PER_STRING) {
				throw new InvalidArgumentException(String.format("Invalid string length [%s]. Valid lenght per string is %s",
						letters,
						VALID_LENGTH_PER_STRING));
			}			
			for (String letter : arrayLetters) {
				if (!Arrays.stream(lettersValid).anyMatch(letter::contains)) {
					throw new InvalidArgumentException(String.format("Letter [%s] is not valid. Please send valid letters: [%s]",letter, String.join(",", lettersValid)));
				}
			}
		}
	}

}
