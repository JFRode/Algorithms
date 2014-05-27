 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.utilidades;


import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 5122929
 */
public class Teclado {
    private static Scanner leitura = new Scanner(System.in);
    
    public static String lerTexto(){
        return leitura.nextLine();
    }
    
    public static int lerInteiro(){
        return leitura.nextInt();
    }
    
    public static float lerNumero(){
        return leitura.nextFloat();
    }
    
    public static boolean lerBoleano(){
        return leitura.nextBoolean();
    }
    
    public static Date lerData(){
        return Conversor.paraData(leitura.nextLine());
    }
}
