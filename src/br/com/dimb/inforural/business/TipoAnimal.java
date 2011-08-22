/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dimb.inforural.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
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

/**
 *
 * @author Albuquerque
 */
@Entity
@Table(name = "tipo_animal", catalog = "inforural", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoAnimal.findAll", query = "SELECT t FROM TipoAnimal t"),
    @NamedQuery(name = "TipoAnimal.findById", query = "SELECT t FROM TipoAnimal t WHERE t.id = :id"),
    @NamedQuery(name = "TipoAnimal.findByNome", query = "SELECT t FROM TipoAnimal t WHERE t.nome = :nome")})
public class TipoAnimal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nome", length = 50)
    private String nome;
    @OneToMany(mappedBy = "tipoAnimal", fetch = FetchType.LAZY)
    private List<Animal> animalList;

    public TipoAnimal() {
    }

    public TipoAnimal(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAnimal)) {
            return false;
        }
        TipoAnimal other = (TipoAnimal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.dimb.inforural.business.TipoAnimal[id=" + id + "]";
    }

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}

	public List<Animal> getAnimalList() {
		return animalList;
	}

}
