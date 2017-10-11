package newlab.cdi.ee7;

import java.lang.annotation.Annotation;

/**
 * Created by Game on 11.10.2017.
 */
public interface Rule {
    String apply();
    boolean isAppliedTo(Class<? extends Annotation> annotationClazz);
}
