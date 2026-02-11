package com.ufla.felipe.controllers;

import com.ufla.felipe.models.DragaoDTO;
import com.ufla.felipe.service.DragaoService;
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

    @GetMapping("/ordenar")
    public void ordenar(){ dragaoService.ordenarDragoes(); }

    @GetMapping("/buscar")
    public String buscar(@RequestParam String nome){
        return dragaoService.buscaDragao(nome);
    }

    @PostMapping("/inserir")
    public void inserir(@RequestBody List<DragaoDTO> novosDragoes){
        dragaoService.inserirDragao(novosDragoes);
    }
}
