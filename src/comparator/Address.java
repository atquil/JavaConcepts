package comparator;

public class Address implements Comparable<Address>{
    private int pincode;
    private String address;

    public Address(int pincode, String address) {
        this.pincode = pincode;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "pincode=" + pincode +
                ", address='" + address + '\'' +
                '}';
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Address o) {
        return this.getPincode() - o.getPincode();
    }
}
