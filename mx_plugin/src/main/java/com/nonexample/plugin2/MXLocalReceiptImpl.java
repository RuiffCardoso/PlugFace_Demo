package com.nonexample.plugin2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import com.example.document_sample.locale_interfaces.LocalReceipt;
import com.example.document_sample.models.Receipt;

import org.plugface.core.annotations.Plugin;

@Plugin(name = "mx_receipt")
public class MXLocalReceiptImpl implements LocalReceipt {
    private static final Logger logger = LoggerFactory.getLogger(MXLocalReceiptImpl.class);

    @Override
    public void updateReceipt(Receipt receipt) {
        logger.info("Updating receipt. Initial object: {}", receipt);
        receipt.setLastModified(new Date());
        logger.info("Receipt updated. Object: {}", receipt);
    }

}