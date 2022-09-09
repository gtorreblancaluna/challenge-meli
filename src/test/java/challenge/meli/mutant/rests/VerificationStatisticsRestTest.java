package challenge.meli.mutant.rests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import challenge.meli.mutant.exceptions.BusinessException;
import challenge.meli.mutant.services.IVerificationStatisticsDNAService;

@SpringBootTest
class VerificationStatisticsRestTest {

	@MockBean
	private IVerificationStatisticsDNAService iVerificationStatisticsDNAService;
	
	@Autowired
	private VerificationStatisticsRest verificationStatisticsRest;

	@Test
	void isMutantTest() throws BusinessException {
		ResponseEntity<Object> responseEntity = verificationStatisticsRest.get();
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
	
}
