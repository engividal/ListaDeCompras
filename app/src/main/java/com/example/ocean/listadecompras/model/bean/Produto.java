package com.example.ocean.listadecompras.model.bean;

/**
 * Created by Ocean on 09/02/2015.
 *
 * Classe entidade para armazenar dados de Produtos
 *
 */
public class Produto {

    private Long id;
    private String nome = null;
    private String imagem = null;
    private Boolean selected = false;

    public Produto() {

    }

    public Produto(String nome, String imagem, Boolean selected) {
        this.nome = nome;
        this.imagem = imagem;
        this.selected = selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean isSelected() {
        return selected;
    }

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
