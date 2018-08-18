package com.example.dlarb.a2b2o2.Server;

public class Chat {

    String chat;
    String time;

    public Chat(String chat, String time){
        this.chat = chat;
        this.time = time;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
