import java.util.ArrayList;

public class Empresa {
  private String nome;
  private String cnpj;
  private Endereco endereco;
  private String telefone;
  private String email;
  private String dono;
  
  ArrayList<Contrato> contratos = new ArrayList<Contrato>();

  public Empresa(String nome, String cnpj, Endereco endereco, String telefone, String email, String dono) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
    this.telefone = telefone;
    this.email = email;
    this.dono = dono;
  }

  public void adimitirFuncionario(Contrato contrato){
    for (Contrato c : contratos) {
      if (c.getFuncionario().getNome().equals(contrato.getFuncionario().getNome())) {
        return;
      }
    }

    contratos.add(contrato);
  } 

  public void procurarContratoParaDemissão(String cpf) {
    for (Contrato c : contratos) {
      if (c.getFuncionario().getCpf().equals(cpf)) {
        contratos.remove(c);
        return;
      }
    }

    System.out.println("Não foi encontrado nenhum contrato para a demissão do funcionário com CPF: " + cpf);
  }

  public Funcionario consultarFuncionario(String cpfOuNome){
    for (Contrato c : contratos) {
      if (c.getFuncionario().getCpf().equals(cpfOuNome) || c.getFuncionario().getNome().equals(cpfOuNome)) {
        return c.getFuncionario();
      }
    }

    return null;
  }

  public void mostrarTodosOsFuncionarios(){
    for (Contrato c : contratos) {
      System.out.println(c.getFuncionario().toString());
    }
  }

  public void mostrarFuncionariosPorSetorSexoEstado(String setorNome, String sexoFuncionario, String estadoFuncionario){
    for (Contrato c : contratos) {
      if (c.getSetor().getNome().equals(setorNome)){
        if (c.getFuncionario().getSexo().equals(sexoFuncionario) && c.getFuncionario().getEndereco().getEstado().getNome().equals(estadoFuncionario)){
          System.out.println(c.getFuncionario().toString());
        }
      }else{
        System.out.println("Setor não encontrado");
      }
    }

    System.out.println("Nenhum funcionário encontrado");
  }

  public void listarContratos(){
    for (Contrato c : contratos) {
      System.out.println(c.toString());
    }
  }

  public Contrato buscarContratoPorId(String contratoId){
    for (Contrato c : contratos) {
      if (c.getId().equals(contratoId)) {
        return c;
      }
    }

    return null;
  }

  public Funcionario listarFuncionarioDeMaiorSalario(){
    Funcionario funcionarioMaiorSalario = null;
    double maiorSalario = 0;

    for (Contrato c : contratos) {
      if (c.getSalario() > maiorSalario) {
        maiorSalario = c.getSalario();
        funcionarioMaiorSalario = c.getFuncionario();
      }
    }

    return funcionarioMaiorSalario;
  }

  public Funcionario listarFuncionarioDeMenorSalario(){
    Funcionario funcionarioMenorSalario = null;
    double menorSalario = 0;

    for (Contrato c : contratos) {
      if (c.getSalario() < menorSalario) {
        menorSalario = c.getSalario();
        funcionarioMenorSalario = c.getFuncionario();
      }
    }

    return funcionarioMenorSalario;
  }

  public String listarFolhaDePagamento(){
    String folhaDePagamento = "";
    double salarioTotal = 0.00;

    for (Contrato c : contratos){
      folhaDePagamento += "Setor: " + c.getSetor().getNome() + " | " + "Funcionario: " + c.getFuncionario().getNome() + " | " + "Salario: R$ " + c.getSalario() + " | " + "Cargo: " + c.getCargo().getCargo() + "\n";
      salarioTotal += c.getSalario();
    }

    return folhaDePagamento+"Total de custos de pagamento dos funcionários: R$ " + salarioTotal;
  }

  public Contrato listarChefeDoSetor(Setor setor){
    for (Contrato c : contratos) {
      if (c.getSetor().equals(setor)){
        if(c.getCargo().getCargo().equals(Cargo.CHEFE)){
          return c;
        }
      }
    }

    return null;
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