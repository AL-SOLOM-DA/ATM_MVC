package net.company;

import net.company.controller.Controller;
import net.company.model.Model;
import net.company.view.UserView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
	    UserView userView = new UserView(controller);
	    SwingUtilities.invokeLater(()->{
            userView.init();
	    });
    }
}
