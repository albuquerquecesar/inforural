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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Albuquerque
 */
@Entity
@Table(name = "permissao", catalog = "inforural", schema = "")
@NamedQueries({
    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p"),
    @NamedQuery(name = "Permissao.findByRole", query = "SELECT p FROM Permissao p WHERE p.role = :role"),
    @NamedQuery(name = "Permissao.findById", query = "SELECT p FROM Permissao p WHERE p.id = :id")})
public class Permissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "role", length = 40)
    private String role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToMany(mappedBy = "permissaoList", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Permissao() {
    }

    public Permissao(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.dimb.inforural.business.Permissao[id=" + id + "]";
    }

}
