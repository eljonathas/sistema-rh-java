import java.util.ArrayList;
import java.util.Arrays;

public class Empresa {
  private String nome;
  private String cnpj;
  private String endereco;
  private String telefone;
  private String email;
  private String dono;
  private ArrayList<Setor>setores = new ArrayList<Setor>(); 

  public Empresa(String nome, String cnpj, String endereco, String telefone, String email, String dono) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
    this.telefone = telefone;
    this.email = email;
    this.dono = dono;
    Setor[] setoresCadastrados = {Setor.REQUISITOS, Setor.MODELAGEM, Setor.CODIFICACAO, Setor.TESTES, Setor.RECURSOS_HUMANOS};
    setores.addAll(Arrays.asList(setoresCadastrados));
  }

  public void adimitirFuncionario(Contrato contrato){
    for (Setor setor : setores){
      if (contrato.getSetor() == setor){        
        setor.contratarFuncionario(contrato);
      }
    }
  } 

  public void procurarContratoParaDemição(String cpf) {
    for (Setor setor : setores){
      for (Contrato contrato : setor.contratos){
        if (contrato.getFuncionario().getCpf().equals(cpf)){
          setor.demitirFuncionario(contrato);
        }
      }
    }
  }

  public Funcionario consultarFuncionario(String cpfOuNome){
    for (Setor setor : setores){
      for (Contrato contrato : setor.contratos){
        if (contrato.getFuncionario().getCpf().equals(cpfOuNome) || contrato.getFuncionario().getNome().equals(cpfOuNome)){
          return contrato.getFuncionario();
        }
      }
    }

    return null;
  }

  public void mostrarTodosOsFuncionarios(){
    for (Setor setor : setores){
      for (Contrato contrato : setor.contratos){
        System.out.println(contrato.getFuncionario().toString());
      }
    }
  }

  public void mostrarFuncionariosPorSetorSexoEstado(String setorNome, String sexoFuncionario, String estadoFuncionario){
    for (Setor setor : setores){
      if (setor.getNome() == setorNome){
        for (Contrato contrato : setor.contratos){
          if(contrato.getFuncionario().getSexo() == sexoFuncionario && 
          contrato.getFuncionario().getEndereco().getEstado().getNome() == estadoFuncionario){
            System.out.println(contrato.getFuncionario().toString());
          }
        }
      }
    }
  }

  public void listarContratos(){
    for (Setor setor : setores){
      for (Contrato contrato : setor.contratos){
        System.out.println(contrato.toString());
      }
    }
  }

  public Contrato buscarContratoPorId(int contratoId){
    for (Setor setor : setores){
      for (Contrato contrato : setor.contratos){
        if (contrato.getId() == contratoId){
          return contrato;
        }
      }
    }
    return null;
  }

  public Funcionario listarFuncionarioDeMaiorSalario(){
    Funcionario funcionarioMaiorSalario = null;
    double maiorSalario = 0;

    for (Setor setor : setores){
      for (Contrato contrato : setor.contratos){
        if (contrato.getSalario() > maiorSalario){
          maiorSalario = contrato.getSalario();
          funcionarioMaiorSalario = contrato.getFuncionario();
        }
      }
    }

    return funcionarioMaiorSalario;
  }

  public Funcionario listarFuncionarioDeMenorSalario(){
    Funcionario funcionarioMenorSalario = null;
    double menorSalario = 0;

    for (Setor setor : setores){
      for (Contrato contrato : setor.contratos){
        if (contrato.getSalario() < menorSalario){
          menorSalario = contrato.getSalario();
          funcionarioMenorSalario = contrato.getFuncionario();
        }
      }
    }

    return funcionarioMenorSalario;
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