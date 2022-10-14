/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inmac
 */
@Entity
@Table(name = "belong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Belong.findAll", query = "SELECT b FROM Belong b"),
    @NamedQuery(name = "Belong.findById", query = "SELECT b FROM Belong b WHERE b.id = :id"),
    @NamedQuery(name = "Belong.findByUserId", query = "SELECT b FROM Belong b WHERE b.userId = :userId"),
    @NamedQuery(name = "Belong.findByGroupId", query = "SELECT b FROM Belong b WHERE b.groupId = :groupId")})
public class Belong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
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

    public Belong() {
    }

    public Belong(Integer id) {
        this.id = id;
    }

    public Belong(Integer id, int userId, int groupId) {
        this.id = id;
        this.userId = userId;
        this.groupId = groupId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Belong)) {
            return false;
        }
        Belong other = (Belong) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntv.pojo.Belong[ id=" + id + " ]";
    }
    
}
