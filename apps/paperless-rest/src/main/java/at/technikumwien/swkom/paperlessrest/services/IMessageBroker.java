package at.technikumwien.swkom.paperlessrest.services;

public interface IMessageBroker {
    void send(String message);
    void processOCRResultsMessage(String message);
}
