package utils.enums;

public enum Separador {
    FLECHA("->"),
    DOS_PUNTOS(":"),
    GUION("-"),
    COMA(","),
    PUNTO_COMA(";"),
    VIRGULILLA("~"),
    ESPACIO(" ");

    private final String valor;

    private Separador(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
