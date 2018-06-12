package calcData;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "calc")
public class UsersEntity {
    private long id;
    private String email;
    private String password;

    public UsersEntity() {
        email = "email";
        password = "password";
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Long.compare(that.id, id) == 0 &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    public UsersEntity(String e, String p){
        this.email = e;
        this.password = p;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, password);
    }
}
