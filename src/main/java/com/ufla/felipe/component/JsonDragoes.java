package com.ufla.felipe.component;

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
public class JsonDragoes {

    File data = new File("data/dragoes.json");
    ClassPathResource resource = new ClassPathResource("json/dragoes.json");
    ObjectMapper mapper = new ObjectMapper();

    public void carregarDragoesJSON(List<DragaoDTO> dragoesList) {
        try {
            dragoesList.clear();
            if (data.exists()) {
                dragoesList.addAll(mapper.readValue(data, new TypeReference<>() {}));
            } else {
                dragoesList.addAll(mapper.readValue(resource.getInputStream(), new TypeReference<>() {}));
            }
        }catch (IOException e) {
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
