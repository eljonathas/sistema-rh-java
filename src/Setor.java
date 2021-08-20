import java.util.ArrayList;

public enum Setor {
    REQUISITOS,
    MODELAGEM,
    CODIFICACAO,
    TESTES,
    RECURSOS_HUMANOS;

    ArrayList <Contrato>contratos = new ArrayList<Contrato>();

    public void contratarFuncionario(Contrato contrato){
        contratos.add(contrato);
  }

  public void demitirFuncionario(String cpf){
      for (Contrato contrato : contratos){
          if (contrato.getFuncionario().getCpf() == cpf)
          contratos.remove(contrato);
      }
        
  }
}

/*
Setor[] values = Setor.values();

       Arrays.asList( values ).forEach(setor -> {
           System.out.print( setor.name() );
           System.out.print( " = " );
           System.out.println( setor.getDescricao() );
       });
*/