/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import java.util.Date;


/**
 *
 * @author user
 */
public class Tratamento {
    private Date dataInicio;
    private float dosagem;
    private Medico medico;
    private Pessoa pessoa;
    private int quantidadeDias;
    private int quantidadeVezes;
    private Remedio remedio;

    public Tratamento(Date dataInicio, float dosagem, Medico medico, Pessoa pessoa, int quantidadeDias, int quantidadeVezes, Remedio remedio){
        this.dataInicio = dataInicio;
        this.dosagem = dosagem;
        this.medico = medico;
        this.pessoa = pessoa;
        this.quantidadeDias = quantidadeDias;
        this.quantidadeVezes = quantidadeVezes;
        this.remedio = remedio;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public float getDosagem() {
        return dosagem;
    }

    public Medico getMedico() {
        return medico;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public int getQuantidadeVezes() {
        return quantidadeVezes;
    }

    public Remedio getRemedio() {
        return remedio;
    }
    
}
