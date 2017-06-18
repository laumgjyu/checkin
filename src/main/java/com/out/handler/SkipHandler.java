package com.out.handler;

import com.jfinal.handler.Handler;
import com.jfinal.kit.HandlerKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lmy on 2017/6/18.
 */
public class SkipHandler extends Handler {

    public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, boolean[] booleans) {
        if (s.endsWith(".html")) {

            HandlerKit.renderError404(httpServletRequest, httpServletResponse, booleans);

        } else {

            next.handle(s, httpServletRequest, httpServletResponse, booleans);

        }
    }
}