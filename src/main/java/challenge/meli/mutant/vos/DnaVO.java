package challenge.meli.mutant.vos;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DnaVO implements Serializable{
	
	private static final long serialVersionUID = -8447275757735544286L;
	
	private List<String> dna;

}
