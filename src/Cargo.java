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
