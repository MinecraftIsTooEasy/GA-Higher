package com.github.Debris.GAHigher.api;

public @interface Condition {
    String value();

    String versionPredicate() default "*";
}
