package com.envision;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class SampleExcel {
    @Test
    public void pullData() throws IOException {
        DataDrivenExxcel d=new DataDrivenExxcel();
        ArrayList data=d.getData("Purchese");
        System.out.println(data.get(0));
        System.out.println(data.get(2));



    }
}
