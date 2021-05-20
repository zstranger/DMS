package com.homework.system.repository;

import com.homework.system.model.Content;
import com.homework.system.model.Document;

public interface Repository<T extends Document> {

    boolean exists(T item);

    T create(Content content);

    Document delete(T item);

    void update(T item);

    boolean exists(String documentName);

    T read(String documentName);

    Document delete(String documentName);
}
