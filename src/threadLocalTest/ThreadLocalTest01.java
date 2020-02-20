package threadLocalTest;

import java.io.IOException;

/**
 * @Auther: wangzhiheng
 * @Date: 2020/1/13 11:47
 * TODO
 */
public class ThreadLocalTest01 {

    private static  User user = new User();

    private static final ThreadLocal<User> threadLocal = new ThreadLocal<User>(){
        protected User initialValue() {
            return user;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.get().setAge(threadLocal.get().getAge() + 5);

                    System.out.println(Thread.currentThread().getName() + "--:" + threadLocal.get().getAge());
                }
            }, "Thread-" + i);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}


class User {
    private Integer age=0;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}



//// 定义一个全局的Filter
////public class CommonFilter extends OncePerRequestFilter {
////
////    /**
////     * 拦截所有的http请求,需要配置过滤器
////     * @param request
////     * @param response
////     * @param filterChain
////     * @throws ServletException
////     * @throws IOException
////     */
////    @Override
////    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
////        try {
////            // 把requesu塞到线程的ThreadLocal中
////            RequestManager.setHttpServletRequest(request);
////            filterChain.doFilter(request, response);
////        } finally {
////            RequestManager.removeHttpServletRequest();
////        }
////    }
////}
////
////// http请求管理
////public class RequestManager {
////
////    private static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<HttpServletRequest>();
////    /**
////     * 当前线程加入request
////     * @param request
////     */
////    public static void setHttpServletRequest(HttpServletRequest request){
////        if(request != null){
////            threadLocal.set(request);
////        }
////    }
////
////    /**
////     * 当前线程获取request,在API接口中可以直接调用这个方法获取当前线程的request对象
////     */
////    public static HttpServletRequest getHttpServletRequest(){
////        return threadLocal.get();
////    }
////
////    /**
////     * 清理request，释放空间
////     */
////    public static void removeHttpServletRequest(){
////        threadLocal.remove();
////    }
////}
////
////
////// Test
////@RestController
////public class Demo {
////    @RequestMapping("/testDemo")
////    public void test(String s){
////        /**
////         * 通过这种方式就可以把请求取出来了,不用每次都在参数上加一个request了
////         */
////        HttpServletRequest request = RequestManager.getHttpServletRequest();
////    }
////}