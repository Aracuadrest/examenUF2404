package modelo;

public class Hora {

	private int horas;
	private int minutos;
	private int segundos;

	// Constructor sin parámetros
	public Hora() {
		this.horas = 0;
		this.minutos = 0;
		this.segundos = 0;
	}

	// Constructor con parámetros
	public Hora(int horas, int minutos, int segundos) {
		setHora(horas,minutos,segundos);

	}
	// Constructor de copia
	public Hora(Hora h) {
		this.horas = h.horas;
		this.minutos = h.minutos;
		this.segundos = h.segundos;
	}

	/**
	 * Método estático y privado valida(int,int,int) se le pasa la hora y devuelva
	 * boolean indicando si la hora es correcta o falsa
	 */
	private static boolean valida(int horas, int minutos, int segundos) {
		if (horas >= 0 && horas<24 && minutos >= 0 && minutos<60 && segundos >= 0 && minutos<60) {
			return true;
		}
		return false;
	}
	// Métodos getters de todos los atributos

	public int getHoras() {
		return horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	/**
	 * Método setHora(hora,min,seg) para establecer la hora a un valor nuevo, deberá
	 * comprobar si es la hora correcta y establecerla (usa el metodo valida)
	 */
	public void setHora(int hora, int min, int seg) {
		if (valida(hora, min, seg)) {
			this.horas = hora;
			this.minutos = min;
			this.segundos = seg;
		} else {
			this.horas = 00;
			this.minutos = 00;
			this.segundos = 00;
		}
	}

	// Sobrescribe el método toString()
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d\n", horas, minutos, segundos);
	}

	/**
	 * Método aSegundos() devolverá el numero de segundos transcurridos de la hora
	 * desde la medianoche.
	 */
	public int aSegundos() {
		return (this.horas * 60 * 60) + (this.minutos * 60) + this.segundos;
	}

	/**
	 * Método deSegundos(int) convierte los segundos pasados a horas,min y seg.
	 */
	public void deSegundos(int seg) {
		/*int min;
		int segun;
		int hora;
		int i;
		i=seg/60;
		segun = seg%60;
		hora=(i)/60;
		min=(i)%60;
		if (hora>24) {
			hora=hora-24;
		}
		if (min>60) {
			min=min-60;
		}
		if (segun>60) {
			segun=segun-60;
		}
		this.horas=hora;
		this.minutos=min;
		this.segundos=segun;
		return String.format("%02d:%02d:%02d\n",horas,minutos,segundos);*/
		int resto=seg%86400;
		int sgs= resto%60;
		resto=resto/60;
		
		int min = resto%60;
		int h=resto/60;
		this.setHora(h, min, seg);
	}

	/**
	 * Método segundosEntre(Hora) devuelve un entero con el numero de sendos entre las dos
	 */
	public int segundosEntre(Hora h) {
		return Math.abs(this.aSegundos()-h.aSegundos());
	}
}
