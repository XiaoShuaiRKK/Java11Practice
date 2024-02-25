package com.Annotation.Inherited.SelfAnnotation;

import javax.swing.text.Element;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HasInherited {
}
