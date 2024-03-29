package groupsPeaksoft;

public class Students {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;

    public Students() {
    }

    public Students(int id, String firstName, String lastName, String email, String password, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




    @Override
    public String toString() {
        return  "\uD83D\uDC68‍🎓 Students Information 📚\n" +
                "ID: " + id +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nEmail: " + email +
                "\nPassword: " + password +
                "\nGender: " + gender;
    }
}
