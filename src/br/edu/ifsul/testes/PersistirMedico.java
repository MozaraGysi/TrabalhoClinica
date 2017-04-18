
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Medico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistirMedico {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        Medico m = new Medico();
        m.setCrm("1234567");
        m.setEspecialidade(em.find(Especialidade.class, 2));
        m.setAltura(1.81);
        m.setNome("Marcelo");
        m.setNascimento(Calendar.getInstance());
        m.setTelefone("054991169294");
        m.setSexo("Masculino");
        m.setHistorico("Nenhum");
        m.setPeso(85.7);
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
    }
    
}
