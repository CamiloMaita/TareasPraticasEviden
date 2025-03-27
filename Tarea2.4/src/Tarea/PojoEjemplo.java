package Tarea;

public class PojoEjemplo {
	
	private Ejemplo ejemplo;

	public PojoEjemplo(Ejemplo ejemplo) {
		
		this.setEjemplo(ejemplo);
	}
	public void realizarEjemplo() { 
		ejemplo.ejecutar();
    }

	public Ejemplo getEjemplo() {
		return ejemplo;
	}

	public void setEjemplo(Ejemplo ejemplo) {
		this.ejemplo = ejemplo;
	}
	
	

}
