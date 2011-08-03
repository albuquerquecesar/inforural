/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dimb.inforural.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Albuquerque
 */
@Entity
@Table(name = "vacina", catalog = "inforural", schema = "")
@NamedQueries({
    @NamedQuery(name = "Vacina.findAll", query = "SELECT v FROM Vacina v"),
    @NamedQuery(name = "Vacina.findById", query = "SELECT v FROM Vacina v WHERE v.id = :id"),
    @NamedQuery(name = "Vacina.findByNome", query = "SELECT v FROM Vacina v WHERE v.nome = :nome"),
    @NamedQuery(name = "Vacina.findByIdadePermitida", query = "SELECT v FROM Vacina v WHERE v.idadePermitida = :idadePermitida")})
public class Vacina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nome", length = 50)
    private String nome;
    @Column(name = "idade_permitida")
    private Integer idadePermitida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacina1", fetch = FetchType.LAZY)
    private List<AnimalTemVacina> animalTemVacinaList;

    public Vacina() {
    }

    public Vacina(Integer id) {
        this.id = id;
    }

    public Vacina(int i, String string, Integer date) {
		this.id=i;
		this.nome=string;
		this.idadePermitida=date;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdadePermitida() {
        return idadePermitida;
    }

    public void setIdadePermitida(Integer idadePermitida) {
        this.idadePermitida = idadePermitida;
    }

    public List<AnimalTemVacina> getAnimalTemVacinaList() {
        return animalTemVacinaList;
    }

    public void setAnimalTemVacinaList(List<AnimalTemVacina> animalTemVacinaList) {
        this.animalTemVacinaList = animalTemVacinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacina)) {
            return false;
        }
        Vacina other = (Vacina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
