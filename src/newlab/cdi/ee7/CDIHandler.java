package newlab.cdi.ee7;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.function.Supplier;
//import javax.enterprise.inject.Instance;

@Stateless
public class CDIHandler //implements Supplier<String>

{

    private String r = "Not initialized\n";

    @Inject @A(value = "AA")
    private InterfaceA interfaceA;

    @Inject @A(value = "AB")
    private InterfaceA interfaceB;

    //@Inject
    //private Instance<InterfaceA> interfaces;


    @PostConstruct
    private void init() {
        r = "";
        /*
        if (interfaceA != null) {
            r += "interfaceAA = " + interfaceA.get() + ";\n" ;
        } else {
            r += "interfaceAA = null; \n";
        }
        if (interfaceB != null) {
            r += "interfaceAB = " + interfaceB.get() + ";\n" ;
        } else {
            r += "interfaceAB = null; \n";
        }
        */
        r = "interfaceAA = " + interfaceA.get() + ";\n"
            + "interfaceAB = " + interfaceB.get() + ";\n";


    }

    public String get() {
        return r;
    }
}
