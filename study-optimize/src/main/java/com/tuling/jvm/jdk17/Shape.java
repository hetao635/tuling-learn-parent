package com.tuling.jvm.jdk17;

public sealed abstract class Shape permits Circle, Square{

    public abstract int lines();
}
