package challenge.meli.mutant.models.entity.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import challenge.meli.mutant.models.results.VerificationStatisticDNAResult;

@Repository
public class VerificationStatisticsDNARepository {
	
	@PersistenceContext
	private EntityManager em;
	static final String STATEMENT_SQLMAP = "VerificationStatisticDNAResultMapping";
	
	public VerificationStatisticDNAResult get() {
        Query query = em.createNativeQuery(
        		"SELECT"
				+ "("
				+ "(SELECT COUNT(*) FROM mutants_dna WHERE fg_active='1')"
				+ "/(SELECT COUNT(*) FROM humans_dna WHERE fg_active='1')"
				+ ") AS ratio,"
				+ "(SELECT COUNT(*) FROM mutants_dna WHERE fg_active='1') AS mutants,"
				+ "(SELECT COUNT(*) FROM humans_dna WHERE fg_active='1') AS humans",
            STATEMENT_SQLMAP);
        VerificationStatisticDNAResult res = (VerificationStatisticDNAResult) query.getSingleResult();
        return res;
    }
		
	
	
	
}
