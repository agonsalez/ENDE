package calculadora;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Operaciones.Operaciones;
import logs.LogConsolaMasFichero;
import menu.Menu;

/*@author Batman*/ 

public class Calculadora{
	 private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());

	
    public static void main(String[] args) {   
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int [2];
        
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
        
        Handler fileHandler = null;
        Handler consoleHandler = new ConsoleHandler();
        try {
        fileHandler  = new FileHandler("./src/logs/operaciones.log");
        
	    }catch(IOException exception){
	        LOGGER.log(Level.SEVERE, "Ocurrió un error en FileHandler.", exception);
	    }
        //Evitar que muestre nada por la consola
        //LogManager.getLogManager().reset()
        //fileHandler.setFormatter(new SimpleFormatter());
        
        LOGGER.addHandler(consoleHandler);
        LOGGER.addHandler(fileHandler);
        
      //Establecer niveles a handlers y LOGGER
        consoleHandler.setLevel(Level.WARNING); //Está filtrando WARNING y superiores.
        fileHandler.setLevel(Level.FINE);
        LOGGER.setLevel(Level.FINE);
        
        
                
        do{
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();
            
            	try {
            if (operacion.equalsIgnoreCase("+")){
                resultado = operaciones.sumar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("-")){
                resultado = operaciones.restar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("*")){
                resultado = operaciones.multiplicar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("/")){
                resultado = operaciones.dividir(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("%")){
                resultado = operaciones.resto(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else {
                System.out.println ("Operación no válida");
            }
            LOGGER.log(Level.FINE, "Operación: " + operacion + " operando 1: " + operandos[0] + " operando 2: " + operandos[1] + " Resultado: " + resultado );
            //Antes          INFO
            }catch(ArithmeticException e){
            System.out.println("Operación aritmética no válida: " + e.getMessage());
            LOGGER.log(Level.WARNING, "División entre cero.");

            }
        }   while (menu.repetir());
    }
}