package com.homework.system.web;

import com.homework.system.model.Content;

import javax.servlet.http.HttpServletRequest;

public interface ContentExtractor {

    Content extract(HttpServletRequest requestInfo);
}
