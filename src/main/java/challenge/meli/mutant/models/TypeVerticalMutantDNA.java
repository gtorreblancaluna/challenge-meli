package challenge.meli.mutant.models;

import java.util.ArrayList;
import java.util.List;
import challenge.meli.mutant.exceptions.IsMutantException;
import challenge.meli.mutant.utils.UtilMutant;
import challenge.meli.mutant.vos.DnaVO;

public class TypeVerticalMutantDNA extends TypeMutantDNA{

	public TypeVerticalMutantDNA(DnaVO dnaVO) {
		super(dnaVO);
	}

	@Override
	public void checkSequenceDNA() throws IsMutantException{
		LOGGER.info(">>>> VERTICAL SEQUENCE <<<<");
		char[][] dna = UtilMutant.getArrayCharFromDNA(getDnaVO());
		List<Character> arrayVertical = new ArrayList<>();
		for (int col = 0; col < dna.length ; col++) {
			arrayVertical = new ArrayList<>();
			for (int row = 0; row < dna.length ; row++) {
				arrayVertical.add(dna[row][col]);
			}
			checkIfArrayDNAIsMutant(arrayVertical);
		}
	}

}
