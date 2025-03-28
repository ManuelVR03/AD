package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BECARIO", catalog = "empresa3")
public class Becario extends Empleado {
	
	@Column(name = "TUTOR")
	private String tutor;
	
	@Column(name = "SALARIOHORA")
	private Float salarioHora;

	public Becario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Becario(String codEmpleado, String nombre, String apellidos, String tutor, Float salarioHora) {
		super(codEmpleado, nombre, apellidos);
		this.tutor = tutor;
		this.salarioHora = salarioHora;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public Float getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(Float salarioHora) {
		this.salarioHora = salarioHora;
	}

	@Override
	public String toString() {
		return super.toString() + ", Becario [tutor=" + tutor + ", salarioHora=" + salarioHora + "]";
	}	
	
}
