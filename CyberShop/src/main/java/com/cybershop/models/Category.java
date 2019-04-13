
package com.cybershop.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
    , @NamedQuery(name = "Category.findByCateID", query = "SELECT c FROM Category c WHERE c.cateID = :cateID")
    , @NamedQuery(name = "Category.findByCateName", query = "SELECT c FROM Category c WHERE c.cateName = :cateName")
    , @NamedQuery(name = "Category.findByType", query = "SELECT c FROM Category c WHERE c.type = :type")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CateID")
    private Integer cateID;
    @Size(max = 150)
    @Column(name = "CateName")
    private String cateName;
    @Column(name = "Type")
    private Boolean type;
    @OneToMany(mappedBy = "categoryID")
    private Collection<Product> productCollection;

    public Category() {
    }

    public Category(Integer cateID) {
        this.cateID = cateID;
    }

    public Integer getCateID() {
        return cateID;
    }

    public void setCateID(Integer cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cateID != null ? cateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.cateID == null && other.cateID != null) || (this.cateID != null && !this.cateID.equals(other.cateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cybershop.models.Category[ cateID=" + cateID + " ]";
    }
    
}
