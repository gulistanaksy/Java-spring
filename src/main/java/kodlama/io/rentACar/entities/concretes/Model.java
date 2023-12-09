package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="models")   // tablo adı
//@Data    //  getter ve setter oluşturur.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity     //  veritabanı nesnesisin.
public class Model {
	@Id                  // veritabanında pk sın
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // id otomatik 1 artar
	@Column(name="id")   // veritabanındaki kolon adı
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne             // çok kere brand tekrarlanır.
	@JoinColumn(name="brand_id")   // postgre tarafında tabloya brand_id oluşturcak.
	private Brand brand;   // 1 tane brand 
	
	@OneToMany(mappedBy="model")
	private List<Car> cars;        // bir modelden birden çok araba olabilir.         
}
