package se.lexicon.model;

public class Customer {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private Reservation reservation;

    public Customer(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String phoneNumber, String email, Reservation reservation) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer ID: ").append(id)
                .append(", Name: ").append(name)
                .append(", PhoneNumber:").append(phoneNumber);
        if(reservation == null){
            sb.append(", Reservation: ").append("-");
        } else {
            sb.append(", Reservation ID: ").append(reservation.getId());
        }
        return sb.toString();
    }
}
