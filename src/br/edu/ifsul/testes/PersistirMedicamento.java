
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medicamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistirMedicamento {

    public static void main(String[] args) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        Medicamento med = new Medicamento();
        med.setNome("Xarope");
        em.getTransaction().begin();
        em.persist(med);
        em.getTransaction().commit();
    }
    
}
