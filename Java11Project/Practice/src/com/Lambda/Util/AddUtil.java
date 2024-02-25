package com.Lambda.Util;

import com.Lambda.Functional.ICompute;

public class AddUtil {

    private final ICompute compute;

    public AddUtil(ICompute compute){
        this.compute = compute;
    }

    public Double add(){
        return compute.compute();
    }
}
