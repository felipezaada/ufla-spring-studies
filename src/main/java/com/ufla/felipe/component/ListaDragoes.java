package com.ufla.felipe.component;

import com.ufla.felipe.models.DragaoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaDragoes {
    private final List<DragaoDTO> dragoesSistema = new ArrayList<>();

    public DragaoDTO getDragao(int posicao){
        return dragoesSistema.get(posicao);
    }

    public void setDragao(int posicao, DragaoDTO dragao){
        dragoesSistema.set(posicao, dragao);
    }

    public int contaDragao(){
        return dragoesSistema.size();
    }

    public void inserirDragao(List<DragaoDTO> novoDragao){
        dragoesSistema.addAll(novoDragao);
    }
}
