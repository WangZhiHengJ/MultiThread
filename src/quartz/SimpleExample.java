//package quartz;
//
//
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerFactory;
//import org.quartz.Trigger;
//import org.quartz.impl.StdSchedulerFactory;
//
//import java.util.Date;
//
//import static org.quartz.DateBuilder.evenMinuteDate;
//import static org.quartz.JobBuilder.newJob;
//import static org.quartz.TriggerBuilder.newTrigger;
//
//
//public class SimpleExample {
//
//  public void run() throws Exception {
//
//    // 1、创建Scheduler的工厂
//    SchedulerFactory sf = new StdSchedulerFactory();
//    Scheduler sched = sf.getScheduler();
//
//
//    //2、创建时间
//    Date runTime = evenMinuteDate(new Date());
//
//
//    //3、创建JobDetail  创建任务：HelloJob
//    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
//
//    //4、出发条件
//    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
//
//    //5、注册任务和设置出发条件
//    sched.scheduleJob(job, trigger);
//
//    //6、启动调度
//    sched.start();
//    try {
//      //100秒后停止
//      Thread.sleep(100L * 1000L);
//      // executing...
//    } catch (Exception e) {
//    }
//    sched.shutdown(true);
//  }
//
//  public static void main(String[] args) throws Exception {
//
//    SimpleExample example = new SimpleExample();
//    example.run();
//
//  }
//
//}
