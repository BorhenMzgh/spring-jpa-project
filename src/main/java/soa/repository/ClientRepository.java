    package soa.repository;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Modifying;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.transaction.annotation.Transactional;
    import soa.entities.Client;

    import java.util.List;

    public interface ClientRepository extends JpaRepository<Client,Long> {
        @Query("select c from Client c where c.prenom like %:x% ")
        public List<Client> findByPrenom(@Param("x") String mc);

        @Query("select c from Client c where c.nom like %:x% ")
        public List<Client> findByNom(@Param("x") String mc);

        @Query("select c from Client c where c.num like %:x% ")
        public List<Client> findByNum(@Param("x") int numClient);
        @Query("update Client c set c.num =:num where c.id = :id")
        @Modifying
        @Transactional
        public int mettreAJourNum(@Param("num") int numClient, @Param("id") Long idClient);

        //Retourner la liste des produits dont la date d’achat est supérieure à une date donnée

        //Retourner la liste des produits dont la date d’achat est inférieure à une date donnée
            @Query("select c from Client c where c.etat like %:x% ")
        List <Client> findAllByEtat(@Param("x") Boolean etat);
    }
