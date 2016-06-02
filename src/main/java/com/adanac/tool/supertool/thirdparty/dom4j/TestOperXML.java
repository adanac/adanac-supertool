package com.adanac.tool.supertool.thirdparty.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class TestOperXML {

	@Test
	public void testOfReader() {
		String fileName = "res/tb_user1.xml";
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File(fileName));
			Element root = doc.getRootElement();
			Element content = root.element("XMI.content");
			println(content.getName());
			Element catalog = content.element("Catalog");
			println(catalog.getName());
			Namespace np = catalog.getNamespace();
			println(catalog.getNamespace().getPrefix());
			println("xmi.id:" + catalog.attribute("xmi.id").getText());
			println("name:" + catalog.attribute("name").getText());
			println("visibility:" + catalog.attribute("visibility").getText());

		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOfWriter() {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("XMI");
		root.addNamespace("CWM", "org.omg.CWM1.0").addNamespace("CWMRDB", "org.omg.CWM1.0/Relational")
				.addNamespace("CWMOLAP", "org.omg.CWM1.0/OLAP").addNamespace("CWMTFM", "org.omg.CWM1.0/Transformation")
				.addAttribute("xmi.version", "1.1").addAttribute("timestamp", "5月 23 2016 13:10:03");
		Element xmlHeader = root.addElement("XMI.header");
		Element documentation = xmlHeader.addElement("XMI.documentation");
		documentation.addElement("XMI.exporter").setText("Meta Integration Model Bridge");
		documentation.addElement("XMI.exporterVersion").setText("6.0.3 - Jan 28 2009 18:35:56");
		xmlHeader.addElement("metamodel").addAttribute("xmi.name", "CWM").addAttribute("xmi.version", "1.0");
		Element content = root.addElement("XMI.content");
		Element catalog = content.addElement("CWMRDB:Catalog").addAttribute("xmi.id", "_4")
				.addAttribute("name", "Model_1").addAttribute("visibility", "public");
		catalog.addNamespace("CWMRDB", "org.omg.CWM1.0/Relational");
		Element schema = catalog.addElement("CWM:Namespace.ownedElement").addNamespace("CWM", "org.omg.CWM1.0")
				.addElement("Schema");
		schema.addNamespace("CWMRDB", "org.omg.CWM1.0/Relational");
		schema.addElement("CWM:Namespace.ownedElement").addNamespace("CWM", "org.omg.CWM1.0");

		try {
			XMLWriter writer = new XMLWriter(new FileWriter("out.xml"));
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOfXPath() {
		String fileName = "res/tb_user1.xml";
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File(fileName));
			List list = doc.selectNodes("//XMI/XMI.content/CWMRDB:Catalog");
			for (Object o : list) {
				Element ele = (Element) o;
				println(ele.getName());
				List list1 = ele.selectNodes("//CWMRDB:Catalog");
				println(list1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void println(Object o) {
		if (o == null) {
			System.out.println(":>> null ");
		} else {
			System.out.println(":>> " + o.toString());
		}
	}
}