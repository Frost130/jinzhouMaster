package com.cp.webutils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class SessionUtils
{
    /**
     * Ajax向前台返回数据方法
     * @param str
     */
    public static void output(String str, String charsetName,
        HttpServletResponse response)
    {
        response.setContentType("text/html");
        response.setCharacterEncoding(charsetName);
        // 获取URLConnection对象对应的输出流
        OutputStreamWriter outWriter;
        try
        {
            outWriter = new OutputStreamWriter(response.getOutputStream(),
                charsetName);
            try
            {
                // 发送请求参数
                outWriter.write(str);
                outWriter.flush();
            }
            finally
            {
                outWriter.close();
            }
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static void output(String str, HttpServletResponse response)
    {
        output(str, "utf-8", response);
    }


    public static void output(Object obj, HttpServletResponse response)
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        out.print(obj);

        out.flush();
        out.close();
    }


    /**
     * Action中往session中存储方法
     * @param key
     * @param value
     */
    public static void sessionSetAttribute(String key, Object value,
        HttpSession session)
    {
        session.setAttribute(key, value);
    }

    /**
     * Action中从session中获取数据方法
     * @param key
     * @return 返回获取到的value值
     */
    public static Object sessionGetAttribute(String key, HttpSession session)
    {
        // 从session中获取存储的value值
        Object obj = session.getAttribute(key);

        return obj;
    }

    /**
     * Action中移除指定key值session
     * @param key
     */
    public static void sessionRemove(String key, HttpSession session)
    {
        session.removeAttribute(key);
    }

    /**
     * 设置session最大生命
     * @param time 设置的最大生命数,单位秒
     */
    public static void sessionSetMaxInactiveInterval(int time,
        HttpSession session)
    {
        session.setMaxInactiveInterval(time);
    }

    public static String getVistorIp(HttpServletRequest request)
    {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * 读取除内容外的所有请求信息
     * @param request
     * @return
     */
    public static List<String> getRequestInfo(HttpServletRequest request)
    {

        
        List<String> result = new ArrayList<String>();
        result.add("获取到的客户机信息如下：");
        result.add("请求的URL地址：" + request.getRequestURL().toString());
        result.add("请求的资源：" + request.getRequestURI());
        result.add("请求的URL地址中附带的参数：" + request.getQueryString());
        result.add("来访者的IP地址：" + request.getRemoteAddr());
        result.add("来访者的主机名：" + request.getRemoteHost());
        result.add("使用的端口号：" + request.getRemotePort());
        result.add("remoteUser：" + request.getRemoteUser());
        result.add("请求使用的方法：" + request.getMethod());
        result.add("pathInfo：" + request.getPathInfo());
        result.add("Headers:");
        Enumeration<String> headerNames = request.getHeaderNames();
        for (; headerNames.hasMoreElements();)
        {
            String headerName = headerNames.nextElement();
            result.add(headerName + "=" + request.getHeader(headerName) + ";");
        }
        result.add("cookies:");
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0)
        {
            for (Cookie cookie : cookies)
            {
                result.add(cookie.getName() + "=" + cookie.getValue() + ";");
            }
        }
        result.add("Attributes:");
        Enumeration<String> attribNames = request.getAttributeNames();
        for (; attribNames.hasMoreElements();)
        {
            String attribName = attribNames.nextElement();
            result.add(attribName + "=" + request.getAttribute(attribName)
                + ";");

        }

        result.add("Parameters:");
        Enumeration<String> paramNames = request.getParameterNames();
        for (; paramNames.hasMoreElements();)
        {
            String paramName = paramNames.nextElement();
            result.add(paramName + "=" + request.getParameter(paramName) + ";");
        }
        return result;
    }

    public static String getRequestContent(HttpServletRequest request)
    {
        InputStreamReader isr;
        StringBuilder builder = new StringBuilder(5000);
        try
        {
            isr = new InputStreamReader(request.getInputStream(),
                request.getCharacterEncoding());
            BufferedReader in = new BufferedReader(isr);
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                if (inputLine.length() != 0)
                {
                    builder.append(inputLine);
                }
            }
            in.close();
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return builder.toString();
    }
    
    public static void printRequestInfo(String caller,
        HttpServletRequest request)
    {
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss")
            .format(new Date()) + "  " + caller);
        System.out.println(getRequestInfo(request));
        System.out.println("content:");
        System.out.println(getRequestContent(request));
    }

    public static Cookie getCookie(HttpServletRequest request, String cookieName)
    {
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0 && cookieName != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookieName.equalsIgnoreCase(cookie.getName()))
                {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static String getCookieValue(HttpServletRequest request,
        String cookieName)
    {
        Cookie cookie = getCookie(request, cookieName);
        if (cookie != null)
            return cookie.getValue();
        return null;

    }

    /**
     * 
     * 设置cookie
     * 
     * @param response
     * 
     * @param name cookie名字
     * 
     * @param value cookie值
     * 
     * @param maxAge cookie生命周期 以秒为单位
     */

    public static void addCookie(HttpServletResponse response, String name,
        String value, int maxAge)
    {

        Cookie cookie = new Cookie(name, value);

        cookie.setDomain("www.dzty365.com");
        cookie.setPath("/");

        if (maxAge > 0)
            cookie.setMaxAge(maxAge);

        response.addCookie(cookie);

    }
}
