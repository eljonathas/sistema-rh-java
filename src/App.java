import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

enum Setor {
  REQUISITOS("Requisitos"),
  MODELAGEM("Modelagem"),
  CODIFICACAO("Codificação"),
  TESTES("Testes"),
  RECURSOS_HUMANOS("Recursos Humanos");

  ArrayList<Contrato> contratos = new ArrayList<Contrato>();
  private String nome;

  private Setor(String nome){
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void contratarFuncionario(Contrato contrato){
    contratos.add(contrato);
  }

  public void demitirFuncionario(Contrato contrato){
    contratos.remove(contrato);
  }
}

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite o nome da empresa: ");
    String nomeEmpresa = scanner.nextLine();
    System.out.println("Digite os números do cnpj: ");
    String cnpj = scanner.nextLine();
    System.out.println("Digite o endereço da empresa: ");
    String endereco = scanner.nextLine();
    System.out.println("Digite o telefone da empresa: ");
    String telefone = scanner.nextLine();
    System.out.println("Digite o email da empresa: ");
    String email = scanner.nextLine();
    System.out.println("Digite o nome do dono da empresa: ");
    String nomeDono = scanner.nextLine();

    Empresa empresa = new Empresa(nomeEmpresa, cnpj, endereco, telefone, email, nomeDono);
    /*
    System.out.println("""
    Digite a opção desejada:
    1 - Admitir funcionário
    2 - Consultar funcionário por nome ou cpf
    3 - Atualizar dados contratuais ou pessoais do funcionário
    4 - Demitir funcionário por cpf
    5 - Listar todos os funcionários
    6 - Listar todos os funcionários por setor, sexo e estado
    7 - Listar funcionário com maior salário
    8 - Listar funcionário com menor salário
    """);
    */

    int opcao = Integer.parseInt(scanner.nextLine());

    switch (opcao) {
      case 1:
        System.out.println("Digite o nome do funcionário: ");
        String nomeFuncionario = scanner.nextLine();

        System.out.println("Digite o sobrenome do funcionário: ");
        String sobrenomeFuncionario = scanner.nextLine();

        System.out.println("Digite a idade do funcionário: ");
        int idadeFuncionario = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o cpf do funcionário: ");
        String cpfFuncionario = scanner.nextLine();

        System.out.println("Digite o telefone do funcionário: ");
        String telefoneFuncionario = scanner.nextLine();

        System.out.println("Digite o cidade do funcionário: ");
        String cidadeFuncionario = scanner.nextLine();

        System.out.println("Digite o bairro do funcionário: ");
        String bairroFuncionario = scanner.nextLine();

        System.out.println("Digite o estado do funcionário: ");
        String estadoFuncionario = scanner.nextLine();
        
        System.out.println("Digite o sexo do funcionário: ");
        String sexoFuncionario = scanner.nextLine();

        String setorFuncionario;

        String cargoFuncionario;

        Contrato contrato = null;

        Setor setor = null;

        int randomId = (int) (Math.random() * Math.pow(10, 5));

        do {
          System.out.println("Digite o setor do funcionário, escolha entre ["+Setor.TESTES.getNome()+", "+Setor.REQUISITOS.getNome()+", "+Setor.MODELAGEM.getNome()+", "+Setor.CODIFICACAO.getNome()+", "+Setor.RECURSOS_HUMANOS.getNome()+"]: ");
          setorFuncionario = (scanner.nextLine()).toLowerCase();
        } while (!setorFuncionario.equals(Setor.REQUISITOS.getNome().toLowerCase()) && !setorFuncionario.equals(Setor.MODELAGEM.getNome().toLowerCase()) && !setorFuncionario.equals(Setor.CODIFICACAO.getNome().toLowerCase()) && !setorFuncionario.equals(Setor.TESTES.getNome().toLowerCase()) && !setorFuncionario.equals(Setor.RECURSOS_HUMANOS.getNome().toLowerCase()));

        do {
          System.out.println("Digite o cargo do funcionário, escolha entre ["+Cargo.CHEFE.getCargo()+", "+Cargo.COLABORADOR.getCargo()+"]: ");
          cargoFuncionario = scanner.nextLine();
        } while (!cargoFuncionario.equals(Cargo.CHEFE.getCargo()) && !cargoFuncionario.equals(Cargo.COLABORADOR.getCargo()));

        System.out.println("Digite o salário do funcionário: ");
        double salarioFuncionario = scanner.nextDouble();

        Endereco enderecoFuncionario = new Endereco(bairroFuncionario, cidadeFuncionario, estadoFuncionario);

        Funcionario funcionario = new Funcionario(nomeFuncionario, sobrenomeFuncionario, enderecoFuncionario, cpfFuncionario, idadeFuncionario, sexoFuncionario, telefoneFuncionario);

        switch(setorFuncionario) {
          case "requisitos":
            setor = Setor.REQUISITOS;
            break;
          case "modelagem":
            setor = Setor.MODELAGEM;
            break;
          case "codificacao":
            setor = Setor.CODIFICACAO;
            break;
          case "testes":
            setor = Setor.TESTES;
            break;
          case "recursos humanos":
            setor = Setor.RECURSOS_HUMANOS;
            break;
        }

        contrato = new Contrato(
          funcionario, 
          randomId, 
          salarioFuncionario, 
          cargoFuncionario.equals(Cargo.CHEFE.getCargo().toLowerCase()) ? Cargo.CHEFE : Cargo.COLABORADOR,
          setor 
        );

        empresa.adimitirFuncionario(contrato);
        System.out.println("Contrato ["+randomId+": "+funcionario.getNome()+"] criado com sucesso!");
        break;
      case 2:
        System.out.println("Digite o cpf ou nome do funcionário: ");
        String cpfOuNomeFuncionarioConsulta = scanner.nextLine();

        Funcionario funcionarioConsulta = empresa.consultarFuncionario(cpfOuNomeFuncionarioConsulta);

        if (funcionarioConsulta != null) {
          System.out.println("Funcionário encontrado: ");
          System.out.println(funcionarioConsulta);
        } else {
          System.out.println("Funcionário não encontrado!");
        }
        break;
      case 3:
        System.out.println("Lista de contratos: ");
        empresa.listarContratos();
        System.out.println("Digite o id do contrato desejado com base nos dados acima: ");
        int idContrato = Integer.parseInt(scanner.nextLine());

        Contrato contratoBuscado = empresa.buscarContratoPorId(idContrato);

        if (contratoBuscado == null) {
          System.out.println("Contrato não encontrado!");
          break;
        } else {
        /*
        System.out.println("""
        Escolha a opção desejada:
        1 - Alterar salário
        2 - Alterar cargo
        3 - Alterar setor
        4 - Alterar dados pessoais do funcionário
        """);
        */

        int opcaoAlteracao = Integer.parseInt(scanner.nextLine());

        switch(opcaoAlteracao) {
          case 1:
            System.out.println("Digite o novo salário: ");
            double novoSalario = scanner.nextDouble();
            contratoBuscado.setSalario(novoSalario);
            System.out.println("Salário alterado com sucesso!");
            break;
          case 2:
            System.out.println("Digite o novo cargo: ");
            String novoCargo = scanner.nextLine().toLowerCase();
            contratoBuscado.setCargo(novoCargo.equals(Cargo.CHEFE.getCargo().toLowerCase()) ? Cargo.CHEFE : Cargo.COLABORADOR);
            System.out.println("Cargo alterado com sucesso!");
            break;
          case 3:
            System.out.println("Digite o novo setor: ");
            String novoSetor = scanner.nextLine().toLowerCase();

            Setor novoObjetoSetor;

            switch(novoSetor) {
              case "requisitos":
                novoObjetoSetor = Setor.REQUISITOS;
                break;
              case "modelagem":
                novoObjetoSetor = Setor.MODELAGEM;
                break;
              case "codificacao":
                novoObjetoSetor = Setor.CODIFICACAO;
                break;
              case "testes":
                novoObjetoSetor = Setor.TESTES;
                break;
              case "recursos humanos":
                novoObjetoSetor = Setor.RECURSOS_HUMANOS;
                break;
              default: 
                System.out.println("Setor inválido!");
                break;
            }
            contratoBuscado.setSetor(novoObjetoSetor);
            break;

          case 4:
            /*
        System.out.println("""
        Escolha a opção desejada:
        1 - Alterar nome
        2 - Alterar sobrenome
        3 - Alterar endereço
        4 - Alterar CPF
        5 - Alterar idade
        6 - Alterar telefone
        """);
        */
            opcaoAlteracao = Integer.parseInt(scanner.nextLine());
            funcionario = contratoBuscado.getFuncionario();

            switch(opcaoAlteracao) {
              case 1:
                System.out.println("Informe o novo nome:");
                nomeFuncionario = scanner.nextLine().toUpperCase();
                funcionario.setNome(nomeFuncionario);
                break;
              case 2:
                System.out.println("Informe o novo sobrenome:");
                sobrenomeFuncionario = scanner.nextLine().toUpperCase();
                funcionario.setSobrenome(sobrenomeFuncionario);
                break;
              case 3:
                System.out.println("Digite o nome do novo bairro do funcionário: ");
                bairroFuncionario = scanner.nextLine();

                System.out.println("Digite o nome da nova cidade do funcionário: ");
                cidadeFuncionario = scanner.nextLine();

                System.out.println("Digite o nome do novo estado do funcionário: ");
                estadoFuncionario = scanner.nextLine();

                funcionario.setEndereco(new Endereco(bairroFuncionario, cidadeFuncionario, estadoFuncionario));
                break;
              case 4:
                System.out.println("Informe o novo CPF:");
                cpfFuncionario = scanner.nextLine().toUpperCase();
                funcionario.setCpf(cpfFuncionario);
                break;
              case 5:
                System.out.println("Informe o nova idade:");
                idadeFuncionario = Integer.parseInt(scanner.nextLine());
                funcionario.setIdade(idadeFuncionario);
                break;
              case 6:
                System.out.println("Informe o novo número de telefone:");
                telefoneFuncionario = scanner.nextLine().toUpperCase();
                funcionario.setTelefone(telefoneFuncionario);
              default:
                System.out.println("Opção inválida!");
                break;
            }
        }
        break;
    }
  }
}
