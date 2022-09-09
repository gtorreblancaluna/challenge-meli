package challenge.meli.mutant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import challenge.meli.mutant.models.entity.repository.custom.VerificationStatisticsDNARepository;
import challenge.meli.mutant.models.results.VerificationStatisticDNAResult;

@Service
public class VerificationStatisticsDNAServiceImpl implements IVerificationStatisticsDNAService {

	@Autowired
	private VerificationStatisticsDNARepository verificationStatisticsDNARepository;
	
	@Override
	@Transactional(readOnly=true)
	public VerificationStatisticDNAResult get() {
		return verificationStatisticsDNARepository.get();
	}

}
