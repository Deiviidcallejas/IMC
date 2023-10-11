package Categoria;

public class IProcesosIMC {
	public class ProcesosIMC {
	    public static double calcularIMC(double peso, double altura) {
	        return peso / (altura * altura);
	    }

	    public static String obtenerCategoriaIMC(double imc) {
	        if (imc < 18.5) {
	            return "Bajo peso";
	        } else if (imc < 24.9) {
	            return "Peso normal";
	        } else if (imc < 29.9) {
	            return "Sobrepeso";
	        } else if (imc < 34.9) {
	            return "Obesidad grado 1";
	        } else if (imc < 39.9) {
	            return "Obesidad grado 2";
	        } else {
	            return "Obesidad grado 3";
	        }
	    }
	}

}
