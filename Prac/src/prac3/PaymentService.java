interface PaymentService {
    void processPayment(double amount) throws Exception;
    void refundPayment(double amount) throws Exception;
}