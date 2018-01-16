package servlet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servlet {

    private boolean isEnable = true;

    public void start(){
        try{
            ServerSocket serverSocket = new ServerSocket(1234);
            this.accept(serverSocket);
        }catch (IOException e){
             e.printStackTrace();
        }
    }

    public void accept(ServerSocket serverSocket){
        try{
            while(isEnable){
                Socket client = serverSocket.accept();
                new Thread(new Dispatcher(client)).start();
            }
        }catch (IOException e){
            isEnable = false;
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Servlet servlet = new Servlet();
        servlet.start();
    }
}
