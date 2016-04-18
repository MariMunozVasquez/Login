package mx.uatx;

 
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
 

@Controller
@ManagedBean
@SessionScoped
public class RegisterEmployee {
 
    //@ManagedProperty(value="#{employeeService}")
	@Autowired
    private EmployeeService employeeService;
 
    private EmployeeDTO employee = new EmployeeDTO();
 
    public EmployeeService getEmployeeService() {
        return employeeService;
    }
    
    
    @PostConstruct
    public void init(){
    	employee = new EmployeeDTO();
    }
 
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
 
    public EmployeeDTO getEmployee() {
        return employee;
    }
 
    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
 
    public String register() {
        // Calling Business Service
        employeeService.register(employee);
        // Add message
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("The Employee "+this.employee.getUsuario()+" Is Registered Successfully"));
        return "";
    }
}