package newlab;

//import newlab.cdi.ee7.CDIHandler;
//import newlab.concurrency.ee7.ConcurrencyHandler;

import newlab.cdi.ee7.CDIHandler;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.UUID;

@SessionScoped
@ManagedBean

public class Handler implements Serializable {
    private String result = "result\nundefine";
    private String value = "undefine";

    private UUID uuid = UUID.randomUUID();
    //private Supplier<String> supplier;

    //@Inject
    //ConcurrencyHandler concurrencyHandler;

    @Inject
    CDIHandler cdiHandler;

    @PostConstruct
    public void init() {
        //supplier = concurrencyHandler;
    }

    public String apply(){
        this.value =  "My name is Name bean";
        this.result =  "Simple result\n" + getValue();
        this.result = cdiHandler.get();
        //return "name.xhtml";
        return null;
    }

    public String getValue() {
        return new java.util.Date ().toString () + ": " + uuid + ": " + value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getResult() {
        return result ;
    }

    public void setResult(String value) {
        this.result = value;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


}
