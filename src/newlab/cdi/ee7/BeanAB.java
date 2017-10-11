package newlab.cdi.ee7;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import java.lang.annotation.Annotation;

@Stateless

@A(value = "AB")

@HandlerEDAnnotation(clazz = ED101.class)

public class BeanAB implements InterfaceA  {

    private final Class<? extends Annotation> handlerEDClazz = getClass().getAnnotation(HandlerEDAnnotation.class).clazz();
    //private final Annotation annotationEDClazz = getClass().getAnnotation(HandlerEDAnnotation.class);


    //@Inject @ED101
    //Rule rule;

    @Inject @Any //@ED101 //@ValidationMode(rejected=true)
    private Instance<Rule> rules;

    @Override
    public String get() {
        String res = "BeanAB\n";
        res += "Bean annotation =\n";
        Annotation[] annotations = this.getClass().getDeclaredAnnotations();
        for(Annotation a : annotations) {
            res += a.toString() + ", ";
        }
        res+="\n---\n";

        res += "handlerEDClazz = " + handlerEDClazz + "\n";

        res +="Rules = " + rules + "\n";
        for (Rule r : rules) {
            res += "Rule class = " + r.getClass().getName() + "\n";
            res += "     result = " + r.apply() + "\n";
            res += "     applied to " + handlerEDClazz.getName() + " = " + r.isAppliedTo(handlerEDClazz);
            res += "     annotations = [ ";

            Annotation[] anns = r.getClass().getDeclaredAnnotations();
            for(Annotation a : anns) {
                res += a.toString() + ", ";
            }
            res+="]\n";

            Annotation annotation = r.getClass().getAnnotation(handlerEDClazz);
            res += "     checked annotation = " + annotation + "\n";
            if (annotation != null) {
                res += "     FOUND RULE:\n" + r.apply();
            }
        }

        //Instance<Rule> handlerRules = rules.select(Rule.class, handlerEDClazz );
        Instance<Rule> handlerRules = rules.select(new AnnotationLiteral<ED101>() {});
        //Instance<Rule> handlerRules = rules.select(Rule.class, );

        res +="Selected rules = " + handlerRules + "\n";
        for (Rule r : handlerRules) {
            res += "Rule class = " + r.getClass().getName() + "\n";
            res += "     result = " + r.apply() + "\n";
        }
        /*
        res += "Injected Rule = " + rule.getClass().getName() + "\n Rule result = " + rule.apply() + "\n";

        res += "Rule annotation =\n";
        annotations = rule.getClass().getDeclaredAnnotations();
        for(Annotation a : annotations) {
            res += a.toString() + ", ";
        }
        res+="\n---\n";

        Annotation ruleAnnotation = rule.getClass().getAnnotation(handlerEDClazz);
        if (ruleAnnotation != null) {
            res += "This rule is for this handler = " + ruleAnnotation.annotationType() + "\n";
            res += "Rule result = " + rule.apply() +"\n";
        } else {
            res += "This rule is not for this handler\n";
        }
        */
        /*
        ErrorCodeAnnotation b = this.getClass().getAnnotation(ErrorCodeAnnotation.class);
            if (b != null) {
                res += "ErrorCode = " + b.code().getErrCode() + "\n";
            }

            HandlerEDAnnotation c = this.getClass().getAnnotation(HandlerEDAnnotation.class);
            if (c != null) {
                res += "Clazz = " + c.clazz().getName() + "\n";
            }

        res += "Annotations: ";
        */

        return res + "\n" ;

    }

}
