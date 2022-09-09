package challenge.meli.mutant.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import challenge.meli.mutant.exceptions.BusinessException;
import challenge.meli.mutant.vos.DnaVO;


@SpringBootTest
public class MutantRegisterImplTest {
	
	@MockBean
	private IMutantDNAService iMutantService;
	
	@Autowired
	private MutantRegisterImpl mutantRegisterImpl;
	
	@Test
	@DisplayName("isMutantTest")
	void isMutantTest () throws Exception{
		final DnaVO dnaVO = getDnaVOMutant();
		BusinessException businessException = new BusinessException();
		try {
			mutantRegisterImpl.isMutant(dnaVO);
		} catch (BusinessException e) {
			businessException = e;
		}
		
		assertEquals(HttpStatus.OK, businessException.getHttpStatus());
		
	}
	
	@Test
	@DisplayName("isHumanTest")
	void isHumanTest () throws Exception{
		final DnaVO dnaVO = getDnaVOHuman();
		BusinessException businessException = new BusinessException();
		try {
			mutantRegisterImpl.isMutant(dnaVO);
		} catch (BusinessException e) {
			businessException = e;
		}
		
		assertEquals(HttpStatus.FORBIDDEN, businessException.getHttpStatus());
		
	}
	
	@Test
	@DisplayName("isMutantInvalidJLettersSONTest")
	void isMutantInvalidJLettersSONTest () throws Exception{
		final DnaVO dnaVO = getInvalidLetters();
		BusinessException businessException = new BusinessException();
		try {
			mutantRegisterImpl.isMutant(dnaVO);
		} catch (BusinessException e) {
			businessException = e;
		}
		
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, businessException.getHttpStatus());
		
	}
	
	@Test
	@DisplayName("isMutantInvalidEmptySONTest")
	void isMutantInvalidEmptySONTest () throws Exception{
		final DnaVO dnaVO = null;
		BusinessException businessException = new BusinessException();
		try {
			mutantRegisterImpl.isMutant(dnaVO);
		} catch (BusinessException e) {
			businessException = e;
		}
		
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, businessException.getHttpStatus());
		
	}
	
	@Test
	@DisplayName("isMutantInvalidLettersLengthJSONTest")
	void isMutantInvalidLettersLengthJSONTest () throws Exception{
		final DnaVO dnaVO = getInvalidLettersLengthJSON();
		BusinessException businessException = new BusinessException();
		try {
			mutantRegisterImpl.isMutant(dnaVO);
		} catch (BusinessException e) {
			businessException = e;
		}
		
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, businessException.getHttpStatus());
		
	}
	
	private DnaVO getInvalidLettersLengthJSON () {
		DnaVO dnaVO = new DnaVO();
		List<String> dna = new ArrayList<>();
		dna.add("ACGTGCCC");
		dna.add("CATTGC");
		dna.add("TTATGG");
		dna.add("ATAGTG");
		dna.add("CCTCTA");
		dna.add("TCATTG");
		dnaVO.setDna(dna);		 		
		return dnaVO;
	}
		
	
	private DnaVO getInvalidLetters () {
		DnaVO dnaVO = new DnaVO();
		List<String> dna = new ArrayList<>();
		dna.add("ACXTGC");
		dna.add("CATTGC");
		dna.add("TTATGG");
		dna.add("ATAGTG");
		dna.add("CCTCTA");
		dna.add("TCATTG");
		dnaVO.setDna(dna);		 		
		return dnaVO;
	}
	
	private DnaVO getDnaVOHuman () {
		DnaVO dnaVO = new DnaVO();
		List<String> dna = new ArrayList<>();
		dna.add("ACGGGC");
		dna.add("CATTGC");
		dna.add("TTATGG");
		dna.add("ATAGTG");
		dna.add("CCTCTA");
		dna.add("TCATTG");
		dnaVO.setDna(dna);		 		
		return dnaVO;
	}
	
	private DnaVO getDnaVOMutant () {
		DnaVO dnaVO = new DnaVO();
		List<String> dna = new ArrayList<>();
		dna.add("ATGCGA");
		dna.add("CAGTGC");
		dna.add("TTTTTT");
		dna.add("AGACGG");
		dna.add("GCGTCA");
		dna.add("TCACTG");
		dnaVO.setDna(dna);		 		
		return dnaVO;
	}
}
