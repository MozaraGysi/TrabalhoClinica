
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistirPaciente {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        Paciente p = new Paciente();
        p.setAltura(1.75);
        p.setHistorico("sem");
        p.setNascimento(Calendar.getInstance());
        p.setNome("Paciente 1");
        p.setPeso(73.1);
        p.setSexo("Masculino");
        p.setTelefone("991149253");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
}
