package Views;

import Models.*;

public class UserInfoView {
    private User Model;

    public UserInfoView(User model) {
        Model = model;
    }
    public void Render() {
        if(Model!=null){
            System.out.println(">>>> User DETAIL INFORMATION:");
            System.out.println("> Ten :"+Model.getName());
            System.out.println("> Tuoi:"+Model.getAge());
            System.out.println("> Permision:"+Model.getAuthorization());
            if (Model.getClass().getSimpleName().equals("Admin")) {
                RenderAdmin((Admin) Model);
    
            } else if (Model.getClass().getSimpleName().equals("Customer")) {
                RenderCustomer((Customer) Model);
            }
        }
    }

    private void RenderAdmin(User model) {
        
    }

    private void RenderCustomer(Customer model) {
        
    }
}
