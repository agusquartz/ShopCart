
package Controller;

import Repository.Client;
import Repository.Repository;

/**
 *
 * @author agustin
 */
public class ControllerClient {
    private final Repository REPOSITORY;
    
    public ControllerClient(){
        this.REPOSITORY = Repository.getInstance();
    }
    
    public Client searchClient(String idNumber){
        return this.REPOSITORY.getClients().get(idNumber);
    }
    
    public static void main(String[] args){
        ControllerClient controlerclient = new ControllerClient();
        System.out.println("\nActions leidos de JSON");
        
        controlerclient.REPOSITORY.getActions().forEach((clave, valor) -> System.out.println("Clave: " + clave + "\n" + "Valores: \n" + valor));
        controlerclient.REPOSITORY.saveActions();
//        controlerclient.REPOSITORY.getMovies().forEach((clave, valor) -> System.out.println(clave + ":" + valor));
//        controlerclient.REPOSITORY.saveMovies();
//        controlerclient.REPOSITORY.getClients().forEach((clave, valor) -> System.out.println(clave + ":" + valor));
//        controlerclient.REPOSITORY.saveClients();
    }
    
}
