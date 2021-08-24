/*
 * A classe bairro armazena o nome do estado que comporá o endereço
 */
public class Estado {
  private String nome;

  public Estado(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
