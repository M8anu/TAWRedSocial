/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafa
 */
@Entity
@Table(name = "Chat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c")
    , @NamedQuery(name = "Chat.findByIdChat", query = "SELECT c FROM Chat c WHERE c.idChat = :idChat")
    , @NamedQuery(name = "Chat.findByFechaCreacion", query = "SELECT c FROM Chat c WHERE c.fechaCreacion = :fechaCreacion")})
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idChat")
    private Integer idChat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinTable(name = "Lista_mensajes", joinColumns = {
        @JoinColumn(name = "idChat", referencedColumnName = "idChat")}, inverseJoinColumns = {
        @JoinColumn(name = "idMensaje", referencedColumnName = "id_mensaje")})
    @ManyToMany
    private List<Mensaje> mensajeList;
    @JoinTable(name = "Participa", joinColumns = {
        @JoinColumn(name = "idChat", referencedColumnName = "idChat")}, inverseJoinColumns = {
        @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChat")
    private List<Mensaje> mensajeList1;
    @JoinColumn(name = "tipoChat", referencedColumnName = "idTipo_Chat")
    @ManyToOne(optional = false)
    private TipoChat tipoChat;
    @JoinColumn(name = "usuarioCreador", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioCreador;

    public Chat() {
    }

    public Chat(Integer idChat) {
        this.idChat = idChat;
    }

    public Chat(Integer idChat, Date fechaCreacion) {
        this.idChat = idChat;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Mensaje> getMensajeList1() {
        return mensajeList1;
    }

    public void setMensajeList1(List<Mensaje> mensajeList1) {
        this.mensajeList1 = mensajeList1;
    }

    public TipoChat getTipoChat() {
        return tipoChat;
    }

    public void setTipoChat(TipoChat tipoChat) {
        this.tipoChat = tipoChat;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChat != null ? idChat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.idChat == null && other.idChat != null) || (this.idChat != null && !this.idChat.equals(other.idChat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "redsocial.entity.Chat[ idChat=" + idChat + " ]";
    }
    
}
