package com.jie.helloservice.common.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 从request中组装请求信息
     * 返回组装后的请求信息,例如
     * name1=value1&name2=value2,value3
     *
     * @param request 请求
     * @return 请求详情
     */
    public static String composeRequestParams(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String[]>> params = request.getParameterMap().entrySet();
        for (Map.Entry<String, String[]> entry : params) {
            sb.append(entry.getKey());
            sb.append("=");
            for (String value : entry.getValue()) {
                sb.append(value);
                sb.append(",");
            }
            if (sb.lastIndexOf(",") == sb.length() - 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("&");
        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 尝试获取用户ip
     * 首相尝试在header中查找X-Real-IP
     * 如果未找到则以原始方式获取remoteAddr
     * 如果仍未找到则返回unknown
     *
     * @param request 请求
     * @return ip地址, 可能为unknown
     */
    public static String tryGetRemoteAddress(HttpServletRequest request) {
        String addr;
        // try get ip from nginx
        addr = request.getHeader("X-Forwarded-For");
        if (addr == null) {
            // try get ip in normal case
            addr = request.getRemoteAddr();
        }
        if (addr == null) {
            addr = "unknown";
        }
        if (addr.indexOf(",") != -1) {
            addr = addr.split(",")[0];
        }
        return addr;
    }

    public static byte[] downloadFromUrl(String url, String proxyHost, int proxyPort) throws IOException {
        int byteRead;
        InputStream inStream = null;
        try {
            URL target = new URL(url);
            Proxy proxy = null;
            if (proxyHost != null) {
                proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            }
            URLConnection conn;
            if (proxy == null) {
                conn = target.openConnection();
            } else {
                conn = target.openConnection(proxy);
            }
            inStream = conn.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            while ((byteRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, byteRead);
            }
            return outStream.toByteArray();
        } finally {
            if (inStream != null) {
                inStream.close();
            }
        }
    }

    public static byte[] downloadFromUrl(String url) throws IOException {
        return downloadFromUrl(url, null, -1);
    }

    public static String requestUseGet(String url, String data, String proxyHost, int proxyPort) throws RequestException {
        return request(url, "GET", data, null, proxyHost, proxyPort);
    }

    public static String requestUsePost(String url, String data, String proxyHost, int proxyPort) throws RequestException {
        return request(url, "POST", data, null, proxyHost, proxyPort);
    }

    public static String requestUseGet(String url, String data) throws RequestException {
        return request(url, "GET", data, null, null, 0);
    }

    public static String requestUsePost(String url, String data) throws RequestException {
        return request(url, "POST", data, null, null, 0);
    }

    public static String request(String url, String method, String data) throws RequestException {
        return request(url, method, data, null, null, 0);
    }

    public static String request(String url, String method,
                                 String data, String ctype,
                                 String proxyHost, int proxyPort) throws RequestException {
        Map<String, String> properties = null;
        if (!StringUtils.isEmpty(ctype)) {
            properties = new HashMap<>();
            properties.put("Content-Type", ctype);
        }
        return doRequest(url, method, data, properties, proxyHost, proxyPort);
    }

    public static String doRequest(String url, String method, String data, Map<String, String> properties,
                                   String proxyHost, int proxyPort) throws RequestException {

        long startTime = System.currentTimeMillis();

        HttpURLConnection conn = null;
        OutputStream out = null;
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {

            Proxy proxy = null;
            //是否使用代理
            if (!StringUtils.isEmpty(proxyHost) && proxyPort > 0) {
                // proxy
                proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            }
            conn = getConn(url, proxy);

            if (properties != null) {
                for (Map.Entry<String, String> entry : properties.entrySet()) {
                    conn.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(method);

            //设置请求属性
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0; WindowsNT 6.1; WOW64; Trident/6.0; QQBrowser/7.7.24962.400)");

            if ("GET".equalsIgnoreCase(method))
                conn.connect();

            // 当有数据需要提交时
            if (null != data) {
                out = conn.getOutputStream();
                // 注意编码格式，防止中文乱码
                out.write(data.getBytes("UTF-8"));
                out.flush();
            }

            // 将返回的输入流转换成字符串
            InputStream in = conn.getInputStream();
            String charset = getResponseCharset(conn.getContentType());
//            InputStreamReader inputStreamReader = new InputStreamReader(in, "utf-8");
//            reader = new BufferedReader(inputStreamReader);
//            String str;
//            while ((str = reader.readLine()) != null) {
//                sb.append(str);
//            }
            String responseStr = getStreamAsString(in, charset);
            sb.append(responseStr);
        } catch (Exception e) {
            logger.error("请求失败,url:{}, method:{}, data:{}", url, method, data, e);
            throw new RequestException(e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (out != null)
                    out.close();
                if (conn != null)
                    conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (logger.isTraceEnabled()) {
            logger.trace("微信请求发送成功, 耗时:{}ms, url:{}, method:{}, data:{}, response:{}",
                    System.currentTimeMillis() - startTime,
                    url, method, data, sb);
        }
        return sb.toString();
    }

    public static void downImage(String url, String fileName, String method, String data, Map<String, String> properties,
                                 String proxyHost, int proxyPort) throws RequestException {
        HttpURLConnection conn = null;
        OutputStream out = null;
        BufferedReader reader = null;
        try {

            Proxy proxy = null;
            //是否使用代理
            if (!StringUtils.isEmpty(proxyHost) && proxyPort > 0) {
                // proxy
                proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            }
            conn = getConn(url, proxy);

            if (properties != null) {
                for (Map.Entry<String, String> entry : properties.entrySet()) {
                    conn.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(method);

            //设置请求属性
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0; WindowsNT 6.1; WOW64; Trident/6.0; QQBrowser/7.7.24962.400)");

            if ("GET".equalsIgnoreCase(method))
                conn.connect();

            // 当有数据需要提交时
            if (null != data) {
                out = conn.getOutputStream();
                // 注意编码格式，防止中文乱码
                out.write(data.getBytes("UTF-8"));
                out.flush();
            }

            InputStream in = conn.getInputStream();

            //将图片保存到本地目录
            FileOutputStream fo = new FileOutputStream(fileName);     // new File(imageName)相对绝对路径
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = in.read(buf, 0, buf.length)) != -1) {
                fo.write(buf, 0, length);
            }
            fo.close();
        } catch (Exception e) {
            logger.error("请求失败,url:{}, method:{}, data:{}", url, method, data, e);
            throw new RequestException(e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (out != null)
                    out.close();
                if (conn != null)
                    conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static SSLSocketFactory getSSF() {
        SSLSocketFactory ssf = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            ssf = sslContext.getSocketFactory();
        } catch (Exception e) {
            logger.error("创建SSLSocketFactory异常, message:{}", e.getMessage(), e);
        }
        return ssf;
    }

    private static HttpURLConnection getConn(String url, Proxy proxy) {
        try {
            URL target = new URL(url);
            if (url.startsWith("https")) {
                HttpsURLConnection conn;
                if (proxy != null) {
                    conn = (HttpsURLConnection) target.openConnection(proxy);
                    conn.setSSLSocketFactory(getSSF());
                } else {
                    conn = (HttpsURLConnection) target.openConnection();
                }
                return conn;
            } else {
                HttpURLConnection conn;
                if (proxy != null) {
                    conn = (HttpURLConnection) target.openConnection(proxy);
                } else {
                    conn = (HttpURLConnection) target.openConnection();
                }
                return conn;
            }
        } catch (IOException e) {
            logger.error("创建HttpURLConnection异常, message:{}", e.getMessage(), e);
        }
        return null;
    }

    private static String getResponseCharset(String ctype) {
        String charset = "UTF-8";
        if (!StringUtils.isEmpty(ctype)) {
            String[] params = ctype.split(";");

            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2 && !StringUtils.isEmpty(pair[1])) {
                        charset = pair[1].trim();
                    }
                    break;
                }
            }
        }

        return charset;
    }

    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
            StringWriter writer = new StringWriter();
            char[] chars = new char[256];

            int count1;
            while ((count1 = reader.read(chars)) > 0) {
                writer.write(chars, 0, count1);
            }

            return writer.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }

        }
    }


}
