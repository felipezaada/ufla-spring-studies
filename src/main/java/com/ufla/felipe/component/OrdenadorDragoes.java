package com.ufla.felipe.component;

import com.ufla.felipe.models.DragaoDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrdenadorDragoes{

    private final ListaDragoes listaDragoes;

    public OrdenadorDragoes(ListaDragoes listaDragoes) {
        this.listaDragoes = listaDragoes;
    }

    public boolean comparaEntradaQuickSort(int fim, int j, int entrada) {
        DragaoDTO pivot = listaDragoes.getDragao(fim);
        DragaoDTO dragaoJ = listaDragoes.getDragao(j);
        switch (entrada) {
            case 0:
                return dragaoJ.getNome().compareTo(pivot.getNome()) < 0;
            case 1:
                return dragaoJ.getTipo().compareTo(pivot.getTipo()) < 0;
            case 2:
                return dragaoJ.getId() < pivot.getId();
            default:
                return false;
        }
    }

    public int partition(int inicio, int fim, int entrada){
        int i = inicio;

        for(int j = inicio; j < fim; j++){
            if(comparaEntradaQuickSort(fim, j, entrada)){
                DragaoDTO aux = listaDragoes.getDragao(i);
                listaDragoes.setDragao(i, listaDragoes.getDragao(j));
                listaDragoes.setDragao(j, aux);
                i++;
            }
        }
        DragaoDTO aux = listaDragoes.getDragao(i);
        listaDragoes.setDragao(i, listaDragoes.getDragao(fim));
        listaDragoes.setDragao(fim, aux);

        return i;
    }

    public void quickSort(int inicio, int fim, int entrada){
        if(inicio < fim){
            int p = partition(inicio, fim, entrada);
            quickSort(inicio, p - 1, entrada);
            quickSort(p + 1, fim, entrada);
        }
    }
}
