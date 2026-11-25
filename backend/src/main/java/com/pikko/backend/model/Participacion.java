package com.pikko.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.pikko.backend.model.enums.EstadoParticipacion;
import com.pikko.backend.model.enums.TipoPrueba;

@Entity
@Table(
    name = "participaciones",
    uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "reto_id"})
)
public class Participacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoParticipacion estado = EstadoParticipacion.APUNTADO;

    @Enumerated(EnumType.STRING)
    private TipoPrueba metodoPrueba;

    private boolean publica;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    private int puntosObtenidos = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reto_id", nullable = false)
    private Reto reto;
    
    private LocalDateTime fechaEnvio;
    
    private LocalDateTime fechaCompletado;

    @Column(nullable = false)
    private LocalDateTime fechaUnion;

    @PrePersist
    void registrarUnion() {
        fechaUnion = LocalDateTime.now();
    }

    public Participacion(){
    }

    public Participacion(Usuario usuario, Reto reto){
        this.usuario = usuario;
        this.reto = reto;
    }

    public Long getId() {
        return id;
    }

    public EstadoParticipacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoParticipacion estado) {
        this.estado = estado;
    }

    public TipoPrueba getMetodoPrueba() {
        return metodoPrueba;
    }

    public void setMetodoPrueba(TipoPrueba metodoPrueba) {
        this.metodoPrueba = metodoPrueba;
    }

    public boolean isPublica() {
        return publica;
    }

    public void setPublica(boolean publica) {
        this.publica = publica;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Reto getReto() {
        return reto;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public LocalDateTime getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(LocalDateTime fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }

    public LocalDateTime getFechaUnion() {
        return fechaUnion;
    }


    

}
