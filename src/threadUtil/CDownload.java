package threadUtil;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 20:34
 * @Description: 线程工具包
 */
public class CDownload implements Callable<Boolean> {
    //远程路径
    private String url;
    //储存名字
    private String name;

    //    public TDownload() {
//        System.out.println("调用了无参构造方法");
//    }
    public CDownload(String url, String name) {
        this.url = url;
        this.name = name;
    }

    /**
     * @param url
     * @param name
     * @author: 王志恒
     * @date: 2019/7/30 20:32
     * @return:
     * @Description： 图片下载工具
     */
    public static void download(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("URL异常");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片下载失败");
        }
    }

    @Override
    public Boolean call() throws Exception {
        CDownload.download(url, name);
        return true;
    }

    //"resource/picture"
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String url1 = "file:///C:/Users/86130/OneDrive/%E6%A1%8C%E9%9D%A2/%E7%BA%BF%E7%A8%8B%E6%89%A7%E8%A1%8C%E9%A1%BA%E5%BA%8F%E5%9B%BE.png";
        String url2 = "file:///C:/Users/86130/OneDrive/%E6%A1%8C%E9%9D%A2/%E7%BA%BF%E7%A8%8B%E7%8A%B6%E6%80%81%E5%9B%BE1.png";
        String url3 = "file:///C:/Users/86130/OneDrive/%E6%A1%8C%E9%9D%A2/status2.png";

        CDownload cd1 = new CDownload(url1, "resource/zhuangtai1.png");
        CDownload cd2 = new CDownload(url2, "resource/zhuangtai2.png");
        CDownload cd3 = new CDownload(url3, "resource/zhuangtai3.png");

        //1、创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> result1 = ser.submit(cd1);
        Future<Boolean> result2 = ser.submit(cd2);
        Future<Boolean> result3 = ser.submit(cd3);
        //获取结果
            boolean r1 = result1.get();
            boolean r2 = result2.get();
            boolean r3 = result3.get();
        System.out.println(r3);
            System.out.println();
        //释放资源，关闭服务
        ser.shutdownNow();

    }

}