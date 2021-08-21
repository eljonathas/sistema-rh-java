public class Endereco {
  private Bairro bairro;
  private Cidade cidade;
  private Estado estado;

  public Endereco(Bairro bairro, Cidade cidade, Estado estado) {
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
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
    return "Endereco{" +
        "bairro=" + bairro +
        ", cidade=" + cidade +
        ", estado=" + estado +
        '}';
  }
}
