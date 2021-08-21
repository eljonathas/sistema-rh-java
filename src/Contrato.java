public class Contrato {
  private Funcionario funcionario;
  private int id;
  private double salario;
  private Cargo cargo;
  private Setor setor;

  public Contrato(Funcionario funcionario, int id, double salario, Cargo cargo, Setor setor) {
    this.id = id;
    this.funcionario = funcionario;
    this.salario = salario;
    this.setor = setor;
    this.cargo = cargo;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  public Setor getSetor() {
    return setor;
  }

  public void setSetor(Setor setor) {
    this.setor = setor;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public Cargo getCargo() {
    return cargo;
  }

  public void setCargo(Cargo cargo) {
    this.cargo = cargo;
  }

  @Override
  public String toString() {
    return "Contrato{" +
        "funcionario=" + funcionario.getNome() +
        ", id=" + id +
        ", salario=" + salario +
        ", cargo='" + cargo + '\'' +
      '}';
  }
}