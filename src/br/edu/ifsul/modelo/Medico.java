
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "medico")
public class Medico extends Paciente implements Serializable{
  
    @Length(max = 30, message = "A crm não pode ter mais que {max} caracteres")
    @NotNull(message = "A crm deve ser informada")
    @NotBlank(message = "A crm não pode ser em branco")
    @Column(name = "crm", length = 30, nullable = false)
    private String crm;
    @NotNull(message = "A especialidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_especialidade_id")
    private Especialidade especialidade;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
    
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.crm);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.crm, other.crm)) {
            return false;
        }
        return true;
    }
}
