/**
 * UNIVALI - Universidade do Vale do Itajaí
 * Ciência da Computação - 4º Periodo,   2014/2
 * Programação II
 * Professor Elieser
 * Acadêmicos:  - Guilherme Gustavo Gohr Darosci
 *              - João Felipe Gonçalves
 */

package br.univali.myadmin.controle;

public class Principal {

    public static void main(String[] args) {
        try {
            new Controlador();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
