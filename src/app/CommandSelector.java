package app;

import java.util.Calendar;

import app.commands.Connor;
import app.commands.Isaiah;
import app.commands.Ping;
import app.commands.Roll;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandSelector {
    public CommandSelector(MessageReceivedEvent event, String message) {
        String[] args = message.substring(1).trim().split(" ");
        String command = args[0];
        //message.content.slice(prefix.length).trim().split(/ +/g);
        System.out.println(event.getAuthor() + " just tried to run " + message + " at " + Calendar.getInstance().getTime());

        if (message.equals("ping")) {
            new Ping(event);
        }
        switch (command) {
            case "ping":
                new Ping(event);
                break;
            case "isaiah":
                new Isaiah(event);
                break;
            case "connor":
                new Connor(event);
                break;
            case "roll":
                String[] dice = args[1].split("d");
                String amountToRollString;
                String sidesString;
                String modifierString;
                if (dice.length > 1) {
                    amountToRollString = dice[0].toString();
                    sidesString = dice[1].toString();
                } else {
                    amountToRollString = 1 + "";
                    sidesString = dice[0].toString();
                }
                if (args.length > 2) {
                    modifierString = args[2];
                } else {
                    modifierString = 0 + "";
                }
                
                int amountToRoll;
                try {
                    amountToRoll = Integer.parseInt(amountToRollString.replaceAll("[^0-9]+", ""));
                } catch (Exception e) {
                    amountToRoll = 1;
                }
                int sides = Integer.parseInt(sidesString.replaceAll("[^0-9]+", ""));
                int modifier = Integer.parseInt(modifierString.replaceAll("[^0-9]-+", ""));

                if (amountToRoll > 200) {
                    amountToRoll = 200;
                }

                System.out.println("Amount: " + amountToRoll + " Sides: " + sides + " Modifier: " + modifier);
                new Roll(event, amountToRoll, sides, modifier);
                break;
        }
    }
}