package com.kademika.day10.generics.basic.service1;

/**
 * Created by Админ on 30.06.2014.
 */

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface service {

}
