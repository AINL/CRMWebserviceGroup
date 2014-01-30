/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.amnesty.webservice.group;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import nl.amnesty.crm.entity.Group;
import nl.amnesty.crm.entity.Role;

/**
 *
 * @author ed
 * algemene webservices uitgezet uit beveiligingsoogpunt
 */
@WebService()
@Stateless()
public class GroupCRUD {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "dummy")
    public String dummy() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
    
    @WebMethod(operationName = "create")
    public long create(
            @WebParam(name = "Rolelist") List<Role> rolelist,
            @WebParam(name = "Name") String name,
            @WebParam(name = "Description") String description) {
        //TODO write your implementation code here:
        long groupid = 123456789;
        return groupid;
    }
    */

    /**
     * Web service operation
     
    @WebMethod(operationName = "read")
    public Group read(long groupid) {
        //TOrDO write your implementation code here:
        Group group = new Group();
        group.setName("Name");
        group.setDescription("Description");
        return group;
    }
    */

    /**
     * Web service operation
     
    @WebMethod(operationName = "update")
    public long update(@WebParam(name = "Groupid") long groupid,
            @WebParam(name = "Rolelist") List<Role> rolelist,
            @WebParam(name = "Name") String name,
            @WebParam(name = "Description") String description) {
        //TODO write your implementation code here:
        return groupid;
    }
    */

    /**
     * Web service operation
     
    @WebMethod(operationName = "delete")
    public long delete(@WebParam(name = "Groupid") long groupid) {
        //TODO write your implementation code here:
        return groupid;
    }
    */
}
