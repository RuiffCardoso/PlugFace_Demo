package com.example.document_sample.implementations;

import java.util.Date;

import com.example.document_sample.locale_interfaces.LocalDocument;
import com.example.document_sample.models.Document;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PTLocalDocumentImpl implements LocalDocument {
    private static final Logger logger = LoggerFactory.getLogger(PTLocalDocumentImpl.class);

    @Override
    public void updateDocument(Document document) {
        logger.info("Received document: " + document);
        document.setName(RandomStringUtils.randomAlphabetic(15));
        document.setLastModified(new Date());
        logger.info("Delivered document: " + document);
    }

}