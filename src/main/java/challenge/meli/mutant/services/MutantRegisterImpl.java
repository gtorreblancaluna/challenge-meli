package challenge.meli.mutant.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import challenge.meli.mutant.exceptions.BusinessException;
import challenge.meli.mutant.exceptions.IsHumanException;
import challenge.meli.mutant.exceptions.IsMutantException;
import challenge.meli.mutant.models.TypeDiagonalMutantDNA;
import challenge.meli.mutant.models.TypeHorizontalMutantDNA;
import challenge.meli.mutant.models.TypeMutantDNA;
import challenge.meli.mutant.models.TypeVerticalMutantDNA;
import challenge.meli.mutant.utils.UtilMutant;
import challenge.meli.mutant.vos.DnaVO;

@Service
public class MutantRegisterImpl implements IMutantRegisterService {

	@Autowired
	private IMutantDNAService iMutantService;
	@Autowired
	private IHumanDNAService iHumanDNAService;
	private final Logger LOGGER = LoggerFactory.getLogger(MutantRegisterImpl.class);
	
	@Override
	public void isMutant (final DnaVO dnaVO) throws BusinessException {
		
		UtilMutant.validateArray(dnaVO);
		TypeMutantDNA horizontalMutant = new TypeHorizontalMutantDNA(dnaVO);
		TypeMutantDNA verticalMutant = new TypeVerticalMutantDNA(dnaVO);
		TypeMutantDNA diagonalMutant = new TypeDiagonalMutantDNA(dnaVO);
		
		try {
			horizontalMutant.checkSequenceDNA();
			verticalMutant.checkSequenceDNA();
			diagonalMutant.checkSequenceDNA();
			iHumanDNAService.save();
			LOGGER.info("<<<< IS HUMAN >>>>");
			throw new IsHumanException();
		} catch (IsMutantException e) {
			LOGGER.info("<<<< IS MUTANT >>>>");
			iMutantService.save();
			throw new IsMutantException();
		}
	}
}
