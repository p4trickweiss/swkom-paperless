package at.technikumwien.swkom.paperlessservices.services;

public interface IMessageBroker {
    void processDocumentsMessage(String message);
    void send(String message);
}
