package view;

import controller.Controller;
import model.User;

import java.util.Scanner;

public class GuiText implements Gui {

    public GuiText() {

    }

    public void launch() {
        System.out.println("Entrer le pseudo : ");
        Scanner scanner = new Scanner(System.in);
        String pseudo = scanner.next();
        Controller.getInstance().connect(pseudo);
    }

    public void setUserStatus(String name, String status) {
        System.out.println(name + " est maintenant deconnecté " + status);
    }

    public void addUserToChat(String name, Message msg) {
        System.out.println(name + " viens de se connecter." );
    }

    public void deliverMessage(network.Message msg) {
        System.out.println("Message de " + msg.getSrcPseudo() + " : " + msg.getData());
    }

    public void deliverText(String dest, String Message, String source) {
        System.out.println("Message de " + dest + " : " + Message);
    }

    public void addNewUser(User u1) {
        System.out.println(u1.getPseudo() + " est maintenant connecté." );
    }

    /**
     * We add an panelUserContact withe corresponding username
     * @param name the name of the user
     * @param panel the panel on the contact window
     */
    public void addUserToPanel(String name, PanelUserContact panel) {

    }

    public void createMainWindow() {
        System.out.println("Vous êtes connecté.");
    }

    public void notif(String s) {
        System.out.println(s);
    }

    @Override
    public void deliverImage(String dest, String path) {

    }

    @Override
    public String chooseDirectory(String dest) {
        System.out.println("This method doesn't exist in text mod....");
        return null;
    }

}
