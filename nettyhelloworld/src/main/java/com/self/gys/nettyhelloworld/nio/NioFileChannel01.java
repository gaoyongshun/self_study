package com.self.gys.nettyhelloworld.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NioFileChannel01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str="hello world!";
		
		FileInputStream fileInputStream = new FileInputStream("D://1.txt");
		
		FileChannel fileChannel = fileInputStream.getChannel();
		
		ByteBuffer byteBuffer =ByteBuffer.allocate(1024);
		
		fileChannel.read(byteBuffer);
		
		System.out.println(new String(byteBuffer.array()).toString());
	}

}
