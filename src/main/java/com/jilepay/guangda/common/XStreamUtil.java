package com.jilepay.guangda.common;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XStreamUtil {

	private static String PREFIX_CDATA = "<![CDATA[";  
	private static String SUFFIX_CDATA = "]]>";  

	/**
	 * 1.解决XStream对出现双下划线的bug
	 * 2.所有的字符串都加上CDATA标识
	 * @return
	 */
	public static XStream initXStream() {  
		return new XStream(new XppDriver(new NoNameCoder()) {

            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    // 对所有xml节点的转换都增加CDATA标记
                    boolean cdata = true;

                    @Override
                    @SuppressWarnings("rawtypes")
                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    @Override
                    public String encodeNode(String name) {
                        return name;
                    }


                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write(PREFIX_CDATA);
                            writer.write(text);
                            writer.write(SUFFIX_CDATA);
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        });
	}  
}
