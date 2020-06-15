package com.self.gys.nettyhelloworld.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NioFileChannel4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str="hello world!";
		FileInputStream fileInputStream = new FileInputStream("d://1.txt");
		FileOutputStream fileOutputStream = new FileOutputStream("d://2.txt");
		
		FileChannel inputChannel = fileInputStream.getChannel();
		
		FileChannel outputChannel = fileOutputStream.getChannel();
	
		outputChannel.transferFrom(inputChannel,0,inputChannel.size());

	}

}
