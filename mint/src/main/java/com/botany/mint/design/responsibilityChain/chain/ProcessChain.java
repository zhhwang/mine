package com.botany.mint.design.responsibilityChain.chain;

import com.botany.mint.design.responsibilityChain.student.IStudent;
import com.botany.mint.design.responsibilityChain.handler.IHandler;
import com.botany.mint.design.responsibilityChain.handler.impl.SchoolMaterHandler;
import com.botany.mint.design.responsibilityChain.handler.impl.SquadLeaderHandler;
import com.botany.mint.design.responsibilityChain.handler.impl.TeacherHandler;

public class ProcessChain {
    private IHandler sqmdhandler;

    private IHandler teacherhandler;

    private IHandler scmshandler;

    private static ProcessChain processChain = new ProcessChain();

    public static ProcessChain getInstance() {
        return processChain;
    }

    private ProcessChain() {
        this.sqmdhandler = new SquadLeaderHandler();
        this.teacherhandler = new TeacherHandler();
        this.scmshandler = new SchoolMaterHandler();
        sqmdhandler.setNextHandler(teacherhandler);
        teacherhandler.setNextHandler(scmshandler);
    }

    public void process(IStudent student) {
        sqmdhandler.handleRequest(student);
    }
}
