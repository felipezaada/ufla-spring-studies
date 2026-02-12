package com.ufla.felipe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DragaoDTO {
    private long id; // id's longos, optei por long
    private String nome;
    private String tipo;
    private int nivel;
    private int vida;
    private int ataque;
    private float chanceCritico;
    private String habEspecial;
}
