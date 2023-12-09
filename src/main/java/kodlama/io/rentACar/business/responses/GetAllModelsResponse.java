package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                     // get - set ekler 
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
	private int id;
	private String name;
	//private int brandId;
	private String brandName;   // id değil name getirmek istiyoruz.
}
