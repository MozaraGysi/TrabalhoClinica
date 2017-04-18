
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "A hora deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "hora", nullable = false)
    private Calendar hora;
    @NotNull(message = "A preconsulta deve ser informada")
    @NotBlank(message = "A preconsulta não pode ser em branco")
    @Column(name = "preconsulta", nullable = false, columnDefinition = "text")
    private String preconsulta;
    @NotNull(message = "A posconsulta deve ser informada")
    @NotBlank(message = "A posconsulta não pode ser em branco")
    @Column(name = "posconsulta", nullable = false, columnDefinition = "text")
    private String posconsulta;
    @NotNull(message = "O medico deve ser informado")
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_medico_id")
    private Medico medico;
    @NotNull(message = "O paciente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_paciente_id")
    private Paciente paciente;
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Exame> exame = new ArrayList<>();
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Receituario> receituario = new ArrayList<>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPreconsulta() {
        return preconsulta;
    }

    public void setPreconsulta(String preconsulta) {
        this.preconsulta = preconsulta;
    }

    public String getPosconsulta() {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }
    
        public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Exame> getExame() {
        return exame;
    }

    public void setExame(List<Exame> exame) {
        this.exame = exame;
    }

    public List<Receituario> getReceituario() {
        return receituario;
    }

    public void setReceituario(List<Receituario> receituario) {
        this.receituario = receituario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
