package agentes;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import javax.swing.JFrame;

public class AgentManager {

    public static final jade.core.Runtime rt = jade.core.Runtime.instance();
    public static Profile p = new ProfileImpl();
    public static ContainerController container = rt.createMainContainer(p);

    public static void creaAgente(String name, String classname, Object[] args) {
        try {
            AgentController aa = container.createNewAgent(name, classname, args);
            aa.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void destruyeAgente(String name) {
        try {
            container.getAgent(name).kill();
        } catch (Exception error) {
            System.out.println("El agente no se ha creado");
        }
    }
}
