
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistirEspecialidade {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        Especialidade esp = new Especialidade();
        esp.setDescricao("Cardiologista");
        em.getTransaction().begin();
        em.persist(esp);
        em.getTransaction().commit();
    }
    
}
