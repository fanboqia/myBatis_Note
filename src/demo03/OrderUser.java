package demo03;

public class OrderUser extends Order {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "OrderUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
