package com.ufla.felipe.component;

import com.ufla.felipe.controllers.DragoesController;
import com.ufla.felipe.models.DragaoDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class jsonDragoes {

    ObjectMapper mapper = new ObjectMapper();

    public void carregarDragoesJSON(List<DragaoDTO> dragoesList) {
        try {
            ClassPathResource resource = new ClassPathResource("json/dragoes.json");
            dragoesList.addAll(mapper.readValue(resource.getInputStream(), new TypeReference<>(){}));
            System.out.println("Inserido com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar.", e);
        }
    }

    public void salvarAlteracoes(List<DragaoDTO> dragoesList){
        try{
            mapper.writeValue(new File("data/dragoes.json"), dragoesList);
            System.out.println("Gravado com sucesso!");
        } catch (JacksonException e) {
            throw new RuntimeException("Erro ao salvar.", e);
        }
    }

    public String escreverNomes(List<DragaoDTO> dragoesList){
        StringBuilder info = new StringBuilder();
        for (DragaoDTO dragaoTemp : dragoesList) {
            info.append(dragaoTemp.getId())
                    .append(" ").append(dragaoTemp.getNome())
                    .append(" ").append(dragaoTemp.getNivel())
                    .append(" ").append(dragaoTemp.getVida())
                    .append(" ").append(dragaoTemp.getAtaque())
                    .append(" ").append(dragaoTemp.getChanceCritico())
                    .append(" ").append(dragaoTemp.getHabEspecial())
                    .append('\n');
        }
        return info.toString();
    }
}
