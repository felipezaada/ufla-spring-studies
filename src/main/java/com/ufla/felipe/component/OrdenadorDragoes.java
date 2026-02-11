package com.ufla.felipe.component;

import com.ufla.felipe.models.DragaoDTO;
import org.springframework.stereotype.Component;

@Component
public class OrdenadorDragoes{

    private final ListaDragoes listaDragoes;

    public OrdenadorDragoes(ListaDragoes listaDragoes) {
        this.listaDragoes = listaDragoes;
    }

    public int partition(int inicio, int fim){
        int i = inicio;
        DragaoDTO pivot = listaDragoes.getDragao(fim);

        for(int j = inicio; j < fim; j++){
            DragaoDTO dragaoJ = listaDragoes.getDragao(j);

            if(dragaoJ.getNome().compareTo(pivot.getNome()) < 0){
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

    public void quickSort(int inicio, int fim){
        if(inicio < fim){
            int p = partition(inicio, fim);
            quickSort(inicio, p - 1);
            quickSort(p + 1, fim);
        }
    }
}
