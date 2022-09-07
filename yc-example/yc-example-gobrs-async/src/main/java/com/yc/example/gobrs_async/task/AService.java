package com.yc.example.gobrs_async.task;

import com.gobrs.async.TaskSupport;
import com.gobrs.async.anno.Task;
import com.gobrs.async.task.AsyncTask;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: youcong
 */
@Task(failSubExec = true)
@Component
public class AService extends AsyncTask<String, String> {

    /**
     * The .
     */
    int i = 10000;

    @Override
    public void prepare(String o) {


    }

    @Override
    public String task(String o, TaskSupport support) {
        System.out.println(o);

        try {
            System.out.println("AService Begin");
            Thread.sleep(300);
            for (int i1 = 0; i1 < i; i1++) {
                i1 += i1;
            }
            System.out.println("AService Finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "result";
    }

    @Override
    public boolean nessary(String o, TaskSupport support) {
        return true;
    }


    @Override
    public void onSuccess(TaskSupport support) {

    }

    @Override
    public void onFail(TaskSupport support) {

    }
}