package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service  //  bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService ModelMapperService;
	private BrandBusinessRules brandBusinessRules;
	


	public List<GetAllBrandsResponse> getAll() {
		// iş kuralları
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand->this.ModelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());// bu isim brand de var mı?
		//Brand brand = new Brand();      
		//brand.setName(createBrandRequest.getName());     // map sayesinde tek tek yazmıyoruz.
		
		Brand brand = this.ModelMapperService.forRequest().map(createBrandRequest, Brand.class); // brande çevir
		this.brandRepository.save(brand);
		
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow(); // bulamazsan hata fırlat
		GetByIdBrandResponse response = 
				this.ModelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);  //brandi getIdBrandResponse classına çevir.       
		
		return null;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.ModelMapperService.forRequest().map(updateBrandRequest, Brand.class); // brande çevir
		this.brandRepository.save(brand);  //  id de aldığı için güncelleme yapar.
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}

	

}
