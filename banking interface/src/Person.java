public class Person {

    public String firstName;
    public String middleName;
    public String lastName;
    public String address;
    protected String socialSecurity;

    // Set functions
    public void setName(String first, String middle, String last) {
        this.firstName = first;
        this.middleName = middle;
        this.lastName = last;
    }
    public void setAddress(String add) {
        this.address = add;
    }

    public void setSocial(String SSN) {
        this.socialSecurity = SSN;
    }

    public Person() {
        this.firstName = "John";
        this.middleName = "";
        this.lastName = "Doe";
        this.address = "124 Conch St.";
        this.socialSecurity = "123-45-6789";

    }

    public Person(String firstName, String middleName, String lastName, String address, String socialSecurity) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.socialSecurity = socialSecurity;

    }

    //Get functions
    public String getName() {

        if (middleName.equals("")) {
            return firstName + " " + lastName;

        }
        return firstName + " " + middleName + " " + lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }
}
