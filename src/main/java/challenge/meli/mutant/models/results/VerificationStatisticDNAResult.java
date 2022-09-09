package challenge.meli.mutant.models.results;

import lombok.Data;

@Data
public class VerificationStatisticDNAResult {
		
	public VerificationStatisticDNAResult(Float mutants, Float humans, Float ratio) {
		this.mutants = mutants;
		this.humans = humans;
		this.ratio = ratio;
	}
	private Float mutants;
	private Float humans;
	private Float ratio;
	
}
