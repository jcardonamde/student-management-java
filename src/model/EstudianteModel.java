package model;

public class EstudianteModel {
    private int codigo;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private int estrato;
    
    public EstudianteModel () {
        this.codigo = 0;
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = "";
        this.estrato = -1;
    }

    public EstudianteModel(int codigo, String nombre, String apellido, String direccion, String telefono, int estrato) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estrato = estrato;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }
}

/* Estructura del Modelo en la BD */
/*
CREATE TABLE estudiantes(
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) DEFAULT 'NOT REGISTER',
    telefono VARCHAR(20) NULL,
    estrato INT DEFAULT -1
);
*/