package com.ufla.felipe.component;

import com.ufla.felipe.models.DragaoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdenadorDragoes{

    public boolean comparaEntradaQuickSort(List<DragaoDTO> dragoesList, int fim, int j, int entrada) {
        DragaoDTO pivot = dragoesList.get(fim);
        DragaoDTO dragaoJ = dragoesList.get(j);
        return switch (entrada) {
            case 0 -> dragaoJ.getNome().compareTo(pivot.getNome()) < 0;
            case 1 -> dragaoJ.getTipo().compareTo(pivot.getTipo()) < 0;
            case 2 -> dragaoJ.getId() < pivot.getId();
            default -> false;
        };
    }

    public int partition(List<DragaoDTO> dragoesList, int inicio, int fim, int entrada){
        int i = inicio;

        for(int j = inicio; j < fim; j++){
            if(comparaEntradaQuickSort(dragoesList, fim, j, entrada)){
                DragaoDTO aux = dragoesList.get(i);
                dragoesList.set(i, dragoesList.get(j));
                dragoesList.set(j, aux);
                i++;
            }
        }
        DragaoDTO aux = dragoesList.get(i);
        dragoesList.set(i, dragoesList.get(fim));
        dragoesList.set(fim, aux);

        return i;
    }

    public void quickSort(List<DragaoDTO> dragoesList, int inicio, int fim, int entrada){
        if(inicio < fim){
            int p = partition(dragoesList, inicio, fim, entrada);
            quickSort(dragoesList, inicio, p - 1, entrada);
            quickSort(dragoesList, p + 1, fim, entrada);
        }
    }
}
