package kodlama.io.rentACar.entities.concretes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="cars")
//@Data    //  getter ve setter oluşturur.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity     //  veritabanı nesnesisin.
public class Car {
	@Id                  // veritabanında pk sın
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // id otomatik 1 artar
	@Column(name="id")   // veritabanındaki kolon adı
	private int id;
	
	@Column(name="plate", unique=true)   // plaka, unique - tekrar edemez
	private String plate;
	
	@Column(name="dailyPrice")   
	private double dailyPrice;   // ücret
	
	@Column(name="modelYear")   // yılı
	private int modelYear;  
	
	@Column(name="state")   // plaka
	private int state;      // 1- Available 2- Rented 3- Maintenance
	
	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;
}





