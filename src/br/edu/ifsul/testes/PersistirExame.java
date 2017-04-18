
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Exame;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistirExame {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        Exame ex = new Exame();
        ex.setNome("Radiografia");
        ex.setDescricao("Sem");
        ex.setConsulta(em.find(Consulta.class, 3));
        em.getTransaction().begin();
        em.persist(ex);
        em.getTransaction().commit();
    }
    
}
