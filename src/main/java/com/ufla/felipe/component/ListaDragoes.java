package com.ufla.felipe.component;

import com.ufla.felipe.models.DragaoDTO;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaDragoes {

    @Getter
    final private List<DragaoDTO> dragoesDefinitivo = new ArrayList<>();
    @Getter
    final private List<DragaoDTO> dragoesTemp = new ArrayList<>();

    public void cloneTemp() { dragoesTemp.addAll(dragoesDefinitivo); }

    public DragaoDTO getDragao(int posicao){
        return dragoesDefinitivo.get(posicao);
    }

    public DragaoDTO getDragaoTemp(int posicao){
        return dragoesTemp.get(posicao);
    }

    public void inserirDragao(List<DragaoDTO> novoDragao){
        dragoesTemp.addAll(novoDragao);
    }

    public boolean deletarDragao(long id){
        return dragoesTemp.removeIf(dragao -> dragao.getId() == id); // função lambda, não conhecia
    }
}
