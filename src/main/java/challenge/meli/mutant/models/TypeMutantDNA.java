package challenge.meli.mutant.models;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import challenge.meli.mutant.exceptions.IsMutantException;
import challenge.meli.mutant.vos.DnaVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class TypeMutantDNA {
	
	public TypeMutantDNA (DnaVO dnaVO) {
		setDnaVO(dnaVO);
	};
	
	private final Integer SEQUENCE_IS_GREATER_THAN = 4;
	private boolean isMutant;
	private DnaVO dnaVO;
	public final Logger LOGGER = LoggerFactory.getLogger(TypeMutantDNA.class);
	
	public abstract void checkSequenceDNA () throws IsMutantException;
	
	public void checkIfArrayDNAIsMutant (List<Character> array) throws IsMutantException{
		if (array.size() >= 4) {
			 List<Character> sequenceArray = new ArrayList<>();
				for (int i = 0; i < array.size(); i++) {
					if (i == 0) {
						sequenceArray.add(array.get(i));
					} else if (sequenceArray.contains(array.get(i))) {
						sequenceArray.add(array.get(i));
					} else {
						sequenceArray = new ArrayList<>();
						sequenceArray.add(array.get(i));
					}
					if (sequenceArray.size() >= SEQUENCE_IS_GREATER_THAN) {
						LOGGER.info(">>>> IS MUTANT <<<<");
						sequenceArray.stream().forEach(t->{LOGGER.info(t+" ");});
						setMutant(true);
						throw new IsMutantException();
					}
				}
		 }
	}

}
