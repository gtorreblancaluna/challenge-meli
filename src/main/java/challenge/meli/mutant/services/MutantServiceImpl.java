package challenge.meli.mutant.services;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import challenge.meli.mutant.models.entity.MutantDNA;
import challenge.meli.mutant.models.entity.repository.MutantDNARepository;

@Service
public class MutantServiceImpl implements IMutantDNAService {
	
	@Autowired
	private MutantDNARepository mutantDNARepository;

	@Override
	@Transactional
	public void save() {
		MutantDNA mutantDNA = new MutantDNA();
		mutantDNA.setCreatedAt(new Date());
		mutantDNA.setUpdatedAt(new Date());
		mutantDNA.setFgActive("1");
		mutantDNARepository.save(mutantDNA);
	}

}
