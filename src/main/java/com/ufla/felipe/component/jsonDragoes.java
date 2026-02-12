package com.ufla.felipe.component;

import com.ufla.felipe.models.DragaoDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class jsonDragoes {

    private final ListaDragoes listaDragoes;

    public jsonDragoes(ListaDragoes listaDragoes) {
        this.listaDragoes= listaDragoes;
    }

    public void carregarDragoesJSON() {
        try {
            ClassPathResource resource = new ClassPathResource("json/dragoes.json");
            listaDragoes.getDragoesDefinitivo().addAll(new ObjectMapper().readValue(resource.getInputStream(), new TypeReference<>(){}));
            System.out.println("Inserido com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar!");
        }
    }

    public String escreverNomes(){
        StringBuilder nomes = new StringBuilder();
        nomes.append("LISTA TEMPORARIA").append("\n");
        for (int i = 0 ; i < listaDragoes.getDragoesTemp().size() ; i++) {
            DragaoDTO dragaoTemp =  listaDragoes.getDragaoTemp(i);
            nomes.append(dragaoTemp.getId()).append(" Nome: ").append(dragaoTemp.getNome())
                    .append(" Tipo: ").append(dragaoTemp.getTipo()).append('\n');
        }

        nomes.append("\n").append("LISTA DEFINITIVA").append("\n");
        for (int i = 0; i < listaDragoes.getDragoesDefinitivo().size() ; i++) {
            DragaoDTO dragaoTemp =  listaDragoes.getDragao(i);
            nomes.append(dragaoTemp.getId()).append(" Nome: ").append(dragaoTemp.getNome())
                    .append(" Tipo: ").append(dragaoTemp.getTipo()).append('\n');
        }

        return nomes.toString();
    }
}
