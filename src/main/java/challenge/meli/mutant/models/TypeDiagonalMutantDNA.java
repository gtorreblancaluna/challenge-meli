package challenge.meli.mutant.models;

import java.util.ArrayList;
import java.util.List;
import challenge.meli.mutant.exceptions.IsMutantException;
import challenge.meli.mutant.utils.UtilMutant;
import challenge.meli.mutant.vos.DnaVO;

public class TypeDiagonalMutantDNA extends TypeMutantDNA {
	
	public TypeDiagonalMutantDNA(DnaVO dnaVO) {
		super(dnaVO);
	}
	
	@Override
	public void checkSequenceDNA() throws IsMutantException{
		LOGGER.info(">>>> DIAGONAL SEQUENCE <<<<");
		List<Character> diagonalArray = new ArrayList<>();
		char[][] dna = UtilMutant.getArrayCharFromDNA(getDnaVO());
		int n = dna.length;
		int i=0,j=0;
		 
		 System.out.println("--------------");
		 int row=0;
		 int col =0;
		 while(row<n){
			 col=0;
			 int rowTemp = row;
			     diagonalArray = new ArrayList<>();
				 while(rowTemp>=0){
					 System.out.print(dna[col][rowTemp] + " ");
					 diagonalArray.add(dna[col][rowTemp]);
					 rowTemp--;
					 col++;
				 }
				 checkIfArrayDNAIsMutant(diagonalArray);
			 System.out.println();
			 row++;
		 }
		 
		 System.out.println("--------------");
		 col = 1;
		 while(col<n){
			 int colTemp = col;
			 row = n-1;
			 	 diagonalArray = new ArrayList<>();
				 while(colTemp<=n-1){
					 System.out.print(dna[colTemp][row] + " ");
					 diagonalArray.add(dna[colTemp][row]);
					 row--;
					 colTemp++;
				 }
				 checkIfArrayDNAIsMutant(diagonalArray);
			 System.out.println();
			 col++;
		 }
		 		 	

		System.out.println("-----NEW METHOD--------");
		int k=0;
	 	for(j=n-1; j>=0; j--){
	 		diagonalArray = new ArrayList<>();
            for(k=0; k<n; k++){
                if((j + k) < n){
                    System.out.print(dna[k][j + k] + " ");
                    diagonalArray.add(dna[k][j + k]);
                } else {
                    break;
                }
            }
            System.out.println();
            checkIfArrayDNAIsMutant(diagonalArray);
        }
        for(i=1; i<n; i++){
        	diagonalArray = new ArrayList<>();
            for(j=i, k=0; j<n && k<n; j++, k++){
                System.out.print(dna[j][k] + " ");
            }
            
            checkIfArrayDNAIsMutant(diagonalArray);
            System.out.println();
        }
		
	}
	

}
