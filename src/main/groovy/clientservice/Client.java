package clientservice;

/**
 * Created by peter on 21/03/15.
 */
public class Client {
    String firstName;
    String lastName;
    int age;
    String loanId;

    public Client(String firstName, String lastName, int age, String loanId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.loanId = loanId;
    }
    public Client(){

    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", loanId='" + loanId + '\'' +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }
}
