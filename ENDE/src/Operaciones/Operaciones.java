package Operaciones;
public class Operaciones{
		
	
    public int sumar (int valor1, int valor2){
        int numero;
        numero = valor1 + valor2;
        return numero;
    }
    
    public int restar (int valor1, int valor2){
        int numero;
        numero = valor1 - valor2;
        return numero;
    }
    
    public int multiplicar (int valor1, int valor2){
        int numero;
        numero = valor1 * valor2;
        return numero;
    }
    
    /*
     * Divide los dos números que recibe como parámetro
     * @author Not Batman
     * @version 4.22.0
     * @param valor 1 Dividendo
     * @param valor2 Divisor
     * 
     * @return Devuelve un número íntegro (un número completo, sin comas).
     * @throws ArithmeticException "Contempla la división entre cero."
     * @see https://github.com/agonsalez/Calculadora.git
     * 
     */
    
    public int dividir (int valor1, int valor2) throws ArithmeticException {
        int numero;
        numero = valor1 / valor2;
        return numero;
    }
    
    public int resto (int valor1, int valor2){
        int numero;
        numero = valor1 % valor2;
        return numero;
    }
}