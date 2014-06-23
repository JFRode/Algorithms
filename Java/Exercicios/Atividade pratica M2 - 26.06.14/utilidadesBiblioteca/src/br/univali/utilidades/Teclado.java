

package br.univali.utilidades;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 5122929
 */

public class Teclado {
    private static Scanner leitura = new Scanner(System.in);                    
    
    public static String lerTexto(String texto){                                // String
        System.out.print(texto);
        return leitura.nextLine();
    }
    
    public static int lerInteiro(String texto){                                 // Int
        System.out.print(texto);
        String inteiro = leitura.nextLine();
        try {
            return Integer.parseInt(inteiro);
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido! Digite um valor inteiro.");
            return lerInteiro(texto);
        }
    }
    
    public static float lerNumero(String texto){                                // Float
        System.out.print(texto);
        String real = leitura.nextLine();
        try {
            return Float.parseFloat(real);
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido! Digite um valor real.");
            return lerNumero(texto);
        }
    }
    
    public static boolean lerBoleano(String texto){                             // Boolean
        System.out.print(texto);
        String boleano = leitura.nextLine();
        try {
            return Boolean.parseBoolean(boleano);
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido! Digite true ou false.");
            return lerBoleano(texto);
        }
    }
    
    public static Date lerData(String texto){                                   // Date
        System.out.print(texto);
        String data = leitura.nextLine();
        try {
            return Conversor.paraData(data);
        } catch (ParseException e) {
            System.out.println("Data digitada invalida!");
            return lerData(texto);
        }  
    }
}
