package Views;

import Framework.ViewHelp;
import Models.*;


public class UserUpdateView {
    private User Model;

    public UserUpdateView(User model) {
        Model = model;
    }

    public void Render() {

        if (Model.getClass().getSimpleName().equals("Admin")) {
            RenderAdmin((Admin) Model);

        } else if (Model.getClass().getSimpleName().equals("Customer")) {
            RenderCustomer((Customer) Model);
        }
    }

    private void RenderAdmin(User model) {
        model.setName(ViewHelp.inputString("> Ten admin : ", Model.getName()));
        model.setAge(ViewHelp.inputInt("> Tuoi : ", Model.getAge()));
    }

    private void RenderCustomer(Customer model) {
        model.setName(ViewHelp.inputString("> Ten khach hang : ", Model.getName()));
        model.setAge(ViewHelp.inputInt("> Tuoi : ", Model.getAge()));
    }
}
