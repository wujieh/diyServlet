package servlet;

import solveConfiguration.WebApp;
import util.Request;
import util.Response;

import java.io.*;
import java.net.Socket;

public class Dispatcher implements Runnable{
    private Request request;
    private Response response;
    private int code = 200;
    public Dispatcher(Socket client){
        try{
            request = new Request(new BufferedReader(new InputStreamReader(client.getInputStream())));
            response = new Response(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run() {
        String action = request.getAction();
        Service servlet = WebApp.getServlet(action);
        if(servlet == null){
            this.code = 404;
            response.pushToClient(code);
            return;
        }
        servlet.service(request, response);
        response.pushToClient(200);
    }
}
