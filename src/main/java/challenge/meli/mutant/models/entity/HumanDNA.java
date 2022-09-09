package challenge.meli.mutant.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import challenge.meli.mutant.models.results.VerificationStatisticDNAResult;
import lombok.Data;


@SqlResultSetMapping(name="VerificationStatisticDNAResultMapping",
classes = {
 @ConstructorResult(targetClass = VerificationStatisticDNAResult.class,
   columns = {
		   @ColumnResult(name="mutants", type=Float.class), 
		   @ColumnResult(name="humans", type=Float.class),
		   @ColumnResult(name="ratio", type=Float.class)
		 	}
 )}
)

@Entity
@Table(name = "humans_dna")
@Data
public class HumanDNA implements Serializable {
	
	private static final long serialVersionUID = -4376538422450007444L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "fg_active")
	private String fgActive;
	
}
