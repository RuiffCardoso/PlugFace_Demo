package com.example.document_sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import com.example.document_sample.locale_interfaces.LocalDocument;
import com.example.document_sample.locale_interfaces.LocalReceipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@DependsOn("pluginLoader")
public class LocalImplementationsHandler {
    private static final Logger logger = LoggerFactory.getLogger(LocalImplementationsHandler.class);

    private final List<LocalDocument> documentsHandler;
    private final List<LocalReceipt> receiptsHandler;

    @Autowired
    public LocalImplementationsHandler(List<LocalDocument> documentsHandler, List<LocalReceipt> receiptsHandler) {
        this.documentsHandler = documentsHandler;
        this.receiptsHandler = receiptsHandler;
    }

    public void printHandlers() {
        logger.info("DOCUMENT: Number of handlers: {}. Handlers name: [{}]", documentsHandler.size(),
                StringUtils.collectionToCommaDelimitedString(
                        documentsHandler.stream().map(h -> h.getClass().getSimpleName()).collect(Collectors.toList())));

        logger.info("RECEIPT: Number of handlers: {}. Handlers name: [{}]", receiptsHandler.size(),
                StringUtils.collectionToCommaDelimitedString(
                        receiptsHandler.stream().map(h -> h.getClass().getSimpleName()).collect(Collectors.toList())));
    }

}