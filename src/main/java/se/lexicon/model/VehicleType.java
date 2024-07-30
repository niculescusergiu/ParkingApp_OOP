package se.lexicon.model;

public enum VehicleType {
    CAR("Car", 1),
    MOTORCYCLE("Motorcycle", 2),
    TRUCK("Truck", 3),
    VAN("Van", 4),
    ELECTRIC("EL", 5),
    OTHER("Other", 6);

    private int code;
    private String name;


    VehicleType(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
