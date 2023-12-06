package soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import soa.entities.Client;
import soa.entities.Facture;
import soa.metier.ClientMetierInterface;
import soa.metier.FactureMetierInterface;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class SpringJpaApplication22 {
    static ClientMetierInterface clientMetier;
    static FactureMetierInterface factureMetier;

    public static void main(String[] args) {
        System.out.println("---------Dependency Injection----------");
        ApplicationContext context = SpringApplication.run(SpringJpaApplication22.class, args);
        clientMetier = context.getBean(ClientMetierInterface.class);
        factureMetier = context.getBean(FactureMetierInterface.class);

        System.out.println("Insérer des clients");
        Client client1 = new Client(null, "Youssef", "Mezghani", 50560013, "rte mah");
        Client client2 = new Client(null, "Borhen", "Ayedi", 131321312, "tunis");
        Client client3 = new Client(null, "test", "test", 131321312, "tunis");
        clientMetier.ajouterClient(client1);
        clientMetier.ajouterClient(client2);
        clientMetier.ajouterClient(client3);

        System.out.println("La Liste Des Clients");
        System.out.println(clientMetier.listeClients());

        System.out.println("Insérer des factures pour les clients");
        Facture facture1 = new Facture("F1", new BigDecimal("100.00"), new Date(), client1);
        Facture facture2 = new Facture("F2", new BigDecimal("150.50"), new Date(), client2);
        factureMetier.ajouterFacture(facture1);
        factureMetier.ajouterFacture(facture2);

        System.out.println("La Liste Des Factures");
        System.out.println(factureMetier.listeFactures());
    }
}
