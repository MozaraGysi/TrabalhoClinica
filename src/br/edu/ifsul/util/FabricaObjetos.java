/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medicamento;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.modelo.Receituario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Mozara
 */
public class FabricaObjetos {
    public static List<Consulta> carregaConsultas(){
        List<Consulta> lista = new ArrayList<>();
        Consulta c = new Consulta();
        Medico m = new Medico();
        Paciente p = new Paciente();
        Exame e = new Exame();
        Receituario r = new Receituario();
        r.setPosologia("Não tem");
        e.setNome("exam");
        c.setId(7);
        c.setData(Calendar.getInstance());
        c.setHora(Calendar.getInstance());
        c.setPreconsulta("Sem informação de consultas anteriores");
        c.setPosconsulta("Paciente deve voltar após concluir o tratamento");
        c.setMedico(m);
        c.setPaciente(p);
        c.adicionarExame(e);
        c.adicionarReceita(r);
        lista.add(c);
        
        return lista;
    }
}
