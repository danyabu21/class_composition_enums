package entities;
import java.time.LocalDate;
import java.util.Date;

public class Client {
    private String name;
    private String email;
    private LocalDate birthDate;

    public Client(){}

    public Client(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        sb.append(email).append("\n");
        sb.append(birthDate);
        return sb.toString();
    }
}
