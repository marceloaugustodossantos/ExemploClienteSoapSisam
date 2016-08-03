/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.beans;

/**
 *
 * @author marcelo
 */
public class FocoQueimada {

    private  String estado;
    private String municipio;
    private  Double qtdFocos;

    public FocoQueimada(String nome, String municipio, Double qtd) {
        this.estado = nome;
        this.qtdFocos = qtd;
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getQtdFocos() {
        return qtdFocos;
    }

    public void setQtdFocos(Double qtdFocos) {
        this.qtdFocos = qtdFocos;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
}
