
package Entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.codehaus.plexus.util.Base64;

/**
 *
 * @author R2
 */

@Entity
@Table(name = "Maestro")
public class Maestro {
    
    @Id
    @Column(name = "IdMaestro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "Contraseña", nullable = false, length = 100)
    private String contraseña;
    
    @Column(name = "CorreoElectronico", nullable = false, length = 100)
    private String correo;
    
    @OneToMany(mappedBy = "maestro", cascade = CascadeType.ALL)
    private List<Curso> curso;

    public Maestro() {
    }

    public Maestro(String correo, String contraseña) throws NoSuchAlgorithmException {
        this.correo = correo;
        this.contraseña = cifrarSHA(contraseña);
    }

    public Maestro(String nombre, String contraseña, String correo) throws NoSuchAlgorithmException {
        this.nombre = nombre;
        this.contraseña = cifrarSHA(contraseña);
        this.correo = correo;
        this.curso = new ArrayList<>();
    }

    public Maestro(Long id, String nombre, String contraseña, String correo, List<Curso> curso) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.contraseña);
        hash = 29 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Maestro other = (Maestro) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String cifrarSHA(String textoACifrar) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_384);
        md.update(textoACifrar.getBytes());
        byte[] digest = md.digest();
        // Se escribe codificado base 64. Se necesita la librería
        // commons-codec-x.x.x.jar de Apache
        byte[] encoded = Base64.encodeBase64(digest);

        return new String(encoded);
    }

    @Override
    public String toString() {
        return "Maestro{" + "id=" + id + ", nombre=" + nombre + ", contrase\u00f1a=" + contraseña + ", correo=" + correo + '}';
    }


}
