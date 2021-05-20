package com.homework.system.model;

import javax.servlet.http.HttpServletResponse;

public interface Content<T> {
    void writeContent(HttpServletResponse response);
}
