package com.nonexample.plugin2;
import java.util.Date;

import org.plugface.core.annotations.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.document_sample.locale_interfaces.LocalDocument;
import com.example.document_sample.models.Document;


@Plugin(name = "mx_document")
public class MXLocalDocumentImpl implements LocalDocument {
	private static final Logger logger = LoggerFactory.getLogger(MXLocalDocumentImpl.class);
	
	@Override
	public void updateDocument(Document document) {
		logger.info("Updating document. Initial: " + document);
		document.setLastModified(new Date());
		logger.info("Result document: " + document);
	}

}