package challenge.meli.mutant.models;

import java.util.ArrayList;
import java.util.List;
import challenge.meli.mutant.exceptions.IsMutantException;
import challenge.meli.mutant.utils.UtilMutant;
import challenge.meli.mutant.vos.DnaVO;

public class TypeHorizontalMutantDNA extends TypeMutantDNA{

	public TypeHorizontalMutantDNA(DnaVO dnaVO) {
		super(dnaVO);
	}

	public void checkSecuencieDNA() throws IsMutantException{
		LOGGER.info(">>>> HORIZONTAL SEQUENCE <<<<");
		char[][] dna = UtilMutant.getArrayCharFromDNA(getDnaVO());
		List<Character> arrayHorizontal = new ArrayList<>();
		for (int col = 0; col < dna.length ; col++) {
			arrayHorizontal = new ArrayList<>();
			for (int row = 0; row < dna.length ; row++) {
				arrayHorizontal.add(dna[col][row]);
			}
			checkIfArrayDNAIsMutant(arrayHorizontal);
		}
	}
	
}
