/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dimb.inforural.business;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Albuquerque
 */
@Entity
@Table(name = "animal_tem_vacina", catalog = "inforural", schema = "")
@NamedQueries({
    @NamedQuery(name = "AnimalTemVacina.findAll", query = "SELECT a FROM AnimalTemVacina a"),
    @NamedQuery(name = "AnimalTemVacina.findByAnimal", query = "SELECT a FROM AnimalTemVacina a WHERE a.animalTemVacinaPK.animal = :animal"),
    @NamedQuery(name = "AnimalTemVacina.findByVacina", query = "SELECT a FROM AnimalTemVacina a WHERE a.animalTemVacinaPK.vacina = :vacina"),
    @NamedQuery(name = "AnimalTemVacina.findByData", query = "SELECT a FROM AnimalTemVacina a WHERE a.data = :data"),
    @NamedQuery(name = "AnimalTemVacina.findByLugar", query = "SELECT a FROM AnimalTemVacina a WHERE a.lugar = :lugar")})
public class AnimalTemVacina implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnimalTemVacinaPK animalTemVacinaPK;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "lugar", length = 50)
    private String lugar;
    @JoinColumn(name = "animal", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Animal animal1;
    @JoinColumn(name = "vacina", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Vacina vacina1;

    public AnimalTemVacina() {
    }

    public AnimalTemVacina(AnimalTemVacinaPK animalTemVacinaPK) {
        this.animalTemVacinaPK = animalTemVacinaPK;
    }

    public AnimalTemVacina(int animal, int vacina) {
        this.animalTemVacinaPK = new AnimalTemVacinaPK(animal, vacina);
    }

    public AnimalTemVacinaPK getAnimalTemVacinaPK() {
        return animalTemVacinaPK;
    }

    public void setAnimalTemVacinaPK(AnimalTemVacinaPK animalTemVacinaPK) {
        this.animalTemVacinaPK = animalTemVacinaPK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Animal getAnimal1() {
        return animal1;
    }

    public void setAnimal1(Animal animal1) {
        this.animal1 = animal1;
    }

    public Vacina getVacina1() {
        return vacina1;
    }

    public void setVacina1(Vacina vacina1) {
        this.vacina1 = vacina1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (animalTemVacinaPK != null ? animalTemVacinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnimalTemVacina)) {
            return false;
        }
        AnimalTemVacina other = (AnimalTemVacina) object;
        if ((this.animalTemVacinaPK == null && other.animalTemVacinaPK != null) || (this.animalTemVacinaPK != null && !this.animalTemVacinaPK.equals(other.animalTemVacinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.dimb.inforural.business.AnimalTemVacina[animalTemVacinaPK=" + animalTemVacinaPK + "]";
    }

}
