package Modelo.unit;

public enum UnitType {
    BATTALION("caduceus"), CATAPULT("catapulta"), HEALER("ni puta idea"), INFRANTRY("soldado"), RIDER("caballo");

    private final String name;
    UnitType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
