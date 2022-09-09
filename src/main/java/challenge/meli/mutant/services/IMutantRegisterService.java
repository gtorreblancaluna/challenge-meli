package challenge.meli.mutant.services;

import challenge.meli.mutant.exceptions.BusinessException;
import challenge.meli.mutant.vos.DnaVO;

public interface IMutantRegisterService {
	
	public void isMutant(DnaVO dnaVO) throws BusinessException;

}
