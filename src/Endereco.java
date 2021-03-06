/*
 * A classe endereço armazenará o endereço completo de uma empresa ou funcionário
 */
public class Endereco {
  private Bairro bairro;
  private Cidade cidade;
  private Estado estado;

  public Endereco(String bairro, String cidade, String estado) {
    this.bairro = new Bairro(bairro);
    this.cidade = new Cidade(cidade);
    this.estado = new Estado(estado);
  }

  public Bairro getBairro() {
    return bairro;
  }

  public void setBairro(Bairro bairro) {
    this.bairro = bairro;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Endereco {" +
        "bairro: '" + bairro.getNome() + '\'' +
        "cidade: '" + cidade.getNome() + '\'' +
        "estado: '" + estado.getNome() + '\'' +
      '}';
  }
}
