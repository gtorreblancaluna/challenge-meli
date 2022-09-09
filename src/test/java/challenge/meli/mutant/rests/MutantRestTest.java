package challenge.meli.mutant.rests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import challenge.meli.mutant.exceptions.BusinessException;
import challenge.meli.mutant.services.IMutantRegisterService;
import challenge.meli.mutant.vos.DnaVO;

@SpringBootTest
class MutantRestTest {

	@MockBean
	private IMutantRegisterService iMutantRegisterService;
	
	@Autowired
	private MutantRest mutantRest;

	@Test
	void isMutantTest() throws BusinessException {
		DnaVO dnaVO = new DnaVO();
		ResponseEntity<Object> responseEntity = mutantRest.isMutant(dnaVO);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
}
