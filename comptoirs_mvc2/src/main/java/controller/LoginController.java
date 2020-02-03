package controller;

import comptoirs.model.dao.ClientFacade;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import java.math.BigDecimal;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

@Controller
@Path("login")
@View("login.jsp")
public class LoginController {

    @Inject
    ClientFacade facadeC;

    @Inject
    Models models;

    @POST
    public String login(@FormParam("nom") String nom, @FormParam("code") int code) {
        if (facadeC.find(code).getContact()== nom){
            return "redirect:/produits";
        }
        models.put("databaseErrorMessage", "Mot de passe ou login incorrect");
        return "";
    }

}
