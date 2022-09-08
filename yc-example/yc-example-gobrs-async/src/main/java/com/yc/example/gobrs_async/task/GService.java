package com.yc.example.gobrs_async.task;

import com.gobrs.async.TaskSupport;
import com.gobrs.async.anno.Task;
import com.gobrs.async.task.AsyncTask;
import org.springframework.stereotype.Component;
/**
 * @description:
 * @author: youcong
 */
@Component
@Task(callback = true)
public class GService extends AsyncTask<Object, Object>  {
    /**
     * The .
     */
    int i  = 10000;
    @Override
    public void prepare(Object o) {

    }

    @Override
    public Object task(Object o, TaskSupport support) {
        try {
            System.out.println("GService Begin");
            Thread.sleep(100);
            System.out.println("GService Finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i1 = 0; i1 < i; i1++) {
            i1 += i1;
        }

        return null;
    }

    @Override
    public boolean nessary(Object o, TaskSupport support) {
        return true;
    }

    @Override
    public void onSuccess(TaskSupport support) {

    }

    @Override
    public void onFail(TaskSupport support) {

    }
}
