package Views;

import Framework.Help;
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
        model.setName(Help.inputString("> Ten admin : ", Model.getName()));
        model.setAge(Help.inputInt("> Tuoi : ", Model.getAge()));
    }

    private void RenderCustomer(Customer model) {
        model.setName(Help.inputString("> Ten khach hang : ", Model.getName()));
        model.setAge(Help.inputInt("> Tuoi : ", Model.getAge()));
    }
}
