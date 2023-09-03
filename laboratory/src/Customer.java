public final class Customer {
    private String dni;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    public Customer(String dni, String name, String email, String phoneNumber, String address) {
        this.dni = dni;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " <" + dni + ">";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Customer client = (Customer) object;

        if (!dni.equals(client.dni)) return false;
        return name.equals(client.name);
    }

    @Override
    public int hashCode() {
        int result = dni.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
