package com.ufla.felipe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DragaoDTO {
    private int id;
    private String nome;
    private String tipo;
    private int nivel;
    private int vida;
    private int ataque;
    private float chanceCritico;
    private String habEspecial;
}
