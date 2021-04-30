import java.time.LocalDate;

public class App {

public static void main(String[] args) {
	
	
	Oficio oficio1 = new Oficio("Plomeria");
	Oficio oficio2 = new Oficio("Limpieza");
	Servicio limpiarCasa = new ServicioEstandar(oficio2, 5000.0, 400.0);
	Servicio arreglarCocina = new servicioPersonalizado(oficio2, 25000.0, 15000.0, 2000.0);
	Servicio arreglarBaño = new ServicioEstandar(oficio1, 20000.0, 400.0);
	Trabajador trabajador = new Trabajador("Claudio", "claudio@mail.com", oficio1, 500.00, 20.00);
	Trabajo trabajo1 = new Trabajo(limpiarCasa, LocalDate.now(), true);
	Trabajo trabajo2 = new Trabajo(limpiarCasa, LocalDate.now(), false);
	Trabajo trabajo3 = new Trabajo(limpiarCasa, LocalDate.now().plusDays(2), false);
	Trabajo trabajo4 = new Trabajo(arreglarBaño, LocalDate.now().plusDays(2), false);
	Trabajo trabajo5 = new Trabajo(arreglarCocina, LocalDate.now().plusDays(2), false);
	
	Herramienta martillo = new Herramienta("Herramienta", 550);
	Alquiler alquiler1 = new Alquiler(martillo, LocalDate.now().minusDays(5), 7);
	Alquiler alquiler2 = new Alquiler(martillo, LocalDate.now().minusDays(5), 4);
	Alquiler alquiler3 = new Alquiler(martillo, LocalDate.now().minusDays(4), 8);
	Alquiler alquiler4 = new Alquiler(martillo, LocalDate.now().minusDays(3), 9);
	Alquiler alquiler5 = new Alquiler(martillo, LocalDate.now().minusDays(3), 10);
	
	Usuario usuario1 = new Usuario("usuario@gmail.com");
	System.out.println("Alquiler 1 - Precio: " + alquiler1.Precio());
	System.out.println("Alquiler 1 - Finalizado: " + alquiler1.finalizado());
	System.out.println("Alquiler 1 - enMora: " + alquiler1.enMora());
	alquiler1.devolver(LocalDate.now().plusDays(15));
	System.out.println("Alquiler 1 - Precio: " + alquiler1.Precio());
	System.out.println("Alquiler 1 - Finalizado: " + alquiler1.finalizado());
	System.out.println("Alquiler 1 - enMora: " + alquiler1.enMora());	
	System.out.println("Alquiler 2 - enMora: " + alquiler1.enMora());
	System.out.println("Trabajo 1 - Precio " + trabajo1.Precio());
	System.out.println("Trabajo 2 - Precio " + trabajo2.Precio());
	System.out.println("Trabajo 5 - Precio " + trabajo5.Precio());

	try {
		System.out.println("agregar trabajo: " + trabajador.agregarTrabajo(trabajo5));
		System.out.println("agregar trabajo: " + trabajador.agregarTrabajo(trabajo3));
		System.out.println(trabajador.agregarTrabajo(trabajo2));
		System.out.println(trabajador.agregarTrabajo(trabajo4));
	} catch (OficioNoCoincideException e) {
		System.out.println(e.getMessage());
	} catch (AgendaOcupadaException e) {
		System.out.println(e.getMessage());
	}
	
	System.out.println("trabajo terminado: " + trabajo2.finalizado());
	trabajo2.finalizar(LocalDate.now());
	System.out.println("trabajo terminado: " + trabajo2.finalizado()); 
	
	try {
		System.out.println("contratar trabajador: " + usuario1.Contratar(trabajo2)); 
		System.out.println("alquila: " + usuario1.Contratar(alquiler2)); 
		System.out.println("alquila: " + usuario1.Contratar(alquiler3)); 
		System.out.println("alquila: " + usuario1.Contratar(alquiler4)); 
		System.out.println("alquila: " + usuario1.Contratar(alquiler5)); 	
	} catch (AlquilerNoEntregadoException e) {
		System.out.println(e.getMessage());
	}
	
	}
}
