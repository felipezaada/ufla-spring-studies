package com.ufla.felipe.component;

import com.ufla.felipe.models.DragaoDTO;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaDragoes {

    @Getter
    final private List<DragaoDTO> dragoesSistema = new ArrayList<>();
    @Getter
    final private List<DragaoDTO> dragoesTemp = new ArrayList<>();

    public void cloneTemp() {
        dragoesTemp.addAll(dragoesSistema);
    }

    public DragaoDTO getDragao(int posicao){
        return dragoesSistema.get(posicao);
    }

    public DragaoDTO getDragaoTemp(int posicao){
        return dragoesTemp.get(posicao);
    }

    public int contaDragao(){
        return dragoesSistema.size();
    }

    public void inserirDragao(List<DragaoDTO> novoDragao){
        dragoesSistema.addAll(novoDragao);
    }

    public boolean deletarDragao(long id){
        return dragoesSistema.removeIf(dragao -> dragao.getId() == id); // função lambda, não conhecia
    }
}
