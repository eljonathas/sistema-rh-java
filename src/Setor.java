/*
 * A classe Setor guarda os setores possíveis que uma empresa pode possuir, sendo eles requisitos, modelagem,
 * codificação, testes e recursos humanos
 */
enum Setor {
    REQUISITOS("Requisitos"),
    MODELAGEM("Modelagem"),
    CODIFICACAO("Codificacao"),
    TESTES("Testes"),
    RECURSOS_HUMANOS("Recursos Humanos");
  
    private String nome;
  
    private Setor(String nome){
      this.nome = nome;
    }
  
    public String getNome() {
      return nome;
    }
  }
  