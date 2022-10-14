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
@Table(name = "groupexpense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupexpense.findAll", query = "SELECT g FROM Groupexpense g"),
    @NamedQuery(name = "Groupexpense.findById", query = "SELECT g FROM Groupexpense g WHERE g.id = :id"),
    @NamedQuery(name = "Groupexpense.findByUserId", query = "SELECT g FROM Groupexpense g WHERE g.userId = :userId"),
    @NamedQuery(name = "Groupexpense.findByGroupId", query = "SELECT g FROM Groupexpense g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "Groupexpense.findByPurpose", query = "SELECT g FROM Groupexpense g WHERE g.purpose = :purpose"),
    @NamedQuery(name = "Groupexpense.findByPrice", query = "SELECT g FROM Groupexpense g WHERE g.price = :price"),
    @NamedQuery(name = "Groupexpense.findByCreatedDate", query = "SELECT g FROM Groupexpense g WHERE g.createdDate = :createdDate"),
    @NamedQuery(name = "Groupexpense.findByType", query = "SELECT g FROM Groupexpense g WHERE g.type = :type")})
public class Groupexpense implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private int type;

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
    @Column(name = "group_id")
    private int groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "purpose")
    private String purpose;
    @Column(name = "price")
    private Long price;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Groupexpense() {
    }

    public Groupexpense(Integer id) {
        this.id = id;
    }

    public Groupexpense(Integer id, int userId, int groupId, String purpose, int type) {
        this.id = id;
        this.userId = userId;
        this.groupId = groupId;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupexpense)) {
            return false;
        }
        Groupexpense other = (Groupexpense) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntv.pojo.Groupexpense[ id=" + id + " ]";
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
