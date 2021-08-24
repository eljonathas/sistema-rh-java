/*
 * A classe Cargo armazena os dois cargos possíveis dentro da empresa, sendo eles chefe e colaborador
 */
public enum Cargo {
    CHEFE("Chefe"), COLABORADOR("Colaborador");

    private String cargo;

    Cargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}
