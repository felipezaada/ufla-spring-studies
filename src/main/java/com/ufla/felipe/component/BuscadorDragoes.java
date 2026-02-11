package com.ufla.felipe.component;

import com.ufla.felipe.models.DragaoDTO;
import org.springframework.stereotype.Component;

@Component
public class BuscadorDragoes {

    private final ListaDragoes listaDragoes;

    public BuscadorDragoes(ListaDragoes listaDragoes) {
        this.listaDragoes = listaDragoes;
    }

    public int buscaBinaria(int inicio, int fim, String k) {
        int meio = (inicio + fim) / 2;
        DragaoDTO tempDragao = listaDragoes.getDragao(meio);

        if(inicio <= fim) {
            if (tempDragao.getNome().equals(k)) return meio;
            if (tempDragao.getNome().compareTo(k) < 0) return buscaBinaria(meio + 1, fim, k);
            return buscaBinaria(inicio, meio - 1, k);
        }
        return -1;
    }
}
