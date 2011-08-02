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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Albuquerque
 */
@Entity
@Table(name = "usuario", catalog = "inforural", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByAbilitado", query = "SELECT u FROM Usuario u WHERE u.abilitado = :abilitado")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "nome", length = 40)
    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "senha", length = 255)
    private String senha;
    @Column(name = "abilitado")
    private Boolean abilitado;
    @JoinTable(name = "usuario_tem_permissao", joinColumns = {
        @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "permissao", referencedColumnName = "id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Permissao> permissaoList;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAbilitado() {
        return abilitado;
    }

    public void setAbilitado(Boolean abilitado) {
        this.abilitado = abilitado;
    }

    public List<Permissao> getPermissaoList() {
        return permissaoList;
    }

    public void setPermissaoList(List<Permissao> permissaoList) {
        this.permissaoList = permissaoList;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.dimb.inforural.business.Usuario[id=" + id + "]";
    }

}
