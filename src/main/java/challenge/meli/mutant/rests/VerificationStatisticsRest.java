package challenge.meli.mutant.rests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import challenge.meli.mutant.models.results.VerificationStatisticDNAResult;
import challenge.meli.mutant.services.IVerificationStatisticsDNAService;

@RestController
public class VerificationStatisticsRest {
	
	@Autowired
	private IVerificationStatisticsDNAService iVerificationStatisticsDNAService;
	private final Logger LOGGER = LoggerFactory.getLogger(VerificationStatisticsRest.class);
	
	@GetMapping("/stats")
	public ResponseEntity<Object> get() {
		
		ResponseEntity<Object> responseEntity;
		try {
			LOGGER.info("In mutant post mapping rest");
			VerificationStatisticDNAResult verificationStatistics =
					iVerificationStatisticsDNAService.get();
			responseEntity = new ResponseEntity<>(verificationStatistics,HttpStatus.CREATED);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
		
	}

}
