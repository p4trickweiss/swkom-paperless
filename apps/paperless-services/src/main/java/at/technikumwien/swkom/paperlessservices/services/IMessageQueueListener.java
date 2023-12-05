package at.technikumwien.swkom.paperlessservices.services;

public interface IMessageQueueListener {
    void processDocumentsMessage(String message);
}
