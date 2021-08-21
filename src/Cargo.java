public enum Cargo {
    CHEFE("chefe"), COLABORADOR("colaborador");

    private String cargo;

    Cargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}
