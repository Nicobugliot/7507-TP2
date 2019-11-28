package Modelo.unit;

public enum UnitType {
    BATTALION("ni p*** idea"), CATAPULT("catapulta"), HEALER("curandero"), INFANTRY("soldado"), RIDER("caballo");

    private final String name;
    UnitType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
