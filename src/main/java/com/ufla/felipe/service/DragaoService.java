package com.ufla.felipe.service;

import com.ufla.felipe.models.DragaoModel;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DragaoService {

    private final List<DragaoModel> dragoesSistema = new ArrayList<>();

    @PostConstruct
    public void init() {
        carregarDragoesJSON();
        escreverNomes();
    }

    public int partition(int inicio, int fim){
        int i = inicio;
        DragaoModel pivot = dragoesSistema.get(fim);

        for(int j = inicio; j < fim; j++){
            DragaoModel dragaoJ = dragoesSistema.get(j);

            if(dragaoJ.getNome().compareTo(pivot.getNome()) < 0){
                DragaoModel aux = dragoesSistema.get(i);
                dragoesSistema.set(i, dragoesSistema.get(j));
                dragoesSistema.set(j, aux);
                i++;
            }
        }
        DragaoModel aux = dragoesSistema.get(i);
        dragoesSistema.set(i, dragoesSistema.get(fim));
        dragoesSistema.set(fim, aux);

        return i;
    }

    public void quickSort(int inicio, int fim){
        if(inicio < fim){
            int p = partition(inicio, fim);
            quickSort(inicio, p - 1);
            quickSort(p + 1, fim);
        }
    }

    public int buscaBinaria(int inicio, int fim, String k) {
        int meio = (inicio + fim) / 2;
        DragaoModel tempDragao = dragoesSistema.get(meio);

        if(inicio <= fim) {
            if (tempDragao.getNome().equals(k)) return meio;
            if (tempDragao.getNome().compareTo(k) < 0) return buscaBinaria(meio + 1, fim, k);
            return buscaBinaria(inicio, meio - 1, k);
        }
        return -1;
    }

    public String escreverNomes(){
        StringBuilder nomes = new StringBuilder();
        for (int i = 0 ; i < dragoesSistema.size() ; i++) {
            DragaoModel dragaoTemp =  dragoesSistema.get(i);
            nomes.append(dragaoTemp.getNome()).append('\n');
        }
        return nomes.toString();
    }

    public void inserirDragao(List<DragaoModel> novoDragao){
        dragoesSistema.addAll(novoDragao);
    }

    public int contaDragao(){
        return dragoesSistema.size();
    }

    public void carregarDragoesJSON() {
        try {
            ClassPathResource resource = new ClassPathResource("json/dragoes.json");
            List<DragaoModel> dragaoTemp = new ObjectMapper().readValue(resource.getInputStream(), new TypeReference<>(){});
            inserirDragao(dragaoTemp);
            System.out.println("Inserido com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar!");
        }
    }
}