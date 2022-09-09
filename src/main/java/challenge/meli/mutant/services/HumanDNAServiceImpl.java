package challenge.meli.mutant.services;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import challenge.meli.mutant.models.entity.HumanDNA;
import challenge.meli.mutant.models.entity.repository.HumanDNARepository;

@Service
public class HumanDNAServiceImpl implements IHumanDNAService {
	
	@Autowired
	private HumanDNARepository humanDNARepository;

	@Override
	@Transactional
	public void save() {
		HumanDNA humanDNA = new HumanDNA();
		humanDNA.setCreatedAt(new Date());
		humanDNA.setUpdatedAt(new Date());
		humanDNA.setFgActive("1");
		humanDNARepository.save(humanDNA);
	}

}
