/*
 * A classe bairro armazena o nome do bairro que comporá o endereço
 */
public class Bairro {
  private String nome;

  public Bairro(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
