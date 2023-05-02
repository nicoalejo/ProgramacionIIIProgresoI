import javax.swing.*;
import java.util.*;
public class RedSocial {

    Queue<Persona> personasEnEspera = new LinkedList<>();
    Queue<Persona> personasActivas = new PriorityQueue<>((a,b) -> a.getPrioridad() - b.getPrioridad());
    //Queue<Persona> personasActivas = new PriorityQueue<>(Comparator.comparingInt(a -> a.prioridad));

    Stack<Persona> personasEliminadas = new Stack<>();

    public void AgregarPersonaColaEspera(Persona persona){
        boolean isAlreadyAdded = false;
        for(Persona p: personasEnEspera){
            if(p.getId() == persona.getId()){
                isAlreadyAdded = true;
                break;
            }
        }
        if(!isAlreadyAdded){
            for(Persona p: personasActivas){
                if(p.getId() == persona.getId()){
                    isAlreadyAdded = true;
                    break;
                }
            }
        }
        if(!isAlreadyAdded){
            for(Persona p: personasEliminadas){
                if(p.getId() == persona.getId()){
                    isAlreadyAdded = true;
                    break;
                }
            }
        }

        if(isAlreadyAdded){
            JOptionPane.showMessageDialog(null, "Persona ya creada");

        }
        else{
            JOptionPane.showMessageDialog(null,"Persona agregada exitosamente");
            personasEnEspera.add(persona);
        }
    }

    public List<Persona> QuemarDatos(){
        List<Persona> datosQuemados = new ArrayList<>();

        Persona p1 = new Persona(1, 52,20, 22, "Nicolas");
        datosQuemados.add(p1);
        Persona p2 = new Persona(2, 2,20, 22, "Mateo");
        datosQuemados.add(p2);
        Persona p3 = new Persona(3, 32,50, 22, "Jose");
        datosQuemados.add(p3);
        Persona p4 = new Persona(4, 55,80, 22, "Pepe");
        datosQuemados.add(p4);
        Persona p5 = new Persona(5, 21,100, 22, "Andres");
        datosQuemados.add(p5);

        personasEnEspera.addAll(datosQuemados);

        return datosQuemados;
    }

    public Persona BuscarPorId(int id, boolean buscarColaActiva) {
        Queue<Persona> colaBuscarPersona = buscarColaActiva ? personasActivas : personasEnEspera;
        for(Persona p: colaBuscarPersona){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public List<Persona> BuscarPorPrioridad(boolean buscarColaActiva) {
        Queue<Persona> colaBuscarPersona = buscarColaActiva ? personasActivas : personasEnEspera;
        List<Persona> personasEncontradas = new ArrayList<>();
        for(Persona p: colaBuscarPersona){
            if(p.getPrioridad() >= 50){
                personasEncontradas.add(p);
            }
        }
        return personasEncontradas;
    }

    public Persona ActivarUsuario() {
        if(!personasEnEspera.isEmpty()){
            Persona personaActiva = personasEnEspera.remove();
            personasActivas.add(personaActiva);
            return personaActiva;
        }
        return null;

    }

    public List<Persona> ActivarUsuarios() {
        if(!personasEnEspera.isEmpty()){
            List<Persona> personasActivasList = new ArrayList<>(personasEnEspera);
            personasActivas.addAll(personasEnEspera);
            personasEnEspera.clear();
            return personasActivasList;
        }
        return null;

    }

    public Persona EliminarUsuario() {
        if(!personasActivas.isEmpty()){
            Persona personaEliminada = personasActivas.remove();
            personasEliminadas.push(personaEliminada);
            return personaEliminada;
        }
        return null;
    }

    public List<Persona> EliminarUsuarios() {
        if(!personasActivas.isEmpty()){
            List<Persona> personasEliminadasList = new ArrayList<>(personasActivas);
            personasEliminadas.addAll(personasActivas);
            personasActivas.clear();
            return personasEliminadasList;
        }
        return null;
    }

    public Persona RestablecerPersona() {
        if(!personasEliminadas.isEmpty()){
            Persona personaRestablecida = personasEliminadas.pop();
            personasActivas.offer(personaRestablecida);
            return personaRestablecida;
        }
        else{
            return null;
        }
    }

    public List<Persona> RestablecerPersonas() {
        if(!personasEliminadas.isEmpty()){
            List<Persona> personaRestablecidas = new ArrayList<>(personasEliminadas);
            personasActivas.addAll(personasEliminadas);
            personaRestablecidas.clear();
            return personaRestablecidas;
        }
        return null;
    }

    public Queue<Persona> getPersonasActivas() {
        return personasActivas;
    }
}
