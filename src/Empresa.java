import java.util.ArrayList;
import java.util.Arrays;

public class Empresa {
  private String nome;
  private String cnpj;
  private Endereco endereco;
  private String telefone;
  private String email;
  private String dono;
  private ArrayList<Setor>setores = new ArrayList<Setor>(); 

  public Empresa(String nome, String cnpj, Endereco endereco, String telefone, String email, String dono) {
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

  public void procurarContratoParaDemissão(String cpf) {
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
        if (contrato.getFuncionario().getCpf().equals(cpfOuNome) || contrato.getFuncionario().getNome().toLowerCase().equals(cpfOuNome.toLowerCase())){
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
      if (setorNome.toLowerCase().equals(setor.getNome().toLowerCase())){
        for (Contrato contrato : setor.contratos){
          if(sexoFuncionario.toLowerCase().equals(contrato.getFuncionario().getSexo().toLowerCase()) && 
          estadoFuncionario.toLowerCase().equals(contrato.getFuncionario().getEndereco().getEstado().getNome().toLowerCase())){
            System.out.println(contrato.getFuncionario().toString());
          }else{
            System.out.println("Não encontrado");
          }
        }
      } else {
        System.out.println("Setor não encontrado");
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

  public Contrato buscarContratoPorId(String contratoId){
    for (Setor setor : setores){
      for (Contrato contrato : setor.contratos){
        if (contrato.getId().equals(contratoId)){
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

  public String listarFolhaDePagamento(){
    String folhaDePagamento = "";
    double salarioTotal = 0.00;

    for (Setor setor : setores){
      for (Contrato contrato : setor.contratos){
        folhaDePagamento += "Setor: " + setor.getNome() + " | " + "Funcionario: " + contrato.getFuncionario().getNome() + " | " + "Salario: R$ " + contrato.getSalario() + " | " + "Cargo: " + contrato.getCargo().getCargo() + "\n";
        salarioTotal += contrato.getSalario();
      }
    }

    return folhaDePagamento+"Total de custos de pagamento dos funcionários: R$ " + salarioTotal;
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

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
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
        "nome: '" + nome + '\'' +
        "cnpj: '" + cnpj + '\'' +
        "endereco: '" + endereco.toString() + '\'' +
        "telefone: '" + telefone + '\'' +
        "email: '" + email + '\'' +
        "dono: '" + dono + '\'' +
        '}';
  }
}