
public enum Setor {
    REQUISITOS("Requisitos"),
    MODELAGEM("Modelagem"),
    CODIFICACAO("Codificação"),
    TESTES("Testes"),
    RECURSOS_HUMANOS("Recursos Humanos");

    private String nome;

    private Setor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
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