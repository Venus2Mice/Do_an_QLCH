package Views;

import Framework.ViewHelp;
import Models.Admin;
import Models.Customer;
import Models.User;

public class UserCreateView {
    private User Model;

    public UserCreateView(User model) {
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
        model.setName(ViewHelp.inputString("> Ten admin : "));
        model.setAge(ViewHelp.inputInt("> Tuoi : "));
    }

    private void RenderCustomer(Customer model) {
        model.setName(ViewHelp.inputString("> Ten khach hang : "));
        model.setAge(ViewHelp.inputInt("> Tuoi : "));
        model.setDescription(ViewHelp.inputString("> Mo ta : "));
    }
    
}
