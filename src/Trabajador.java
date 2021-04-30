
import java.util.ArrayList;

public class Trabajador {
private String nombre;
private String email;
private Oficio oficio;
private double costoPorHora;
private double porcentajeComision;
private ArrayList<Trabajo> trabajoAsignados = new ArrayList<Trabajo>();

public Trabajador(String nombre, String email, Oficio oficio, double costoPorHora, double porcentajeComision) {
	this.nombre = nombre;
	this.email = email;
	this.oficio = oficio;
	this.costoPorHora = costoPorHora;
	this.porcentajeComision = porcentajeComision;
}

public Boolean agregarTrabajo(Trabajo trabajo) throws OficioNoCoincideException, AgendaOcupadaException{
	if(trabajo.getOficio() != this.oficio) {
		throw new OficioNoCoincideException("El trabajador no puede relizar esta tarea");
	} else {
		long count = trabajoAsignados.stream().map(s -> s.getFecha()).filter(s-> s.compareTo(trabajo.getFecha()) == 0).count();
		if(count == 0) {
				trabajoAsignados.add(trabajo);
				return true;
			} else {
				throw new AgendaOcupadaException("El trabajador tiene trabajo asignado este d�a");
			}
	}
	
}

public double getPorcentajeComision() {
	return this.porcentajeComision;
}


}