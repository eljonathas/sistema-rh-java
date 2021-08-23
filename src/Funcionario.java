public class Funcionario {
  private String nome;
  private String sobrenome;
  private Endereco endereco;
  private String cpf;
  private int idade;
  private String sexo;
  private String telefone;

  public Funcionario(String nome, String sobrenome, Endereco endereco, String cpf, int idade, String sexo, String telefone) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.endereco = endereco;
    this.cpf = cpf;
    this.idade = idade;
    this.sexo = sexo;
    this.telefone = telefone;
  }

  public String getNome() {
    return nome+" "+sobrenome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  @Override
  public String toString() {
    return "Funcionario {" +
        "nome: '" + nome + '\'' +
        "sobrenome: '" + sobrenome + '\'' +
        "endereco: " + endereco.toString() +
        "cpf: '" + cpf + '\'' +
        "idade: " + idade +
        "sexo: '" + sexo + '\'' +
        "telefone: '" + telefone + '\'' +
      '}';
  }
}
