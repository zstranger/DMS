package com.homework.system.exceptions;

import com.homework.system.web.SupportedMediaTypes;

public class MediaTypeNotSupportedException extends RuntimeException {

    public MediaTypeNotSupportedException(SupportedMediaTypes mediaType) {
        super("Media type " + mediaType + " present, but no suitable BodyReader found");
    }

}
