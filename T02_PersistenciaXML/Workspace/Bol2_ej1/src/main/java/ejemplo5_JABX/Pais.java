package ejemplo5_JABX;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlType;

@XmlType
public class Pais {

	private String Pais_Capital;
	private String Pais_Nombre;
	private LocalDate fechaCenso;
	private String Pais_Continente;
	private Integer Pais_Habitantes;
	
}
