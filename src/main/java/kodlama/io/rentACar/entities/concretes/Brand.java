package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import javax.persistence.Table;

@Table(name="brands")
//@Data    //  getter ve setter oluşturur.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity     //  veritabanı nesnesisin.
public class Brand {
	@Id                  // veritabanında pk sın
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // id otomatik 1 artar
	@Column(name="id")   // veritabanındaki kolon adı
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "brand")  // ilişkilendirdik.
	private List<Model> models;   // birden çok model vardır.
	
//	public Brand() {
//		super();
//	}
//	public Brand(int id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	
}
