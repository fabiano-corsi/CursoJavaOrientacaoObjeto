package br.com.alura.consultacep.modelos;

public class Endereco {
    // region Atributos
    // Código de Endereçamento Postal (CEP), um identificador
    private String cep;

    // Nome da rua, avenida, praça, etc.
    private String logradouro;

    // Nome do bairro
    private String bairro;

    // Nome da cidade
    private String localidade;

    // Unidade Federativa (UF), sigla
    private String uf;

    // Nome completo do estado
    private String estado;

    // Nome da região (Norte, Sul, Sudeste, etc.)
    private String regiao;

    // Código de Discagem Direta a Distância (DDD), um identificador
    private String ddd;

    // Código SIAFI
    private String siafi;
    //endregion

    public Endereco(String cep, String logradouro, String bairro, String localidade, String uf, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.estado = estado;
    }

    //region Setters
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
    //endregion

    //region Getters
    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getEstado() {
        return estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getDdd() {
        return ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    //endregion


    @Override
    public String toString() {
        return """
                -------------------------
                Cep: %s
                Logradouro: %s
                Bairro: %s
                Localidade: %s
                UF: %s
                Estado: %s
                -------------------------
                """.formatted(this.getCep(),
                    this.getLogradouro(),
                    this.getBairro(),
                    this.getLocalidade(),
                    this.getUf(),
                    this.getEstado());
    }
}
