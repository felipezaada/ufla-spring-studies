package com.ufla.felipe.component;

import com.ufla.felipe.models.DragaoDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@Component
public class jsonDragoes {

    public void carregarDragoesJSON(List<DragaoDTO> dragoesList) {
        try {
            ClassPathResource resource = new ClassPathResource("json/dragoes.json");
            dragoesList.addAll(new ObjectMapper().readValue(resource.getInputStream(), new TypeReference<>(){}));
            System.out.println("Inserido com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar!");
        }
    }

    public String escreverNomes(List<DragaoDTO> dragoesList){
        StringBuilder nomes = new StringBuilder();
        for (int i = 0 ; i < dragoesList.size() ; i++) {
            DragaoDTO dragaoTemp =  dragoesList.get(i);
            nomes.append(dragaoTemp.getId()).append(" Nome: ").append(dragaoTemp.getNome())
                    .append(" Tipo: ").append(dragaoTemp.getTipo()).append('\n');
        }
        return nomes.toString();
    }
}
