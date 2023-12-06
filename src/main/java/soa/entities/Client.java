package soa.entities;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String prenom;

    private int num;
    private String adress;

    private Boolean etat;
    @OneToMany(mappedBy = "facture" ,cascade = {CascadeType.REMOVE  , CascadeType.MERGE , CascadeType.PERSIST})
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public Boolean getEtat() {
        return etat;
    }
    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Client(Long id, String nom, String prenom, int num, String adress) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.adress = adress;
        this.etat=true;
    }
    public Client() {
        super();
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", num=" + num +
                ", adress='" + adress + '\'' +
                '}';
    }
}
