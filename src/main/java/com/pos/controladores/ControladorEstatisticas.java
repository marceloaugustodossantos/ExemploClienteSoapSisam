/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.controladores;

import com.pos.beans.Ano;
import com.pos.beans.FocoQueimada;
import com.pos.sisampos.SisamService;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author marcelo
 */
@Named (value = "gerenciadorEstatisticas")
@RequestScoped
public class ControladorEstatisticas {
    
    private SisamService service = new  SisamService();
    private String ano = "2012-12-31";
    private List<FocoQueimada> focos = new ArrayList<>();

    public void consultarFocosPorAno(){
        focos = service.getFocosQueimada(ano);
    }
    
    public void consultarFocosPorEstado(){
        focos = service.getFocosQueimada(ano, "PB");
    }
    
    public List<String>listarAnos(){
        return service.getAnos();
    }
    
    public List<String> listarSiglas(){
        return service.getSiglasDeEstados();
    }
    
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }    

    public List<FocoQueimada> getFocos() {
        return focos;
    }

    public void setFocos(List<FocoQueimada> focos) {
        this.focos = focos;
    }
    
}
