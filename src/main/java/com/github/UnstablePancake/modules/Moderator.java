package com.github.UnstablePancake.modules;

import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.MessageList;
import sx.blah.discord.util.RateLimitException;

public class Moderator {

    private IDiscordClient client;
    private MessageList messageList;
    private int cacheCapacity = 1000;
    private int loadCapacity = 900;

    public Moderator(IDiscordClient client, IChannel channel){
        this.client = client;
        messageList = new MessageList(client, channel);
        messageList.setCacheCapacity(cacheCapacity);

        if(messageList.size() <=  cacheCapacity) {
            try {
                messageList.load(cacheCapacity - loadCapacity);
            } catch (RateLimitException e) {
                e.printStackTrace();
            }
        }
    }

    public void recordMessage(MessageReceivedEvent event){
        messageList.add(event.getMessage());
    }

    public MessageList getMessageList(){
        return messageList;
    }
}
