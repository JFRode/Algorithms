/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 5122929
 */
public class Conversor {
    private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public static String paraTexto(Date data){
        return formato.format(data);
    }
    
    public static Date paraData(String texto) throws ParseException{
        return formato.parse(texto);
    }
}