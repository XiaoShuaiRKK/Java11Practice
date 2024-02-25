package com.Handle.Process;

import javax.swing.text.html.Option;
import java.security.NoSuchProviderException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Java 9 中增加了ProcessHandle接口,可以对原生进程进行管理
 * ProcessHandle接口的引入使得Java开发人员可以更加方便地管理和监控正在运行的进程。
 * 尤其适合管理长时间运行的进程
 */
public class ProcessHandleTest {
    public static void main(String[] args) throws NoSuchProviderException {
        getChildProcess(5996);
    }

    public static void getPID(){
        ProcessHandle currentProcess = ProcessHandle.current();
        long pid = currentProcess.pid();
        System.out.println("当前的进程PID: " + pid);
    }
    public static void monitorProcessState(long pid) throws NoSuchProviderException {
        ProcessHandle process = ProcessHandle.of(pid)
                .orElseThrow(NoSuchProviderException::new);
        boolean isAlive = process.isAlive();
        System.out.println("进程是否存活: " + isAlive);
        process.onExit().thenRun(() -> System.out.println("进程退出"));
    }

    public static void stopProcess(long pid) throws NoSuchProviderException {
        ProcessHandle process = ProcessHandle.of(pid)
                .orElseThrow(NoSuchProviderException::new);
        process.destroyForcibly();
        System.out.println("进程已终止");
    }

    public static void getChildProcess(long pid) throws NoSuchProviderException {
        ProcessHandle process = ProcessHandle.of(pid)
                .orElseThrow(NoSuchProviderException::new);
        Optional<ProcessHandle> parent = process.parent();
        System.out.println("父进程的PID: " + parent.
                orElseThrow(NoSuchProviderException::new).pid());
        System.out.println(parent.get().info());
        Stream<ProcessHandle> children = process.children();
        children.forEach(child -> System.out.println("子进程的PID: " + child.pid()));
    }
}
