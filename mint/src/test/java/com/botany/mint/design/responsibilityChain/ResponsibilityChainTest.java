package com.botany.mint.design.responsibilityChain;

import com.botany.mint.design.responsibilityChain.chain.ProcessChain;
import com.botany.mint.design.responsibilityChain.student.IStudent;
import com.botany.mint.design.responsibilityChain.student.impl.Student;
import org.junit.Test;

import java.util.Random;

public class ResponsibilityChainTest {

    @Test
    public void responsibilityChainTest() {
        ProcessChain processChain = ProcessChain.getInstance();

        Random random = new Random();
        for (int i = 0; i < 3; i ++) {
            int radom = random.nextInt(3);
            IStudent student = new Student(radom, "学生" + i + "生病了，要请假！");
            System.out.println("#############################");
            processChain.process(student);
            System.out.println("#############################");
        }
    }
}
