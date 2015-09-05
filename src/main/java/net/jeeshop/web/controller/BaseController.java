/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package net.jeeshop.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller - 基类
 * 
 */
@Controller
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected void addMessage(ModelMap modelMap, String message) {
        modelMap.addAttribute("message", message);
    }
    protected void addWarning(ModelMap modelMap, String warning) {
        modelMap.addAttribute("warning", warning);
    }
    protected void addError(ModelMap modelMap, String warning) {
        modelMap.addAttribute("errorMsg", warning);
    }
    protected void addMessage(RedirectAttributes flushAttrs, String message) {
        flushAttrs.addFlashAttribute("message", message);
    }
    protected void addWarning(RedirectAttributes flushAttrs, String warning) {
        flushAttrs.addFlashAttribute("warning", warning);
    }
    protected void addError(RedirectAttributes flushAttrs, String warning) {
        flushAttrs.addFlashAttribute("errorMsg", warning);
    }

}