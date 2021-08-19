import java.util.ArrayList;

public class Empresa {
  private String nome;
  private String cnpj;
  private String endereco;
  private String telefone;
  private String email;
  private String dono;
  private ArrayList<Contrato>contratos = new ArrayList<Contrato>(); 

  public Empresa(String nome, String cnpj, String endereco, String telefone, String email, String dono) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
    this.telefone = telefone;
    this.email = email;
    this.dono = dono;
  }

  public void contratarFuncionario(Contrato contrato){
        contratos.add(contrato);
  }

  public void demitirFuncionario(String cpf){
      for (Contrato contrato : contratos){
          if (contrato.getFuncionario().getCpf() == cpf)
          contratos.remove(contrato);
      }
        
  }

  public Funcionario consultarFuncionario(String cpfOuNome) {
      for (Contrato contrato : contratos) {
          Funcionario funcionario = contrato.getFuncionario();
          
          if (funcionario.getNome() == cpfOuNome || funcionario.getCpf() == cpfOuNome) {
              return funcionario;
          }
      }

      return null;
  }
 
  public void mostrarTodosOsFuncionarios() {
     for (Contrato contrato : contratos) {
          Funcionario funcionario = contrato.getFuncionario();
          System.out.println(funcionario);
      }   
  }

  public void mostrarFuncionariosPorSetor(Setor setor) {
      for (Contrato contrato : contratos) {
          Funcionario funcionario = contrato.getFuncionario();
          if (funcionario.getSetor() == setor) {
              System.out.println(funcionario);
          }
      }
  }
  
  public Funcionario mostrarFuncionariosPorSetor(String sexo) {
      for (Contrato contrato : contratos) {
          Funcionario funcionario = contrato.getFuncionario();
          if (funcionario.getSexo() == setor) {
              System.out.println(funcionario);
          }
      }
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDono() {
    return dono;
  }

  public void setDono(String dono) {
    this.dono = dono;
  }

  @Override
  public String toString() {
    return "Empresa{" +
        "nome='" + nome + '\'' +
        ", cnpj='" + cnpj + '\'' +
        ", endereco='" + endereco + '\'' +
        ", telefone='" + telefone + '\'' +
        ", email='" + email + '\'' +
        ", dono='" + dono + '\'' +
        '}';
  }
}