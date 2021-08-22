import java.util.ArrayList;

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

    public Contrato getChefe(){
      for(Contrato contrato : contratos){
        if(contrato.getCargo().getCargo().equals(Cargo.CHEFE.getCargo())){
          return contrato;
        }
      }

      return null;
    }
  
    public void contratarFuncionario(Contrato contrato){
      contratos.add(contrato);
    }
  
    public void demitirFuncionario(Contrato contrato){
      contratos.remove(contrato);
    }
  }
  