package newlab.cdi.ee7;

import javax.ejb.Stateless;

/**
 * Created by Radoselskiy on 07.08.2017.
 */

@Stateless

@A (value = "AA")

public class BeanAA implements InterfaceA {
    @Override
    public String get() { return "BeanAA";}
}
