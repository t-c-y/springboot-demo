package com.tcy.jsoup;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashSet;
import java.util.Set;

public class WebScraper {
    public static void main(String[] args) {
        getText();
    }

    private static void getText() {
        try {
            // 目标网页URL
            String url = "https://www.ssydt.com/article/68931";
            // 使用Jsoup连接到网页
            Document doc = Jsoup.connect(url).get();
            // 使用选择器提取你想要的内容，例如页面的标题
            String title = doc.title();
            System.out.println("Title: " + title);
            // 打印整个网页内容，用于调试
            System.out.println(doc.body().text());
            String html = doc.body().html();
            System.out.println("1:" + html);
            html = html.substring(html.indexOf("国内新闻"));
            html = html.substring(0, html.indexOf("</div> <button type=\"button\" class=\"el-button article-test-btn el-button--default is-round\" data-v-049854d5><!----><!----><span>开始本月时政试题测评</span></button>"));

            System.out.println("2:" + html);
            html = html.replaceAll("<p class=\"MsoNormal\"><br></p>", "");
            html = html.replaceAll("<p class=\"MsoNormal\"><img src=\"http://img.huashitong.net/2023/02/27/1677485245853eh8qA.jpg\" style=\"max-width:100%;\"><br></p>", "");
            html = html.replaceAll("<h2>&nbsp;<!--\\[endif\\]--><b>", "");
            html = html.replaceAll("</b><b></b></h2>", "");
            html = html.replaceAll("<p class=\"MsoNormal\"><!--\\[if !supportLists\\]-->", "");
            html = html.replaceAll("<p class=\"MsoNormalIndent\"><!--\\[if !supportLists\\]-->", "");
            html = html.replaceAll("&nbsp;<!--\\[endif\\]-->", "");
            html = html.replaceAll("<!--\\[endif\\]-->", "");
            html = html.replaceAll("<span style=\"color: inherit;\">", "");
            html = html.replaceAll("</span>", "");
            html = html.replaceAll("</span><span style=\"color: inherit;\">．</span><span style=\"color: inherit;\">", "");
            html = html.replaceAll("</p>", "");
            html = html.replaceAll("<p class=\"MsoNormal\">", "");
            html = html.replaceAll("<p class=\"MsoNormalIndent\">", "");
            html = html.replaceAll("<p class=\"16\"><!--\\[if !supportLists\\]-->", "");
            html = html.replaceAll("<p class=\"MsoNormal\">&nbsp;</p>", "");
            html = html.replaceAll("<p class=\"MsoNormal\">&nbsp;<b><u></u></b></p>", "");
            html = html.replaceAll("<b><u>&nbsp;</u></b>", "");
            html = html.replaceAll("<b><u></u></b>", "");
            html = html.replaceAll("&nbsp;", "");
            html = html.replaceAll("&nbsp;<b><u></u></b>", "");
            html = html.replaceAll("<span style=\"color: inherit; font-family: inherit; font-size: 24px;\">&nbsp;</span><b style=\"color: inherit; font-family: inherit; font-size: 24px;\">", "");
            html = html.replaceAll("<span style=\"color: inherit; font-family: inherit; font-size: 24px;\"><b style=\"color: inherit; font-family: inherit; font-size: 24px;\">", "");
            html = html.replaceAll("<h2><b></b></h2>", "");
            html = html.replaceAll(" style=\"color: inherit;\"", "");
            html = html.replaceAll("<p class=\"MsoNormal\" align=\"justify\"><b>&nbsp;</b></p>", "");
            html = html.replaceAll("<p class=\"MsoNormal\" align=\"justify\"><b></b></p>", "");
            html = html.replaceAll("<p class=\"MsoNormal\" align=\"justify\"><b> </b></p>", "");
            html = html.replaceAll("<p class=\"MsoNormal\"><b>&nbsp;</b></p>", "");
            html = html.replaceAll("<p class=\"MsoNormal\">&nbsp;</p>", "");
            html = html.replaceAll("<p class=\"MsoNormal\"></p>", "");
            html = html.replaceAll("<p class=\"MsoNormal\"> </p>", "");
            html = html.replaceAll("<p class=\"MsoNormal\" align=\"justify\"><b>&nbsp;</b></p>", "");
            html = html.replaceAll("<h2><!--\\[if !supportLists\\]-->二、&nbsp;<!--\\[endif\\]--><b>", "");
            html = html.replaceAll("<p>", "");
            html = html.replaceAll("<b><u>", "<u><font class=\"text-color-11\" color=\"#8bc34a\">");
            html = html.replaceAll("</u></b>", "</font></u>");
            html = html.replaceAll("<b>", "<u><font class=\"text-color-11\" color=\"#8bc34a\">");
            html = html.replaceAll("</b>", "</font></u>");
            html = html.replaceAll("\n", "\n\n");
            System.out.println("3:" + html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getCssHtml() {
        try {
            // 创建HttpClient实例
            CloseableHttpClient httpClient = HttpClients.createDefault();
            // 设置要抓取的网页URL
            String url = "https://www.ssydt.com/article/68081";
            // 创建HttpGet请求
            HttpGet httpGet = new HttpGet(url);
            // 执行请求并接收响应
            CloseableHttpResponse response = httpClient.execute(httpGet);
            // 从响应中提取HTML内容
            String htmlContent = EntityUtils.toString(response.getEntity());
            // 使用Jsoup解析HTML内容
            Document doc = Jsoup.parse(htmlContent);
            // 输出完整的HTML内容（包括样式）
            System.out.println(doc.outerHtml());
            // 关闭HttpClient
            response.close();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}