/*
 * A classe cidade armazena o nome da cidade que comporá o endereço
 */
public class Cidade {
  private String nome;

  public Cidade(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
