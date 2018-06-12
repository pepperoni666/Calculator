package calcData;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "histry", schema = "calc")
public class HistoryEntity {
    private long id;
    private String email;
    private double brutto;
    private double ubez_emerytalne;
    private double ubez_rentowe;
    private double ubez_chorobowe;
    private double ubez_zdrowotne;
    private double zaliczka_pit;
    private double netto;

    public HistoryEntity() {
        email = "email";
        brutto = ubez_chorobowe = ubez_emerytalne = ubez_rentowe = ubez_zdrowotne = zaliczka_pit = netto = 0;
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
    @Column(name = "brutto")
    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    @Basic
    @Column(name = "ubez_emerytalne")
    public double getUbez_emerytalne() {
        return ubez_emerytalne;
    }

    public void setUbez_emerytalne(double ubez_emerytalne) { this.ubez_emerytalne = ubez_emerytalne; }

    @Basic
    @Column(name = "ubez_rentowe")
    public double getUbez_rentowe() {
        return ubez_rentowe;
    }

    public void setUbez_rentowe(double ubez_rentowe) {
        this.ubez_rentowe = ubez_rentowe;
    }

    @Basic
    @Column(name = "ubez_chorobowe")
    public double getUbez_chorobowe() {
        return ubez_chorobowe;
    }

    public void setUbez_chorobowe(double ubez_chorobowe) {
        this.ubez_chorobowe = ubez_chorobowe;
    }

    @Basic
    @Column(name = "ubez_zdrowotne")
    public double getUbez_zdrowotne() {
        return ubez_zdrowotne;
    }

    public void setUbez_zdrowotne(double ubez_zdrowotne) {
        this.ubez_zdrowotne = ubez_zdrowotne;
    }

    @Basic
    @Column(name = "zaliczka_pit")
    public double getZaliczka_pit() {
        return zaliczka_pit;
    }

    public void setZaliczka_pit(double zaliczka_pit) {
        this.zaliczka_pit = zaliczka_pit;
    }

    @Basic
    @Column(name = "netto")
    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryEntity that = (HistoryEntity) o;
        return Double.compare(that.id, id) == 0 &&
                Objects.equals(email, that.email) &&
                Objects.equals(brutto, that.brutto) &&
                Objects.equals(ubez_chorobowe, that.ubez_chorobowe) &&
                Objects.equals(ubez_emerytalne, that.ubez_emerytalne) &&
                Objects.equals(ubez_rentowe, that.ubez_rentowe) &&
                Objects.equals(ubez_zdrowotne, that.ubez_zdrowotne) &&
                Objects.equals(zaliczka_pit, that.zaliczka_pit) &&
                Objects.equals(netto, that.netto);
    }

    public HistoryEntity(String e, double br, double ue, double ur, double uc, double uz, double zp, double ne){
        this.email = e;
        this.brutto = br;
        this.ubez_emerytalne = ue;
        this.ubez_rentowe = ur;
        this.ubez_chorobowe = uc;
        this.ubez_zdrowotne = uz;
        this.zaliczka_pit = zp;
        this.netto = ne;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, brutto, ubez_chorobowe, ubez_emerytalne, ubez_rentowe, ubez_zdrowotne, zaliczka_pit, netto);
    }
}
