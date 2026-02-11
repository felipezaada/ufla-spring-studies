package com.ufla.felipe.service;

import com.ufla.felipe.component.BuscadorDragoes;
import com.ufla.felipe.component.ListaDragoes;
import com.ufla.felipe.component.OrdenadorDragoes;
import com.ufla.felipe.component.jsonDragoes;
import com.ufla.felipe.models.DragaoDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DragaoService {

    private final BuscadorDragoes buscadorDragoes;
    private final ListaDragoes listaDragoes;
    private final OrdenadorDragoes ordenadorDragoes;
    private final jsonDragoes jsonDragoes;

    public DragaoService(BuscadorDragoes buscadorDragoes, ListaDragoes listaDragoes, OrdenadorDragoes ordenadorDragoes, jsonDragoes jsonDragoes) {
        this.buscadorDragoes = buscadorDragoes;
        this.listaDragoes = listaDragoes;
        this.ordenadorDragoes = ordenadorDragoes;
        this.jsonDragoes = jsonDragoes;
    }

    @PostConstruct
    public void init() {
        jsonDragoes.carregarDragoesJSON();
        System.out.println(jsonDragoes.escreverNomes());
    }

    public String escreverDragoes(){
        return jsonDragoes.escreverNomes();
    }

    public void ordenarDragoes(int entrada){
        ordenadorDragoes.quickSort(0, listaDragoes.contaDragao() - 1, entrada);
    }

    public String buscaDragao(String nome){
        return "Posição do Dragão -> " + buscadorDragoes.buscaBinaria(0, listaDragoes.contaDragao() - 1, nome);
    }

    public void inserirDragao(List<DragaoDTO> dragaoTemp){
        listaDragoes.inserirDragao(dragaoTemp);
    }

}