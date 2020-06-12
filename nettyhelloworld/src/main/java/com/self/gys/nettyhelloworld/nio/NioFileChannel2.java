package com.self.gys.nettyhelloworld.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NioFileChannel2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str="hello world!";
		
		FileOutputStream fileOutputStream = new FileOutputStream("d://1.txt");
		
		FileChannel fileChannel = fileOutputStream.getChannel();
	
		ByteBuffer byteBuffer =ByteBuffer.allocate(1024);
		
		byteBuffer.put(str.getBytes());
		
		byteBuffer.flip();
		
		fileChannel.write(byteBuffer);
	}

}
