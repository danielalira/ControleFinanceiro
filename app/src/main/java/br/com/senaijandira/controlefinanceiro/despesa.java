package br.com.senaijandira.controlefinanceiro;


public class despesa {

    private String data;
    private String categoria;
    private String descricao;
    private String valor;
    private Integer id;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {

        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getId () {return id;}

    public void setId(Integer id) {
        this.id = id;
    }
}
