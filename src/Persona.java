public class Persona {

    int id, edad, prioridad, amigos;
    String nombreCompleto;

    public Persona(int id, int edad, int prioridad, int amigos, String nombreCompleto) {
        this.id = id;
        this.edad = edad;
        this.prioridad = prioridad;
        this.amigos = amigos;
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString(){
        return "\nId: " + id +
                "\nNombre: " + nombreCompleto +
                "\nEdad: " + edad +
                "\nPrioridad: " + prioridad +
                "\nAmigos: " + amigos;
    }
}
