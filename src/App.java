import java.util.Scanner;

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

    System.out.println("""
    Digite a opção desejada:
    1 - Admitir funcionário
    2 - Consultar funcionário por nome ou cpf
    3 - Atualizar dados contratuais do funcionário
    4 - Demitir funcionário por cpf
    5 - Listar todos os funcionários
    6 - Listar todos os funcionários por setor, sexo e estado
    7 - Listar funcionário com maior salário
    8 - Listar funcionário com menor salário
    """);

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

        String setorFuncionario = null;

        String cargoFuncionario = null;

        Contrato contrato = null;

        Setor setor = null;

        int randomId = (int) (Math.random() * Math.pow(10, 5));

        System.out.println(Setor.TESTES.getNome().toLowerCase());

        while (setorFuncionario != Setor.TESTES.getNome().toLowerCase()){
          System.out.println(setorFuncionario);
          System.out.println("Digite o setor do funcionário, escolha entre ["+Setor.TESTES.getNome()+", "+Setor.REQUISITOS.getNome()+", "+Setor.MODELAGEM.getNome()+", "+Setor.CODIFICACAO.getNome()+", "+Setor.RECURSOS_HUMANOS.getNome()+"]: ");
          setorFuncionario = (scanner.nextLine()).toLowerCase();
        }

        do {
          System.out.println("Digite o cargo do funcionário, escolha entre ["+Cargo.CHEFE.getCargo()+", "+Cargo.COLABORADOR.getCargo()+"]: ");
          cargoFuncionario = scanner.nextLine();
        } while (cargoFuncionario != Cargo.CHEFE.getCargo() || cargoFuncionario != Cargo.COLABORADOR.getCargo());

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
          cargoFuncionario == Cargo.CHEFE.getCargo().toLowerCase() ? Cargo.CHEFE : Cargo.COLABORADOR,
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

        Contrato buscarContrato = empresa.buscarContratoPorId(idContrato);

        if (buscarContrato == null) {
          System.out.println("Contrato não encontrado!");
        }

        System.out.println("""
        Escolha a opção desejada:
        1 - Alterar salário
        2 - Alterar cargo
        3 - Alterar setor
        """);

        int opcaoAlteracao = Integer.parseInt(scanner.nextLine());

        switch(opcaoAlteracao) {
          case 1:
            System.out.println("Digite o novo salário: ");
            double novoSalario = scanner.nextDouble();
            buscarContrato.setSalario(novoSalario);
            System.out.println("Salário alterado com sucesso!");
            break;
          case 2:
            System.out.println("Digite o novo cargo: ");
            String novoCargo = scanner.nextLine().toLowerCase();
            buscarContrato.setCargo(novoCargo == Cargo.CHEFE.getCargo().toLowerCase() ? Cargo.CHEFE : Cargo.COLABORADOR);
            System.out.println("Cargo alterado com sucesso!");
            break;
          case 3:
            System.out.println("Digite o novo setor: ");
            String novoSetor = scanner.nextLine().toLowerCase();

            Setor novoObjetoSetor = null;

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

            buscarContrato.setSetor(novoObjetoSetor);
            break;
        }
        break;
    }
  }
}
