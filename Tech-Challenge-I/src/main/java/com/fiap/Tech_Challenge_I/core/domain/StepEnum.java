package com.fiap.Tech_Challenge_I.core.domain;

public enum StepEnum {
    preparation(1),conference(2),delivery(3);

    private final int stepEvent;

    StepEnum(int step){
        stepEvent = step;
    }

    public int getStep() {
        return stepEvent;
    }
}
