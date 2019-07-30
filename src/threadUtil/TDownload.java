package threadUtil;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 20:34
 * @Description:
 * 线程工具包
 */
public class TDownload extends Thread{
    private String url; //远程路径
    private String name; //储存名字

//    public TDownload() {
//        System.out.println("调用了无参构造方法");
//    }
    public TDownload(String url, String name) {
        this.url = url;
        this.name = name;
    }

    /**
     * @author: 王志恒
     * @date: 2019/7/30 20:32
     * @param url
     * @param name
     * @return:
     * @Description：
     * 图片下载工具
     */
    public static void download(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (MalformedURLException e){
            e.printStackTrace();
            System.out.println("URL异常");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片下载失败");
        }
    }

    @Override
    public void run() {
        TDownload.download(url,name);
    }

    //"resource/picture"
    public static void main(String[] args) {
        String url1 = "file:///C:/Users/86130/OneDrive/%E6%A1%8C%E9%9D%A2/%E7%BA%BF%E7%A8%8B%E6%89%A7%E8%A1%8C%E9%A1%BA%E5%BA%8F%E5%9B%BE.png";
        String url2 = "file:///C:/Users/86130/OneDrive/%E6%A1%8C%E9%9D%A2/%E7%BA%BF%E7%A8%8B%E7%8A%B6%E6%80%81%E5%9B%BE1.png";
        String url3 = "file:///C:/Users/86130/OneDrive/%E6%A1%8C%E9%9D%A2/status2.png";

        TDownload td1 = new TDownload(url1,"resource/zhuangtai1.png");
        TDownload td2 = new TDownload(url2,"resource/zhuangtai2.png");
        TDownload td3 = new TDownload(url3,"resource/zhuangtai3.png");


        td1.start();
        td2.start();
        td3.start();

    }

}