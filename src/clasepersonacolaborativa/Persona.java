package clasepersonacolaborativa;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Persona {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos) {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();

        } else {
            this.nombre = nombre;
            this.apellido = apellidos;
        }
    }

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {

        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();

        } else {
            this.nombre = nombre;
            this.apellido = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }

    }

    private LocalDate generarFecha(String fecha) {

        int dia;
        int mes;
        int anyo;

        if (!fecha.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")
                && !fecha.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
            throw new IllegalArgumentException();
        } else {
            try {
                dia = Integer.parseInt(fecha.subSequence(0, 2).toString());
                mes = Integer.parseInt(fecha.subSequence(3, 5).toString());
                anyo = Integer.parseInt(fecha.subSequence(6, fecha.length()).toString());

                return LocalDate.of(anyo, mes, dia);
            } catch (NumberFormatException ex1) {
                throw new IllegalArgumentException();
            } catch (DateTimeException ex2) {
                throw new IllegalArgumentException();
            }

        }

    }

    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }
}
