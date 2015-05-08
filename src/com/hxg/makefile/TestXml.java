package com.hxg.makefile;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.hxg.makefile.entity.ParamsEntity;

public class TestXml {

	public static void main(String[] args) {

		List<ParamsEntity> list = Test.test();

		Document doc = BuildXmlDoc(list);
		try {
			outputXml(doc, "D:/test.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static Document BuildXmlDoc(List<ParamsEntity> list) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element root = doc.createElement("apis");
			doc.appendChild(root);

			for (int i = 0; i < list.size(); i++) {
				Element api = doc.createElement("api");
				// api.setAttribute("url", list.get(i).getUrl());
				// api.setAttribute("method", list.get(i).getMethod());
				// api.setAttribute("params", list.get(i).getParams());
				Element url = doc.createElement("url");
				url.setTextContent(list.get(i).getUrl());
				api.appendChild(url);
				Element method = doc.createElement("method");
				method.setTextContent(list.get(i).getMethod());
				api.appendChild(method);
				Element params = doc.createElement("params");
				params.setTextContent(list.get(i).getParams());
				api.appendChild(params);
				root.appendChild(api);
			}
			return doc;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static void outputXml(Document doc, String fileName)
			throws Exception {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(doc);
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");// 设置文档的换行与缩进
		PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
		StreamResult result = new StreamResult(pw);
		transformer.transform(source, result);
		System.out.println("生成XML文件成功!");
	}
}
