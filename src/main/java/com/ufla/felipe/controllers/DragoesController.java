package com.ufla.felipe.controllers;

import com.ufla.felipe.models.Dragao;
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

    @PostMapping("/inserir")
    public void inserirDragoes(@RequestBody List<Dragao> novosDragoes) {
        dragaoService.inserirDragao(novosDragoes);
    }

    @GetMapping("/buscar")
    public String listarDragoes(@RequestParam String nome) {
        return "posicao do dragao: " + dragaoService.buscaBinaria(0, dragaoService.contaDragao() - 1, nome);
    }

    @GetMapping("/quick")
    public void quickSort(){
        dragaoService.quickSort(0, dragaoService.contaDragao() - 1);
    }

    @GetMapping("/escrever")
    public String escrever(){
        return dragaoService.escreverNomes();
    }
}
