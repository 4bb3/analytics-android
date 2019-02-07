package com.cassby.analytics;

import android.content.Context;

public interface AnalyticsService {
    void logIn();

    void addSuperProps(int taxDefault, String printerMode, String cardMode, String barcodeMode, String bankName, Boolean printReceiptCopy, String weighterDevice, int accountId, int branchId);

    void openShift(String uuid);

    void switchView(String type);

    void search();

    void openFolder();

    void newPosition(String type, String weightType, boolean isFreePrice, int tax, int price, boolean isCustom);

    void customPosition(int price);

    void discount(String type, int value);

    void setWeight(String weightType, boolean isFloat);

    void onlineReceipt(String contactType);

    void holdReceipt(int numberOfPositions);

    void restoreReceipt(int numberOfHours);

    void payment(String paymentType, int sum);

    void banknote(String banknoteType, String screen);

    void refund(String refundType, int sum, int hoursDifference);

    void cashAction(String cashActionType, int sum);

    void sync(String syncType);

    void closeShift();

    void printError(String error, String firmware);

    void logout();

    void useWeighter();

    void useBarcoder();

    void goBack(String screen);

    void keyboardShowed(String type);

    void breadcrumbs();

    void clearReceipt();

    void startReceipt(int positions, int sum);

    void completeReceipt(int positions, int sum);
}
