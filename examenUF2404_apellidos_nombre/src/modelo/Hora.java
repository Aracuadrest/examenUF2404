package modelo;

public class Hora {

	private int horas;
	private int minutos;
	private int segundos;

	// Constructor sin parámetros
	public Hora() {
		this.horas = 00;
		this.minutos = 00;
		this.segundos = 00;
	}

	// Constructor con parámetros
	public Hora(int horas, int minutos, int segundos) {
		if (horas >= 24 || minutos >= 60 || segundos >= 60) {
			this.horas = 00;
			this.minutos = 00;
			this.segundos = 00;
		} else {
			this.horas = horas;
			this.minutos = minutos;
			this.segundos = segundos;
		}

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
		if (horas >= 24 || minutos >= 60 || segundos >= 60) {
			return false;
		}
		return true;
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
		if (Hora.valida(hora, min, seg) == true) {
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
	public String deSegundos(int seg) {
		int min;
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
		return String.format("%02d:%02d:%02d\n",horas,minutos,segundos);
	}

	/**
	 * Método segundosEntre(Hora) devuelve un entero con el numero de sendos entre las dos
	 */
	public int segundosEntre(Hora h) {
		return (this.aSegundos()-h.aSegundos());
	}
}
