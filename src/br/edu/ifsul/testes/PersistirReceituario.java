
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Receituario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistirReceituario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        Receituario rec = new Receituario();
        rec.setPosologia("Bula");
        rec.setValidade(Calendar.getInstance());
        rec.setConsulta(em.find(Consulta.class, 3));
        em.getTransaction().begin();
        em.persist(rec);
        em.getTransaction().commit();
    }
    
}
