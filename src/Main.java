import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        toDoList listaDeTareas = new toDoList();
        Scanner sc = new Scanner(System.in);
        int accion;
        boolean end=false;
        System.out.println("Bienvenido al gestor de tareas");
        do{
            System.out.println("Ingrese 1 para ver la lista de tareas, 2 para agregar un item,3 para actualizar,0 para salir: ");
            accion = sc.nextInt();
            switch (accion){
                case 1:
                    listaDeTareas.mostrarLista();
                    break;
                case 2:
                    listaDeTareas.crearItem();
                    break;
                case 3:
                    listaDeTareas.actualizarEstado();
                    break;
                case 0:
                    end = true;
                    break;
                default:
                    System.out.println("No se pudo interpretar el comando");
                    break;
            }
        }while(!end);

    }
}

class ToDoItem{
    String titulo,mensaje;
    boolean completada;

    public ToDoItem(String titulo,String mensaje){
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.completada = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}

class toDoList{
    List<ToDoItem> listaDeTareas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void crearItem(){
        String titulo,mensaje;
        System.out.println("Ingrese el titulo del item");
        titulo = sc.nextLine();
        System.out.println("Ingrese el mensaje del item");
        mensaje = sc.nextLine();
        listaDeTareas.add(new ToDoItem(titulo,mensaje));
    }
    public void mostrarLista(){
        if (!listaDeTareas.isEmpty()){
            for (ToDoItem i : listaDeTareas){
                System.out.println("Titulo: " + i.getTitulo());
                System.out.println("Mensaje: " + i.getMensaje());
                System.out.println((i.isCompletada() ? "Completada" : "No completada"));
                System.out.println("-------------------------------");
            }
        }else{
            System.out.println("La lista esta vacia");
        }

    }
    public void actualizarEstado(){
        System.out.println("Escribe el titulo de la tarea que quieres actualizar:");
        String titulo = sc.nextLine();
        boolean encontrada=false;
        for(ToDoItem i : listaDeTareas){
            if(i.getTitulo().equals(titulo)){
                i.setCompletada(!(i.isCompletada()));
                encontrada = true;
            }
        }
        if(!encontrada){
            System.out.println("No se encuentra una tarea con titulo: "+ titulo);
        }
    }
}