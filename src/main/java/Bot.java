import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public  class Bot extends TelegramLongPollingBot {

    String gg = "hello";
    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            //определить ид пользавателя для отправки ему смс
            System.out.println("Это ИД клиента  "+update.getMessage().getChatId().toString());

          //  message.setText(update.getMessage().getText());



            message.setText(gg);

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

public void sendMessage(String mes){
    SendMessage message2 = new SendMessage();
   // message2.setChatId(update.getMessage().getChatId().toString());
    message2.setText(mes);
    try {
        execute(message2); // Call method to send the message
    } catch (TelegramApiException e) {
        e.printStackTrace();
    }
};



    @Override
    public String getBotUsername() {
        return "JonTestBoot";
    }

    @Override
    public String getBotToken() {
        return "5004569575:AAFB67y36Il-d-rFWS2DrdiWNpLovGrxeg4";
    }



//    public static void main(String[] args) {
//
//        try {
//            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//            botsApi.registerBot(new Bot());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//
//}


}