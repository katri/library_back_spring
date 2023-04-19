package com.example.library_back_spring;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;

import java.io.IOException;
import java.io.StringWriter;

public class HTMLTemplateRenderer {

    public String toHtml(Object viewModel, String template) throws IOException {
        Mustache mustache = new DefaultMustacheFactory().compile(template);
        StringWriter writer = new StringWriter();
        mustache.execute(writer, viewModel).flush();
        return writer.toString();
    }
}
