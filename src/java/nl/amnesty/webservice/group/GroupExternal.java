/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.amnesty.webservice.group;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import nl.amnesty.crm.entity.Role;
import nl.amnesty.crm.persistence.EMGroup;
import nl.amnesty.smtp.controller.MessageController;

/**
 *
 * @author evelzen
 */
@WebService()
@Stateless()
public class GroupExternal {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "gettreasurerviaaigroupmember")
    public Role gettreasurerviaaigroupmember(@WebParam(name = "Roleid") long roleid) {
        try {
            EMGroup em = new EMGroup();
            Logger.getLogger(GroupExternal.class.getName()).log(Level.INFO, "GroupExternal: gettreasurerviaaigroupmember");
            return em.roleReadTreasurerViaRoleid(roleid);
        } catch (Exception e) {
            Logger.getLogger(GroupExternal.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getaigroupnumberviaaigroupmember")
    public int getaigroupnumberviaaigroupmember(@WebParam(name = "Roleid") long roleid) {
        try {
            EMGroup em = new EMGroup();
            Logger.getLogger(GroupExternal.class.getName()).log(Level.INFO, "GroupExternal: getaigroupnumberviaaigroupmember");
            return em.roleReadGroupNumberViaRoleid(roleid);
        } catch (Exception e) {
            Logger.getLogger(GroupExternal.class.getName()).log(Level.SEVERE, null, e);
            return 0;
        }
    }
    /**
     * Web service operation
     * 
     * Hans Schwarte schrijft:
     * 
     * Een belangrijke debiteur is 31095: Bondgenoot Projecten. Deze krijgt 50% korting en we hebben inmiddels met hen een 
     * lange geschiedenis van verkeerde facturering aan hen. Op dit moment lukt het niet om hen 50% korting te geven, maar 
     * springt het kortingveld steeds terug naar WINKELS, waar 30% aan is gekoppeld. Ed zowel als Annette hebben dit bij Younify 
     * gemeld en die werken er aan. 
     * Ik herhaal in dit kader mijn eerdere suggestie om zodra de Bongenoot een bestelling heeft gedaan, ons een waarschuwingse-mail 
     * te sturen. Dat zou dan kunnen naar financien@amnesty.nl en wellicht a.kors@amnesty.nl.
     */
    @WebMethod(operationName = "getdebtornumberviaaigroupmember")
    public int getdebtornumberviaaigroupmember(@WebParam(name = "Roleid") long roleid) {
        try {
            EMGroup em = new EMGroup();
            Logger.getLogger(GroupExternal.class.getName()).log(Level.INFO, "GroupExternal: getdebtornumberviaaigroupmember");
            int debtornumber = em.roleReadDebtornumberViaRoleid(roleid);
            
            //DEBUG
            // Een belangrijke debiteur is 31095: Bondgenoot Projecten
            //if (debtornumber == 31095) {
            //    List<String> recipientlist = new ArrayList();
            //    recipientlist.add("financien@amnesty.nl");
            //    recipientlist.add("a.kors@amnesty.nl");
            //    recipientlist.add("e.vanvelzen@amnesty.nl");
            //    MessageController.sendEmail(recipientlist, "Bezoek webshop Bondgenoot Projecten", "Bondgenoot Projecten heeft ingelogd bij de webshop en mogelijk een bestelling geplaatst.");
            //}
            
            return debtornumber;
        } catch (Exception e) {
            Logger.getLogger(GroupExternal.class.getName()).log(Level.SEVERE, null, e);
            return 0;
        }
    }
}
