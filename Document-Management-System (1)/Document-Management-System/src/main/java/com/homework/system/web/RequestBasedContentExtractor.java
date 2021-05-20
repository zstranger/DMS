package com.homework.system.web;

import com.homework.system.exceptions.MediaTypeNotSupportedException;
import com.homework.system.model.BinaryContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.homework.system.model.StringContent;
import com.homework.system.model.Content;

import javax.servlet.http.HttpServletRequest;

public class RequestBasedContentExtractor implements ContentExtractor {

    private final static Logger classLogger = LoggerFactory.getLogger(RequestBasedContentExtractor.class);

    public Content extract(HttpServletRequest requestInfo) {
        SupportedMediaTypes detected = SupportedMediaTypes.detectMediaType(requestInfo);
        logMediaTypeDetection(detected, requestInfo);

        if (SupportedMediaTypes.BINARY == detected) {
            return new BinaryContent(requestInfo);
        } else if (SupportedMediaTypes.TEXT == detected) {
            return new StringContent(requestInfo);
        }
        throw new MediaTypeNotSupportedException(detected);
    }

    private void logMediaTypeDetection(SupportedMediaTypes detected, HttpServletRequest requestInfo) {
        if (classLogger.isDebugEnabled()) {
            classLogger.debug("For request " + requestInfo + ", creating content type of type " + detected);
        }
    }
}
