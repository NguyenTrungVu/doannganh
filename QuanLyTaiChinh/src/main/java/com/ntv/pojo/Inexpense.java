/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inmac
 */
@Entity
@Table(name = "inexpense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inexpense.findAll", query = "SELECT i FROM Inexpense i"),
    @NamedQuery(name = "Inexpense.findById", query = "SELECT i FROM Inexpense i WHERE i.id = :id"),
    @NamedQuery(name = "Inexpense.findByUserId", query = "SELECT i FROM Inexpense i WHERE i.userId = :userId"),
    @NamedQuery(name = "Inexpense.findByPurpose", query = "SELECT i FROM Inexpense i WHERE i.purpose = :purpose"),
    @NamedQuery(name = "Inexpense.findByPrice", query = "SELECT i FROM Inexpense i WHERE i.price = :price"),
    @NamedQuery(name = "Inexpense.findByCreatedDate", query = "SELECT i FROM Inexpense i WHERE i.createdDate = :createdDate"),
    @NamedQuery(name = "Inexpense.findByType", query = "SELECT i FROM Inexpense i WHERE i.type = :type")})
public class Inexpense implements Serializable {
    
    public static final String INCOME = "INCOME";
    public static final String EXPENSE = "EXPENSE";
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message = "{inexpense.purpose.nullErr}")
    @Column(name = "purpose")
    private String purpose;
    @NotNull(message = "{inexpense.price.nullErr}")
    @Column(name = "price")
    private Long price;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10, message = "{inexpense.type.nullErr}")
    @Column(name = "type")
    private String type;

    public Inexpense() {
    }

    public Inexpense(Integer id) {
        this.id = id;
    }

    public Inexpense(Integer id, int userId, String purpose, String type) {
        this.id = id;
        this.userId = userId;
        this.purpose = purpose;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Inexpense)) {
            return false;
        }
        Inexpense other = (Inexpense) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntv.pojo.Inexpense[ id=" + id + " ]";
    }
    
}
