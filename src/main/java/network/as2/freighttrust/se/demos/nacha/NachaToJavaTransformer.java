package com.mulesoft.se.demos.nacha;

import com.freighttrustachViewer.ach.ACHFile;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class NachaToJavaTransformer extends AbstractMessageTransformer {

  @Override
  public Object transformMessage(MuleMessage message, String outputEncoding)
      throws TransformerException {
    String contents = (String) message.getPayload();
    ACHFile file = new ACHFile();
    try {
      file.parseString(contents);
    } catch (Exception e) {

    }
    return file;
  }
}
