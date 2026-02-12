package com.ufla.felipe.controllers;

import com.ufla.felipe.models.DragaoDTO;
import com.ufla.felipe.service.DragaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adm")
public class DragoesController {

    private final DragaoService dragaoService;

    public DragoesController(DragaoService dragaoService) {
        this.dragaoService = dragaoService;
    }

    @GetMapping("/escrever")
    public String escrever(){
        return dragaoService.escreverDragoes();
    }

    @GetMapping("/ordenar/nome")
    public void ordenarNome(){ dragaoService.ordenarDragoes(0); }

    @GetMapping("/ordenar/tipo")
    public void ordenarTipo(){ dragaoService.ordenarDragoes(1); }

    @GetMapping("/ordenar/id")
    public void ordenarId(){ dragaoService.ordenarDragoes(2); }

    @GetMapping("/buscar")
    public String buscar(@RequestParam String nome){
        return dragaoService.buscaDragao(nome);
    }

    @PostMapping("/inserir")
    public void inserir(@RequestBody List<DragaoDTO> novosDragoes){
        dragaoService.inserirDragao(novosDragoes);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletar(@RequestParam long id) {
        boolean removido = dragaoService.deletarDragao(id);
        if (removido) return ResponseEntity.ok("Dragão removido!");
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dragão não encontrado.");
    }
}
