package challenge.meli.mutant.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import challenge.meli.mutant.models.entity.repository.HumanDNARepository;

@SpringBootTest
public class HumanDNAServiceImplTest {
	
	@MockBean
	private HumanDNARepository humanDNARepository;
	@Autowired
	private HumanDNAServiceImpl humanDNAServiceImpl;
	
	@Test
	void save() throws Exception {
		assertDoesNotThrow(() -> humanDNAServiceImpl.save());
	}
}
