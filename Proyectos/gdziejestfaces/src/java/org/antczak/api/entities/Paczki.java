/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.antczak.api.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paweł
 */
@Entity
@Table(name = "paczki")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paczki.findAll", query = "SELECT p FROM Paczki p"),
    @NamedQuery(name = "Paczki.findById", query = "SELECT p FROM Paczki p WHERE p.id = :id"),
    @NamedQuery(name = "Paczki.findByFirma", query = "SELECT p FROM Paczki p WHERE p.firma = :firma"),
    @NamedQuery(name = "Paczki.findByNumer", query = "SELECT p FROM Paczki p WHERE p.numer = :numer"),
    @NamedQuery(name = "Paczki.findByData", query = "SELECT p FROM Paczki p WHERE p.data = :data")})
public class Paczki implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "firma")
    private String firma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numer")
    private String numer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public Paczki() {
    }

    public Paczki(Integer id) {
        this.id = id;
    }

    public Paczki(Integer id, String firma, String numer, Date data) {
        this.id = id;
        this.firma = firma;
        this.numer = numer;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        if (!(object instanceof Paczki)) {
            return false;
        }
        Paczki other = (Paczki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.antczak.api.entities.Paczki[ id=" + id + " ]";
    }
    
}
