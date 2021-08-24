import java.util.Scanner;
import java.util.UUID;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Primeiramente, os dados da empresa recebidos para a classe Empresa seja instanciada
    // O nome da empresa é entrado
    System.out.println("Digite o nome da empresa: ");
    String nomeEmpresa = scanner.nextLine();

    String cnpj = "";

    // O cnpj da empresa é entrado. É feita uma validação para que o usuário a quantidade de dígitos correta
    while (cnpj.length() != 14) {
      System.out.println("Digite os 14 números do cnpj: ");
      cnpj = scanner.nextLine();
    }

    // O três inputs seguintes serão utilizados para instanciar a classe endereço, já que ela é composta por um Bairro, Cidade e Estado
    // A cidade onde a empresa reside é recebida para, posteriormente, ser usada para instanciar a classe Cidade
    System.out.println("Digite o cidade onde a empresa está localizada: ");
    String cidadeEmpresa = scanner.nextLine();

    // O bairro onde a empresa reside é recebico para, posteriormente, ser usada para instanciar a classe Bairro
    System.out.println("Digite o bairro onde a empresa está localizada: ");
    String bairroEmpresa = scanner.nextLine();

    // O estado onde a empresa reside é recebico para, posteriormente, ser usada para instanciar a classe Estado
    System.out.println("Digite o estado onde a empresa está localizada: ");
    String estadoEmpresa = scanner.nextLine();

    // O telefone da empresa é recebido
    System.out.println("Digite o telefone da empresa: ");
    String telefone = scanner.nextLine();

    // O email da empresa é recebido
    System.out.println("Digite o email da empresa: ");
    String email = scanner.nextLine();

    // O nome do dono da empresa é recebido
    System.out.println("Digite o nome do dono da empresa: ");
    String nomeDono = scanner.nextLine();

    // A partir dos dados recebidos acima, um objeto da classe empresa é instaciado
    // a fim de que se tenha acesso a seus serviços
    Empresa empresa = new Empresa(
      nomeEmpresa, 
      cnpj, 
      new Endereco(bairroEmpresa, cidadeEmpresa, estadoEmpresa), // Um objeto da classe endereço é instanciado para completar o construtor da classe empresa
      telefone, 
      email, 
      nomeDono
    );

    // Variável de controle para terminar a execução do programa quando o usuário desejar
    boolean sair = false;

    // As ações que podem ser realizadas dentro do sistema de RH, os quais correspondem aos métodos da classe empresa,
    // com exceção da opção sair.
    while (!sair) {
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
      9 - Imprimir folha de pagamento
      10 - Sair
      """);

      // O usuário deve escolher uma entre as opções informadas.
      // Caso a opção seja inválida, ele é perguntado novamente até que entre uma opção válida
      int opcao = Integer.parseInt(scanner.nextLine());

      switch (opcao) {
        //Admitir funcionário
        // Contratar um funcionário. Logo, é necessário recolher todos os seus dados.
        case 1:
          // O nome do funcionário é recebido
          System.out.println("Digite o primeiro nome do funcionário: ");
          String nomeFuncionario = scanner.nextLine();

          // O sobrenome do funcionário é recebido
          System.out.println("Digite o sobrenome do funcionário: ");
          String sobrenomeFuncionario = scanner.nextLine();

          // O idade do funcionário é recebido
          System.out.println("Digite a idade do funcionário: ");
          int idadeFuncionario = Integer.parseInt(scanner.nextLine());

          // O cpf do funcionário é recebido e é feita uma validação para que ele não entre um cpf inválido.
          String cpfFuncionario = "";

          while (cpfFuncionario.length() != 11) {
            System.out.println("Digite os 11 números do cpf do funcionário: ");
            cpfFuncionario = scanner.nextLine();
          }

          // O telefone do funcionário é recebido
          System.out.println("Digite o telefone do funcionário: ");
          String telefoneFuncionario = scanner.nextLine();

          // O cidade do funcionário é recebido
          System.out.println("Digite o cidade do funcionário: ");
          String cidadeFuncionario = scanner.nextLine();

          // O bairro do funcionário é recebido
          System.out.println("Digite o bairro do funcionário: ");
          String bairroFuncionario = scanner.nextLine();

          // O estado do funcionário é recebido
          System.out.println("Digite o estado do funcionário: ");
          String estadoFuncionario = scanner.nextLine();

          // O sexo do funcionário é recebido e feita uma validação para que ele entre somente as duas opções válidas:
          // F e M
          String sexoFuncionario = "";
          
          while ( !(sexoFuncionario.equals("M") || sexoFuncionario.equals("F")) ) {
            System.out.println("Digite M (Masculino) ou F (Feminino) para o sexo do funcionário: ");
            sexoFuncionario = scanner.nextLine().toUpperCase();

            if (!(sexoFuncionario.equals("M") || sexoFuncionario.equals("F"))) {
              System.out.println("Opção inválida!");
            }
          }

          String setorFuncionario = null;

          String cargoFuncionario = null;

          // Contrato no qual o funcinário será alocado
          Contrato contrato = null;

          // Receberá uma das constantes definidas dentro do enum Setor
          Setor setor = null;

          // Esta será a identificação do contrato
          String uniqueID = UUID.randomUUID().toString();

          // O setor do funcionário é recebido e feita uma validação para que ele entre somente um dos setores
          // os quais existem na empresa. Sendo assim, o laço é mantido enquanto o setor escolhido não for válido
          do {
            System.out.println("Digite o setor do funcionário, escolha entre ["+Setor.TESTES.getNome()+", "+Setor.REQUISITOS.getNome()+", "+Setor.MODELAGEM.getNome()+", "+Setor.CODIFICACAO.getNome()+", "+Setor.RECURSOS_HUMANOS.getNome()+"]: ");
            setorFuncionario = (scanner.nextLine()).toLowerCase();
          } while (!setorFuncionario.equals(Setor.REQUISITOS.getNome().toLowerCase()) && !setorFuncionario.equals(Setor.MODELAGEM.getNome().toLowerCase()) && !setorFuncionario.equals(Setor.CODIFICACAO.getNome().toLowerCase()) && !setorFuncionario.equals(Setor.TESTES.getNome().toLowerCase()) && !setorFuncionario.equals(Setor.RECURSOS_HUMANOS.getNome().toLowerCase()));

          // Dependendo do texto entrado pelo usuário acima, uma das constantes do enum setor é atribuída à variável setor.
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

          // É verificado se o setor deste funcionário que será criado já possui um chefe
          if(empresa.listarChefeDoSetor(setor) != null) {
            System.out.println("O setor escolhido já possui um chefe. Você pode atribuir o cargo para este funcionário para efetuar a troca.");
          }

          // Se este funcionário for o novo chefe, o cargo do antigo chefe deve ser reatribuído para colaborador, pois cada setor só pode ter um chefe.
          do { 
            System.out.println("Digite o cargo do funcionário, escolha entre ["+Cargo.CHEFE.getCargo()+", "+Cargo.COLABORADOR.getCargo()+"]: ");
            cargoFuncionario = scanner.nextLine().toLowerCase();

            if(empresa.listarChefeDoSetor(setor) != null && cargoFuncionario.equals(Cargo.CHEFE.getCargo().toLowerCase())) {
              String nomeDoChefeAnterior = empresa.listarChefeDoSetor(setor).getFuncionario().getNome();

              empresa.listarChefeDoSetor(setor).setCargo(Cargo.COLABORADOR);

              System.out.println("Cargo de chefe do setor escolhido alterado ["+nomeDoChefeAnterior+"->"+nomeFuncionario+"]");
            }
          } while (!cargoFuncionario.equals(Cargo.CHEFE.getCargo().toLowerCase()) && !cargoFuncionario.equals(Cargo.COLABORADOR.getCargo().toLowerCase()));   

          // O salário do funcinário é recebido
          System.out.println("Digite o salário do funcionário: ");
          double salarioFuncionario = Double.parseDouble(scanner.nextLine());

          // A partir dos dados recebidos, um objeto da classe funcionário é instanciado
          Funcionario funcionario = new Funcionario(
            nomeFuncionario, 
            sobrenomeFuncionario, 
            new Endereco(bairroFuncionario, cidadeFuncionario, estadoFuncionario), 
            cpfFuncionario,
            idadeFuncionario,
            sexoFuncionario.equals("M") ? "Masculino" : "Feminino",
            telefoneFuncionario
          );

          // O contrato deste funcionário é criado a partir das informações coletadas acima.
          contrato = new Contrato(
            funcionario, 
            uniqueID, 
            salarioFuncionario, 
            cargoFuncionario.equals(Cargo.CHEFE.getCargo().toLowerCase()) ? Cargo.CHEFE : Cargo.COLABORADOR,
            setor 
          );

          // Por último, o funcionário é contratado, passando seu contrato para a função competente.
          empresa.adimitirFuncionario(contrato);

          System.out.println("Contrato ["+uniqueID+": "+funcionario.getNome()+"] criado com sucesso!");
        break;

        // Consultar funcionário por nome ou cpf
        // Um funcionário é buscado para que seus dados sejam visualizados
        case 2:
          System.out.println("Digite o cpf ou nome do funcionário: ");
          String cpfOuNomeFuncionarioConsulta = scanner.nextLine();

          Funcionario funcionarioConsulta = empresa.consultarFuncionario(cpfOuNomeFuncionarioConsulta);

          if (funcionarioConsulta != null) {
            System.out.println("Funcionário encontrado: ");
            System.out.println(funcionarioConsulta.toString());
          } else {
            System.out.println("Funcionário não encontrado!");
          }
        break;

        // Atualizar dados contratuais ou pessoais do funcionário
        case 3:
          System.out.println("Lista de contratos: ");
          empresa.listarContratos();

          // Os contrato é buscado por Id
          System.out.println("Digite o id do contrato desejado com base nos dados acima: ");
          String idContrato = scanner.nextLine();

          Contrato contratoBuscado = empresa.buscarContratoPorId(idContrato);

          if (contratoBuscado == null) {
            System.out.println("Contrato não encontrado!");
            break;
          } else {
          // Deve ser informado qual dado específico do contrato será alterado
          System.out.println("""
          Escolha a opção desejada:
          1 - Alterar salário
          2 - Alterar cargo
          3 - Alterar setor
          4 - Alterar dados pessoais do funcionário
          """);

          int opcaoAlteracao = Integer.parseInt(scanner.nextLine());

          switch(opcaoAlteracao) {
            // Alterando o salário
            case 1:
              System.out.println("Digite o novo salário: ");
              double novoSalario = Double.parseDouble(scanner.nextLine());
              contratoBuscado.setSalario(novoSalario);
              System.out.println("Salário alterado com sucesso!");
            break;
            // Alterando o cargo
            case 2:
              String novoCargo = null;

              // Deve ser feita a validação para que o usuário informe um cargo válido.
              do { 
                System.out.println("Digite o novo cargo do funcionário, escolha entre ["+Cargo.CHEFE.getCargo()+", "+Cargo.COLABORADOR.getCargo()+"]: ");
                novoCargo = scanner.nextLine().toLowerCase();

                // Se este contrato for o do novo chefe, o contrato do antigo chefe deve ser modificado
                if(empresa.listarChefeDoSetor(contratoBuscado.getSetor()) != null && novoCargo.equals(Cargo.CHEFE.getCargo().toLowerCase())) {
                  String nomeDoChefeAnterior = empresa.listarChefeDoSetor(contratoBuscado.getSetor()).getFuncionario().getNome();
    
                  empresa.listarChefeDoSetor(contratoBuscado.getSetor()).setCargo(Cargo.COLABORADOR);
    
                  System.out.println("Chefe do setor alterado ["+nomeDoChefeAnterior+"->"+contratoBuscado.getFuncionario().getNome()+"]");
                }
              } while (!novoCargo.equals(Cargo.CHEFE.getCargo().toLowerCase()) && !novoCargo.equals(Cargo.COLABORADOR.getCargo().toLowerCase()));

              contratoBuscado.setCargo(novoCargo.equals(Cargo.CHEFE.getCargo().toLowerCase()) ? Cargo.CHEFE : Cargo.COLABORADOR);
              
              System.out.println("Cargo alterado com sucesso!");
            break;
            // Alterando o setor
            case 3:

              String novoSetor = null;
              // System.out.println("Digite o novo setor ["+Setor.TESTES.getNome()+", "+Setor.REQUISITOS.getNome()+", "+Setor.MODELAGEM.getNome()+", "+Setor.CODIFICACAO.getNome()+", "+Setor.RECURSOS_HUMANOS.getNome()+"]: ");
              // String novoSetor = scanner.nextLine().toLowerCase();
              do {
                System.out.println("Digite o novo setor do funcionário, escolha entre ["+Setor.TESTES.getNome()+", "+Setor.REQUISITOS.getNome()+", "+Setor.MODELAGEM.getNome()+", "+Setor.CODIFICACAO.getNome()+", "+Setor.RECURSOS_HUMANOS.getNome()+"]: ");
                novoSetor = (scanner.nextLine()).toLowerCase();
              } while (!novoSetor.equals(Setor.REQUISITOS.getNome().toLowerCase()) && !novoSetor.equals(Setor.MODELAGEM.getNome().toLowerCase()) && !novoSetor.equals(Setor.CODIFICACAO.getNome().toLowerCase()) && !novoSetor.equals(Setor.TESTES.getNome().toLowerCase()) && !novoSetor.equals(Setor.RECURSOS_HUMANOS.getNome().toLowerCase()));

              Setor novoObjetoSetor = null;

              // Dependendo do valor entrado pelo usuário, o novo setor é escolhido
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

              // O novo setor é atribuído ao contrato
              contratoBuscado.setSetor(novoObjetoSetor);
              System.out.println("Setor alterado com sucesso!");
            break;
            // Alterar dados pessoais do funcionário
            case 4:
              System.out.println("""
              Escolha a opção desejada:
              1 - Alterar nome
              2 - Alterar sobrenome
              3 - Alterar endereço
              4 - Alterar CPF
              5 - Alterar idade
              6 - Alterar telefone
              """);

              // O usuário deve informar qual dado específico do funcionário ele deseja alterar
              opcaoAlteracao = Integer.parseInt(scanner.nextLine());
              // Uma referência para o funcionário do contrato é buscada
              funcionario = contratoBuscado.getFuncionario();

              switch(opcaoAlteracao) {
                // Alterando o nome
                case 1:
                  System.out.println("Informe o novo nome:");
                  nomeFuncionario = scanner.nextLine().toUpperCase();
                  funcionario.setNome(nomeFuncionario);
                  System.out.println("Nome alterado com sucesso!");
                break;
                // Alterando o sobrenome
                case 2:
                  System.out.println("Informe o novo sobrenome:");
                  sobrenomeFuncionario = scanner.nextLine().toUpperCase();
                  funcionario.setSobrenome(sobrenomeFuncionario);
                  System.out.println("Sobrenome alterado com sucesso!");
                break;
                // Alterando o endereço
                case 3:
                  System.out.println("Digite o nome do novo bairro do funcionário: ");
                  bairroFuncionario = scanner.nextLine();

                  System.out.println("Digite o nome da nova cidade do funcionário: ");
                  cidadeFuncionario = scanner.nextLine();

                  System.out.println("Digite o nome do novo estado do funcionário: ");
                  estadoFuncionario = scanner.nextLine();

                  funcionario.setEndereco(new Endereco(bairroFuncionario, cidadeFuncionario, estadoFuncionario));
                  System.out.println("Endereço alterado com sucesso!");
                break;
                // Alterando o cpf
                case 4:
                  String novoCpf = "";

                  while (cnpj.length() != 11) {
                    System.out.println("Digite os 11 números do cpf para alterar: ");
                    novoCpf = scanner.nextLine();
                  }

                  funcionario.setCpf(novoCpf);

                  System.out.println("CPF alterado com sucesso!");
                break;
                // Alterando a idade
                case 5:
                  System.out.println("Informe o nova idade:");
                  idadeFuncionario = Integer.parseInt(scanner.nextLine());
                  funcionario.setIdade(idadeFuncionario);

                  System.out.println("Idade alterada com sucesso!");
                break;
                // Alterando o telefone
                case 6:
                  System.out.println("Informe o novo número de telefone:");
                  telefoneFuncionario = scanner.nextLine().toUpperCase();
                  funcionario.setTelefone(telefoneFuncionario);

                  System.out.println("Telefone alterado com sucesso!");
                break;
                default:
                  System.out.println("Opção inválida!");
                break;
              }
            break;
          }
        }
        break;

        // Demitir funcionário por cpf
        case 4:
          // Uma referência do funcionário é buscada por cpf
          System.out.println("Digite o cpf do funcionário que deseja excluir: ");
          cpfFuncionario = scanner.nextLine().toUpperCase();
          Funcionario funcionarioBuscado = empresa.consultarFuncionario(cpfFuncionario);

          // Se o funcionário existe, ele é demitido
          if(funcionarioBuscado != null) {
            empresa.procurarContratoParaDemissão(funcionarioBuscado.getCpf());
            System.out.println("Funcionário excluído com sucesso!");
          }else{
            System.out.println("Funcionário não encontrado!");
          }
        break;

        // Listar todos os funcionários
        // Todos os funcionários com seus dados serão impressos
        case 5:
          empresa.mostrarTodosOsFuncionarios();
        break;

        // Filtrar funcionários por nome, sexo e estado
        case 6:
          try {
            System.out.println("Digite o nome do setor: ");
            String nomeSetor = scanner.nextLine();
            System.out.println("Dite o sexo para filtar");
            String sexo = scanner.nextLine();
            System.out.println("Digite o estado para filtrar");
            String estado = scanner.nextLine();

            empresa.mostrarFuncionariosPorSetorSexoEstado(nomeSetor, sexo, estado);
          } catch (Exception e) {
            System.out.println("Erro ao filtrar funcionários");
          }
        break;

        // Listar funcionário de maior salário
        case 7:
          Funcionario deMaiorSalario = empresa.listarFuncionarioDeMaiorSalario();

          System.out.println(deMaiorSalario.toString());
        break;

        // Listar funcionário de menor salário
        case 8:
          Funcionario deMenorSalario = empresa.listarFuncionarioDeMenorSalario();

          System.out.println(deMenorSalario.toString());
        break;

        // Imprimir folha de pagamento
        // A soma dos salários dos funcionários é informada
        case 9:
          System.out.println(empresa.listarFolhaDePagamento());
        break;

        // Sair
        case 10:
          sair = true;
        break;
      }
    }
    
    scanner.close();
    System.out.println("Fim do programa!");
  }
}
