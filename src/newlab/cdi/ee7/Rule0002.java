package newlab.cdi.ee7;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import java.lang.annotation.Annotation;


@Stateless
@ErrorCodeAnnotation(code=ErrorCode.ERR_0002)
@ValidationMode(rejected = false)
//@ED101
@ED201
//@Default

public class Rule0002 implements Rule {

    @Override
    public String apply() {
        String res = "Rule 0002:";
        res += "annotation = [";
        Annotation[] annotations = this.getClass().getDeclaredAnnotations();
        for(Annotation a : annotations) {
            res += a.toString() + ", ";
        }
        res+="], ";

        res += "error code = " + getErrorCode().toString() +"\n";

        return res;
    }

    @Override
    public boolean isAppliedTo(Class<? extends Annotation> annotationClazz) {
        boolean res = false;
        Annotation a = this.getClass().getAnnotation(annotationClazz);
        if (a != null) res = true;
        return res;
    }

    public ErrorCode getErrorCode() {
        return this.getClass().getAnnotation(ErrorCodeAnnotation.class).code();
    }

}
