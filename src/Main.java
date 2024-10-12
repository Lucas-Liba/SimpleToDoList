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
            System.out.println("Ingrese 1 para ver la lista de tareas, 2 para agregar un item,0 para salir");
            accion = sc.nextInt();
            if (accion == 1){
                listaDeTareas.mostrarLista();
            } else if (accion==2) {
                listaDeTareas.crearItem();
            }else if (accion==0){
                end = true;
            }else{
                System.out.println("No se pudo interpretar el comando");
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
            }
        }else{
            System.out.println("La lista esta vacia");
        }

    }
}