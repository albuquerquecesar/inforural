/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dimb.inforural.business;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Albuquerque
 */
@Embeddable
public class AnimalTemVacinaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "animal", nullable = false)
    private int animal;
    @Basic(optional = false)
    @Column(name = "vacina", nullable = false)
    private int vacina;

    public AnimalTemVacinaPK() {
    }

    public AnimalTemVacinaPK(int animal, int vacina) {
        this.animal = animal;
        this.vacina = vacina;
    }

    public int getAnimal() {
        return animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

    public int getVacina() {
        return vacina;
    }

    public void setVacina(int vacina) {
        this.vacina = vacina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) animal;
        hash += (int) vacina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnimalTemVacinaPK)) {
            return false;
        }
        AnimalTemVacinaPK other = (AnimalTemVacinaPK) object;
        if (this.animal != other.animal) {
            return false;
        }
        if (this.vacina != other.vacina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.dimb.inforural.business.AnimalTemVacinaPK[animal=" + animal + ", vacina=" + vacina + "]";
    }

}
