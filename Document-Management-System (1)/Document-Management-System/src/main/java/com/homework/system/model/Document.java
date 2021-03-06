package com.homework.system.model;

public class Document {

    private final String name;

    private final Content content;

    private final long creationTime;

    public Document(String name, Content content) {
        this.name = name;
        this.content = content;
        this.creationTime = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public Content getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        return name.equals(document.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", creationTime=" + creationTime +
                ", content=" + content +
                '}';
    }
}
