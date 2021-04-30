import java.util.ArrayList;

public class Usuario {
private String email;
private ArrayList<Contratable> itemsContratados = new ArrayList<Contratable>();


public Usuario(String email) {
	this.email = email;
}


public boolean Contratar(Contratable c) throws AlquilerNoEntregadoException {
	if(c instanceof Trabajo) {
		itemsContratados.add(c);
		return true;
	} else {
		long count = itemsContratados.stream()
				.filter(s -> s instanceof Alquiler && !s.finalizado())
				.count();
		if(count > 2) {
			throw new AlquilerNoEntregadoException("Usted ya tiene más de 2 alquileres pendientes, devuelva uno para alquilar otro");
		} else {
			itemsContratados.add(c);
			return true;
		}
	}
}

public String getMail() {
	return this.email;
}

}
