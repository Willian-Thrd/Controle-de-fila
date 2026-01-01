package org.will;

import javafx.beans.property.SimpleStringProperty;

public class listaInputs {
    private final SimpleStringProperty nome;
    private final SimpleStringProperty tel;
    private final SimpleStringProperty endereco;
    private final SimpleStringProperty metodo;
    private final SimpleStringProperty id;
    private final SimpleStringProperty hr;
    private final SimpleStringProperty retirada;
    private final SimpleStringProperty nota;

    public listaInputs(String nome, String tel, String endereco, String metodo, String id, String hr, String retirada, String nota) {
        this.nome = new SimpleStringProperty(nome);
        this.tel = new SimpleStringProperty(tel);
        this.endereco = new SimpleStringProperty(endereco);
        this.metodo = new SimpleStringProperty(metodo);
        this.id = new SimpleStringProperty(id);
        this.hr = new SimpleStringProperty(hr);
        this.retirada = new SimpleStringProperty(retirada);
        this.nota = new SimpleStringProperty(nota);
    }

    public String getNome() {
        return nome.get();
    }

    public String getTel() {
        return tel.get();
    }

    public String getEndereco() {
        return endereco.get();
    }

    public String getMetodo() {
        return metodo.get();
    }

    public String getId() {
        return id.get();
    }

    public String getHr() {
        return hr.get();
    }

    public String getRetirada() {
        return retirada.get();
    }

    public String getNota() {
        return nota.get();
    }
}
