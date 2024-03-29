package com.consultorio.consultorio;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity

public class Consultorio {
    private @Id @GeneratedValue Long id;
    private String numero;
    private String piso;
    private String especialidad;

    Consultorio() {}
    Consultorio(String numero, String piso, String especialidad)
    {
        this.numero = numero;
        this.piso = piso;
        this.especialidad = especialidad;}
}
