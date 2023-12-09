package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{
	private ModelMapperService ModelMapperService;
	private ModelRepository modelRepository;
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		
		
		// models içerisindeki her bir modeli bizim GetAllModelsResponse classımıza göre çevir.
		// brandName otomatik doldurulur.
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model->this.ModelMapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
				
		return modelsResponse;
	}
	
	// request createModelRequest classını Model clasına çevir.
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.ModelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
	}

}
