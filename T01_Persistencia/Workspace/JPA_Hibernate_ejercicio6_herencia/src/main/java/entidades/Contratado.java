package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Contratado")
public class Contratado extends Empleado {

	@Column(name = "SALARIO")
	private Float salario;

	@Column(name = "CONVENIO")
	private String convenio;

	public Contratado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contratado(String codEmpleado, String nombre, String apellidos, Direccion dir, PlazaParking plaza, Float salario, String convenio) {
		super(codEmpleado, nombre, apellidos, dir, plaza);
		this.salario = salario;
		this.convenio = convenio;
	}
	
	public Contratado(String codEmpleado, String nombre, String apellidos, Direccion dir, Float salario, String convenio) {
		super(codEmpleado, nombre, apellidos, dir);
		this.salario = salario;
		this.convenio = convenio;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	@Override
	public String toString() {
	    return super.toString() + ", Contratado [salario=" + salario + ", convenio=" + convenio + "]";
	}

	

}
