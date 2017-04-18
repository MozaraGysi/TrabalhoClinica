
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistirConsulta {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        Consulta cons = new Consulta();
        cons.setData(Calendar.getInstance());
        cons.setHora(Calendar.getInstance());
        cons.setPreconsulta("Nao");
        cons.setPosconsulta("Sim");
        cons.setMedico(em.find(Medico.class, 8));
        cons.setPaciente(em.find(Paciente.class, 1));
        em.getTransaction().begin();
        em.persist(cons);
        em.getTransaction().commit();
    }
    
}
