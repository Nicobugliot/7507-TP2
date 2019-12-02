package Modelo.unit;

public enum UnitType {
    CATAPULT("catapulta"), HEALER("curandero"), INFANTRY("soldado"), RIDER("caballo");

    private final String name;
    UnitType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
