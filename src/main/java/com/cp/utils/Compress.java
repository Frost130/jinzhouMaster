/**
 * 
 */
package com.cp.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**压缩、解压
 */
public class Compress {
	/**
	 * 压缩.
	 * 
	 * @param inputByte
	 *            需要解压缩的byte[]数组
	 * @return 压缩后的数据
	 * @throws IOException
	 */
	public static byte[] zip(byte[] data) throws IOException
	{
		int compressedDataLength = 0;
		Deflater compresser = new Deflater();
		compresser.setInput(data);
		compresser.finish();
		ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
		byte[] result = new byte[1024];
		try {
			while (!compresser.finished()) {
				compressedDataLength = compresser.deflate(result);
				o.write(result, 0, compressedDataLength);
			}
		} finally {
			o.close();
		}
		compresser.end();
		return o.toByteArray();
		
	}
	/**
	 * 解压缩.
	 * 
	 * @param inputByte
	 *            byte[]数组类型的数据
	 * @return 解压缩后的数据
	 * @throws IOException
	 */
	public static byte[] upzip(byte[] data) throws IOException
	{
		int compressedDataLength = 0;
		Inflater compresser = new Inflater(false);
		compresser.setInput(data, 0, data.length);
		ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
		byte[] result = new byte[1024];
		try {
			while (!compresser.finished()) {
				compressedDataLength = compresser.inflate(result);
				if (compressedDataLength == 0) {
					break;
				}
				o.write(result, 0, compressedDataLength);
			}
		} catch (Exception ex) {
			System.err.println("Data format error!\n");
			ex.printStackTrace();
		} finally {
			o.close();
		}
		compresser.end();
		return o.toByteArray();
		
	}

}
