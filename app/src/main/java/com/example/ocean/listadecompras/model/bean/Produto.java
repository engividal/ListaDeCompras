package com.example.ocean.listadecompras.model.bean;

/**
 * Created by Ocean on 09/02/2015.
 *
 * Classe entidade para armazenar dados de Produtos
 *
 */
public class Produto {

    private Long id;
    private String nome;
    private String imagem;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
