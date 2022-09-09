package challenge.meli.mutant.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import challenge.meli.mutant.models.entity.repository.custom.VerificationStatisticsDNARepository;
import challenge.meli.mutant.models.results.VerificationStatisticDNAResult;

@SpringBootTest
public class VerificationStatisticsDNAServiceImplTest {
	
	@MockBean
	private VerificationStatisticsDNARepository verificationStatisticsDNARepository;
	
	@Autowired
	private VerificationStatisticsDNAServiceImpl verificationStatisticsDNAServiceImpl;
	
	@Test
	@DisplayName("VerificationStatisticDNAResultTest")
	void VerificationStatisticDNAResultTest () throws Exception {
		
		VerificationStatisticDNAResult verificationStatisticDNAResult = 
				new VerificationStatisticDNAResult(7F, 7F, 7F);
		
		Mockito.when(verificationStatisticsDNARepository.get()).thenReturn(verificationStatisticDNAResult);
		
		verificationStatisticsDNAServiceImpl.get();
		
		assertNotNull(verificationStatisticDNAResult);
			
	}
}
