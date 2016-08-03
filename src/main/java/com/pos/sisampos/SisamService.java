/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.sisampos;

import com.pos.anomesws.MesAnoService;
import com.pos.anomesws.MesAnoServiceService;
import com.pos.beans.FocoQueimada;
import com.pos.tabulacaows.TabulacaoService;
import com.pos.tabulacaows.TabulacaoServiceService;
import com.pos.tabulacaows.VariaveisView;
import com.pos.variaveis.VarWebServiceView;
import com.pos.variaveis.VariaveisService;
import com.pos.variaveis.VariaveisServiceService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class SisamService {

    private CidadesService cidades = new CidadesServiceService().getCidadesWebService();
    private MesAnoService mesAno = new MesAnoServiceService().getMesAnoWebService();
    private VariaveisService variaveisService = new VariaveisServiceService().getVariaveisWebService();
    private TabulacaoService tabulacaoService = new TabulacaoServiceService().getTabulacaoWebService();
    private List<VarWebServiceView> listaVariaveis = variaveisService.getListaVariaveis();
    private List<String> siglasEstados = new ArrayList<>();

    public SisamService() {
        listarSiglasDeEstados();
    }
    
    public List<FocoQueimada> getFocosQueimada(String ano) {
        
        List<String> anosConsulta = new ArrayList();
        anosConsulta.add(ano);

        List<VariaveisView> dadosTabulados = tabulacaoService.getDadosTabulados(
                "ano", "2006-01-01", "2006-12-01", new ArrayList<String>(),
                anosConsulta, "estado", siglasEstados, new ArrayList<String>(), getVariavel("Focos de Queima"));
        
        List<FocoQueimada> resultado = new ArrayList<>();
        for (VariaveisView v : dadosTabulados) {
            resultado.add(new FocoQueimada(v.getEstado(), v.getNome(), v.getFocoq()));
        }
        return resultado;
    }
    public List<FocoQueimada> getFocosQueimada(String ano, String estado) {
        
        List<String> anosConsulta = new ArrayList();
        anosConsulta.add(ano);
        
        List<String> estadosConsulta = new ArrayList<>();
        estadosConsulta.add(estado);
                
        List<String> municipiosConsulta = new ArrayList<>();
        for( PontosMunicipais p : cidades.getMunicipios(estado)){
            municipiosConsulta.add(String.valueOf(p.getGid()));
        }
       
        List<VariaveisView> dadosTabulados = tabulacaoService.getDadosTabulados(
                "ano", "2006-01-01", "2006-12-01", new ArrayList<String>(),
                anosConsulta, "estado", estadosConsulta , new ArrayList<String>() , getVariavel("Focos de Queima"));
        
        List<FocoQueimada> resultado = new ArrayList<>();
        for (VariaveisView v : dadosTabulados) {
            resultado.add(new FocoQueimada(v.getEstado(), v.getNome(), v.getFocoq()));
        }
        return resultado;
    }

    public List<String> getAnos() {
        return mesAno.getAnos();
    }
    public List<String> getSiglasDeEstados() {
        List<String> siglas = new ArrayList<>();
        for (Estados e : cidades.getEstados()) {
            siglas.add(e.sigla);
        }
        return siglas;
    }
    
    private List<String> getVariavel(String nome) {
        List<String> listVar = new ArrayList<>();
        for (VarWebServiceView var : listaVariaveis) {
            if (var.getNome().equals(nome)) {
                listVar.add(var.getNomeBanco());
                break;
            }
        }
        return listVar;
    }

    private void listarSiglasDeEstados() {
        for (Estados e : cidades.getEstados()) {
            this.siglasEstados.add(e.sigla);
        }
    }

}
