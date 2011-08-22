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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "animal", catalog = "inforural", schema = "")
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a"),
    @NamedQuery(name = "Animal.findById", query = "SELECT a FROM Animal a WHERE a.id = :id"),
    @NamedQuery(name = "Animal.findByApelido", query = "SELECT a FROM Animal a WHERE a.apelido = :apelido"),
    @NamedQuery(name = "Animal.findByDescricao", query = "SELECT a FROM Animal a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Animal.findByDataNascimento", query = "SELECT a FROM Animal a WHERE a.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Animal.findByDataAquisicao", query = "SELECT a FROM Animal a WHERE a.dataAquisicao = :dataAquisicao"),
    @NamedQuery(name = "Animal.findByObs", query = "SELECT a FROM Animal a WHERE a.obs = :obs")})
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "apelido", length = 50)
    private String apelido;
    @Column(name = "descricao", length = 255)
    private String descricao;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "data_aquisicao")
    @Temporal(TemporalType.DATE)
    private Date dataAquisicao;
    @Column(name = "obs", length = 200)
    private String obs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal1", fetch = FetchType.LAZY)
    private List<AnimalTemVacina> animalTemVacinaList;
    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    private List<Foto> fotoList;
    @JoinColumn(name = "sexo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Genero sexo;
    @JoinColumn(name = "cor", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cor cor;
    @JoinColumn(name = "situacao", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Situacao situacao;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne
    private TipoAnimal tipoAnimal;

    public Animal() {
    }

    public Animal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public java.util.Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public java.util.Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public List<AnimalTemVacina> getAnimalTemVacinaList() {
        return animalTemVacinaList;
    }

    public void setAnimalTemVacinaList(List<AnimalTemVacina> animalTemVacinaList) {
        this.animalTemVacinaList = animalTemVacinaList;
    }

    public List<Foto> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<Foto> fotoList) {
        this.fotoList = fotoList;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
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
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.dimb.inforural.business.Animal[id=" + id + "]";
    }

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

}
