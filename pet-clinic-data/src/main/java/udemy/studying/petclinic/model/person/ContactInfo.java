package udemy.studying.petclinic.model.person;

/**
 * POJO for using in {@link Person} for extended Entities Vet, Owner and etc.
 */
public class ContactInfo {
    private String address;
    private String city;
    private String telephone;

    public ContactInfo(String address, String city, String telephone) {
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public ContactInfo() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
