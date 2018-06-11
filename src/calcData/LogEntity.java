package calcData;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "log", schema = "calc")
public class LogEntity {
    private long id;
    private String ip;
    private String email;

    public LogEntity() {
        ip = "ip";
        email = "email";
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
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntity that = (LogEntity) o;
        return Double.compare(that.id, id) == 0 &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(email, that.email);
    }

    public LogEntity(String i, String e){
        this.ip = i;
        this.email = e;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ip, email);
    }
}