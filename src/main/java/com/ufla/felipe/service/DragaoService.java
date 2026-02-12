package com.ufla.felipe.service;

import com.ufla.felipe.component.BuscadorDragoes;
import com.ufla.felipe.component.ListaDragoes;
import com.ufla.felipe.component.OrdenadorDragoes;
import com.ufla.felipe.component.JsonDragoes;
import com.ufla.felipe.models.DragaoDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DragaoService {

    private final BuscadorDragoes buscadorDragoes;
    private final ListaDragoes listaDragoes;
    private final OrdenadorDragoes ordenadorDragoes;
    private final JsonDragoes jsonDragoes;

    public DragaoService(BuscadorDragoes buscadorDragoes, ListaDragoes listaDragoes, OrdenadorDragoes ordenadorDragoes, JsonDragoes jsonDragoes) {
        this.buscadorDragoes = buscadorDragoes;
        this.listaDragoes = listaDragoes;
        this.ordenadorDragoes = ordenadorDragoes;
        this.jsonDragoes = jsonDragoes;
    }

    @PostConstruct
    public void init() {
        jsonDragoes.carregarDragoesJSON(listaDragoes.getDragoesDefinitivo());
        listaDragoes.cloneTemp();
    }

    public String escreverDragoesDefinitivo(){
        return jsonDragoes.escreverNomes(listaDragoes.getDragoesDefinitivo());
    }

    public String escreverDragoesTemp(){
        return jsonDragoes.escreverNomes(listaDragoes.getDragoesTemp());
    }

    public void salvarAlteracoes(){
        jsonDragoes.salvarAlteracoes(listaDragoes.getDragoesTemp());
        jsonDragoes.carregarDragoesJSON(listaDragoes.getDragoesDefinitivo());
    }

    public void ordenarDragoes(int entrada){
        ordenadorDragoes.quickSort(listaDragoes.getDragoesTemp(), 0, listaDragoes.getDragoesTemp().size() - 1, entrada);
    }

    public String buscaDragao(String nome){
        return "Posição do Dragão -> " + buscadorDragoes.buscaBinaria(0, listaDragoes.getDragoesTemp().size() - 1, nome);
    }

    public void inserirDragao(List<DragaoDTO> dragaoTemp){
        listaDragoes.inserirDragao(dragaoTemp);
    }

    public boolean deletarDragao(long id){
        return listaDragoes.deletarDragao(id);
    }

}