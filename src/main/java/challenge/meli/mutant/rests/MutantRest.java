package challenge.meli.mutant.rests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import challenge.meli.mutant.exceptions.BusinessException;
import challenge.meli.mutant.services.IMutantRegisterService;
import challenge.meli.mutant.vos.DnaVO;

@RestController
public class MutantRest {
	
	@Autowired
	private IMutantRegisterService iMutantRegisterService;
	private final Logger LOGGER = LoggerFactory.getLogger(MutantRest.class);
	
	@PostMapping("/mutant")
	public ResponseEntity<Object> isMutant (@RequestBody DnaVO dnaVO) {
		
		ResponseEntity<Object> responseEntity;
		try {
			LOGGER.info("In mutant post mapping rest");
			iMutantRegisterService.isMutant(dnaVO);
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		} catch (BusinessException e) {
			responseEntity = new ResponseEntity<>(e.getMessage() ,e.getHttpStatus());
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
}
