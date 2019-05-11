/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author rafa
 */
@Entity
@Table(name = "Tipo_Chat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoChat.findAll", query = "SELECT t FROM TipoChat t")
    , @NamedQuery(name = "TipoChat.findByIdTipoChat", query = "SELECT t FROM TipoChat t WHERE t.idTipoChat = :idTipoChat")})
public class TipoChat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "idTipo_Chat")
    private String idTipoChat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoChat")
    private List<Chat> chatList;

    public TipoChat() {
    }

    public TipoChat(String idTipoChat) {
        this.idTipoChat = idTipoChat;
    }

    public String getIdTipoChat() {
        return idTipoChat;
    }

    public void setIdTipoChat(String idTipoChat) {
        this.idTipoChat = idTipoChat;
    }

    @XmlTransient
    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoChat != null ? idTipoChat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoChat)) {
            return false;
        }
        TipoChat other = (TipoChat) object;
        if ((this.idTipoChat == null && other.idTipoChat != null) || (this.idTipoChat != null && !this.idTipoChat.equals(other.idTipoChat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "redsocial.entity.TipoChat[ idTipoChat=" + idTipoChat + " ]";
    }
    
}
