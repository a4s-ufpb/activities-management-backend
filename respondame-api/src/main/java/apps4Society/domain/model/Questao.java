package apps4Society.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Questao {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	@Column(name = "alternativa_a")
	private String alternativaA;
	@Column(name = "alternativa_b")
	private String alternativaB;
	@Column(name = "alternativa_c")
	private String alternativaC;
	@Column(name = "alternativa_d")
	private String alternativaD;
	private Character alternativaCorreta;
}
