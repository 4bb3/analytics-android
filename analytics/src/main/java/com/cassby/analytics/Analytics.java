package com.cassby.analytics;

import android.content.Context;
import android.util.Log;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONObject;

public class Analytics implements AnalyticsService {

    private static final String MIXPANEL_TOKEN = "87438f1aebb600fa38d7dcda3442e311";

    private Context context;

    public class Events {
        public static final String LOGIN = "Log in";
        public static final String OPEN_SHIFT = "Open shift";
        public static final String OPEN_SHIFT_ID = "ID";
        public static final String SWICH_VIEW = "Switch view";
        public static final String SWITCH_VIEW_TYPE = "Type";
        public static final String SWITCH_VIEW_TYPE_LIST = "list";
        public static final String SWITCH_VIEW_TYPE_CARDS = "cards";
        public static final String SEARCH = "Search";
        public static final String OPEN_FOLDER = "Open folder";
        public static final String ADD_POSITION_TO_CHECK = "Add position";
        public static final String ADD_POSITION_TO_CHECK_IS_CUSTOM = "Is custom";
        public static final String ADD_POSITION_TO_CHECK_TYPE = "Type";
        public static final String ADD_POSITION_TO_CHECK_WEIGHT_TYPE = "Weight type";
        public static final String ADD_POSITION_TO_CHECK_FREE_PRICE = "Free Price";
        public static final String ADD_POSITION_TO_CHECK_TAX = "Tax";
        public static final String ADD_POSITION_TO_CHECK_PRICE = "Price";
        public static final String ADD_CUSTOM_POSITION = "Custom position";
        public static final String ADD_CUSTOM_POSITION_PRICE = "Price";
        public static final String ADD_DISCOUNT = "Discount";
        public static final String ADD_DISCOUNT_TYPE = "Type";
        public static final String ADD_DISCOUNT_TYPE_RECEIPT = "Receipt";
        public static final String ADD_DISCOUNT_TYPE_POSITION = "Position";
        public static final String ADD_DISCOUNT_VALUE = "Value";
        public static final String SET_WEIGHT = "Set weight";
        public static final String SET_WEIGHT_TYPE = "Weight type";
        public static final String SET_WEIGHT_IS_FLOAT = "Is float";
        public static final String ADD_ERECEIPT = "Online receipt";
        public static final String ADD_ERECEIPT_CONTACT = "Contact";
        public static final String ADD_ERECEIPT_CONTACT_TYPE_PHONE = "Phone";
        public static final String ADD_ERECEIPT_CONTACT_TYPE_MAIL = "Mail";
        public static final String HOLD_CHECK = "Shelve receipt";
        public static final String HOLD_CHECK_NUMBER_OF_POSITIONS = "Positions";
        public static final String RESTORE_CHECK = "Restore receipt";
        public static final String RESTORE_CHECK_NUMBER_OF_HOURS = "Hours difference";
        public static final String PAYMENT = "Payment";
        public static final String PAYMENT_SUM = "Sum";
        public static final String PAYMENT_TYPE = "Type";
        public static final String PAYMENT_TYPE_CASH = "Cash";
        public static final String PAYMENT_TYPE_CARD = "Card";
        public static final String BANKNOTE = "Banknote";
        public static final String BANKNOTE_TYPE = "Type";
        public static final String BANKNOTE_SCREEN = "Screen";
        public static final String BANKNOTE_SCREEN_CASH_IN = "Cash in";
        public static final String BANKNOTE_SCREEN_CASH_OUT = "Cash  out";
        public static final String BANKNOTE_SCREEN_PAYMENT = "Payment";
        public static final String BANKNOTE_100 = "100";
        public static final String BANKNOTE_500 = "500";
        public static final String BANKNOTE_1000 = "1000";
        public static final String BANKNOTE_5000 = "5000";
        public static final String REFUND = "Refund";
        public static final String REFUND_TYPE = "Type";
        public static final String REFUND_SUM = "Sum";
        public static final String REFUND_HOURS_DIFFERENCE = "Hours difference";
        public static final String CASH_ACTION = "Cash action";
        public static final String CASH_ACTION_TYPE = "Type";
        public static final String CASH_ACTION_TYPE_IN = "In";
        public static final String CASH_ACTION_TYPE_OUT = "Out";
        public static final String CASH_ACTION_SUM = "Sum";
        public static final String SYNC_DATA = "Sync data";
        public static final String SYNC_DATA_TYPE = "Type";
        public static final String SYNC_DATA_FORCED = "Forced";
        public static final String SYNC_DATA_BUTTON = "Button";
        public static final String CLOSE_SHIFT = "Close shift";
        public static final String PRINT_ERROR = "Print Error";
        public static final String PRINT_ERROR_ERROR = "Error";
        public static final String PRINT_ERROR_FIRMWARE = "Firmware";
        public static final String LOGOUT = "Log out";
        public static final String USE_WEIGHTER = "Use weighter";
        public static final String USE_BARCODER = "Use barcoder";
        public static final String GO_BACK = "Go back";
        public static final String GO_BACK_SCREEN = "Screen";
        public static final String KEYBOARD = "Keyboard";
        public static final String KEYBOARD_TYPE = "Screen";
        public static final String BREADCRUMBS = "Breadcrumbs";
        public static final String CLEAR_RECEIPT = "Clear receipt";
        public static final String START_RECEIPT = "Start receipt";
        public static final String START_RECEIPT_SUM = "Sum";
        public static final String START_RECEIPT_POSITIONS = "Positions";
        public static final String COMPLETE_RECEIPT = "Complete receipt";
        public static final String COMPLETE_RECEIPT_SUM = "Sum";
        public static final String COMPLETE_RECEIPT_POSITIONS = "Positions";

        public static final String TAX_DEFAULT = "tax_default";
        public static final String PRINTER_MODE = "printer_mode";
        public static final String CARD_MODE = "card_mode";
        public static final String BARCODE_MODE = "barcode_mode";
        public static final String BANK_NAME = "bank_name";
        public static final String PRINT_COPY_OF_RECEIPT = "print_copy_of_the_receipt";
        public static final String WEIGHTER_DEVICE = "weighter_device";
        public static final String ACCOUNT_ID = "account_id";
        public static final String BRANCH_ID = "branch_id";
    }

    public Analytics(Context context) {
        this.context = context;
    }

    private void sendMixpanelEvent(Context context, String name, JSONObject data) {
        MixpanelAPI mixpanel = MixpanelAPI.getInstance(context, MIXPANEL_TOKEN);
        mixpanel.track(name, data);
    }

    private void sendMixpanelEmptyEvent(Context context, String name) {
        MixpanelAPI mixpanel = MixpanelAPI.getInstance(context, MIXPANEL_TOKEN);
        mixpanel.track(name);
    }

    private void sendSuperPropsMixpanelEvent(Context context, JSONObject props) {
        MixpanelAPI mixpanel = MixpanelAPI.getInstance(context, MIXPANEL_TOKEN);
        mixpanel.registerSuperProperties(props);
    }

    private void sendPeopleEvent(String id) {
        MixpanelAPI mixpanel = MixpanelAPI.getInstance(context, MIXPANEL_TOKEN);
        mixpanel.identify(id);
    }

    @Override
    public void logIn() {
        try {
            sendMixpanelEmptyEvent(context, Events.LOGIN);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void addSuperProps(int taxDefault, String printerMode, String cardMode, String barcodeMode, String bankName, Boolean printReceiptCopy, String weighterDevice, int accountId, int branchId) {
        try {
            JSONObject props = new JSONObject();

            props.put(Events.TAX_DEFAULT, taxDefault);
            props.put(Events.PRINTER_MODE, printerMode);
            props.put(Events.CARD_MODE, cardMode);
            props.put(Events.BARCODE_MODE, barcodeMode);
            props.put(Events.BANK_NAME, bankName);
            props.put(Events.PRINT_COPY_OF_RECEIPT, printReceiptCopy);
            props.put(Events.WEIGHTER_DEVICE, weighterDevice);
            props.put(Events.ACCOUNT_ID, accountId);
            props.put(Events.BRANCH_ID, branchId);

            sendSuperPropsMixpanelEvent(context, props);
            sendPeopleEvent(accountId + " " + branchId);

        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }


    @Override
    public void openShift(String uuid) {
        try {
            JSONObject props = new JSONObject();

            props.put(Events.OPEN_SHIFT_ID, uuid);
            sendSuperPropsMixpanelEvent(context, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void switchView(String type) {
        try {

            JSONObject props = new JSONObject();
            props.put(Events.SWITCH_VIEW_TYPE, type);

            sendMixpanelEmptyEvent(context, Events.SWICH_VIEW);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void search() {
        try {
            sendMixpanelEmptyEvent(context, Events.SEARCH);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void openFolder() {
        try {
            sendMixpanelEmptyEvent(context, Events.OPEN_FOLDER);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void newPosition(String type, String weightType, boolean isFreePrice, int tax, int price, boolean isCustom) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.ADD_POSITION_TO_CHECK_TYPE, type);
            props.put(Events.ADD_POSITION_TO_CHECK_WEIGHT_TYPE, weightType);
            props.put(Events.ADD_POSITION_TO_CHECK_FREE_PRICE, isFreePrice);
            props.put(Events.ADD_POSITION_TO_CHECK_TAX, tax);
            props.put(Events.ADD_POSITION_TO_CHECK_PRICE, price);
            props.put(Events.ADD_POSITION_TO_CHECK_IS_CUSTOM, isCustom);

            sendMixpanelEvent(context, Events.ADD_POSITION_TO_CHECK, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void customPosition(int price) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.ADD_CUSTOM_POSITION_PRICE, price);

            sendMixpanelEvent(context, Events.ADD_CUSTOM_POSITION, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void discount(String type, int value) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.ADD_DISCOUNT_TYPE, type);
            props.put(Events.ADD_DISCOUNT_VALUE, value);

            sendMixpanelEvent(context, Events.ADD_DISCOUNT, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }


    @Override
    public void setWeight(String weightType, boolean isFloat) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.SET_WEIGHT_TYPE, weightType);
            props.put(Events.SET_WEIGHT_IS_FLOAT, isFloat);

            sendMixpanelEvent(context, Events.SET_WEIGHT, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void onlineReceipt(String contactType) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.ADD_ERECEIPT_CONTACT, contactType);

            sendMixpanelEvent(context, Events.ADD_ERECEIPT, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void holdReceipt(int numberOfPositions) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.HOLD_CHECK_NUMBER_OF_POSITIONS, numberOfPositions);

            sendMixpanelEvent(context, Events.HOLD_CHECK, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void restoreReceipt(int numberOfHours) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.RESTORE_CHECK_NUMBER_OF_HOURS, numberOfHours);

            sendMixpanelEvent(context, Events.RESTORE_CHECK, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void payment(String paymentType, int sum) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.PAYMENT_TYPE, paymentType);
            props.put(Events.PAYMENT_SUM, sum);

            sendMixpanelEvent(context, Events.PAYMENT, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void banknote(String banknoteType, String screen) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.BANKNOTE_TYPE, banknoteType);
            props.put(Events.BANKNOTE_SCREEN, screen);

            sendMixpanelEvent(context, Events.BANKNOTE, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void refund(String refundType, int sum, int hoursDifference) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.REFUND_TYPE, refundType);
            props.put(Events.REFUND_SUM, sum);
            props.put(Events.REFUND_HOURS_DIFFERENCE, hoursDifference);

            sendMixpanelEvent(context, Events.REFUND, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void cashAction(String cashActionType, int sum) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.CASH_ACTION_TYPE, cashActionType);
            props.put(Events.CASH_ACTION_SUM, sum);

            sendMixpanelEvent(context, Events.CASH_ACTION, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void sync(String syncType) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.SYNC_DATA_TYPE, syncType);

            sendMixpanelEvent(context, Events.SYNC_DATA, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void closeShift() {
        try {
            sendMixpanelEmptyEvent(context, Events.CLOSE_SHIFT);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void printError(String error, String firmware) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.PRINT_ERROR_ERROR, error);
            props.put(Events.PRINT_ERROR_FIRMWARE, firmware);

            sendMixpanelEvent(context, Events.PRINT_ERROR, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void logout() {
        try {
            sendMixpanelEmptyEvent(context, Events.LOGOUT);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void useWeighter() {
        try {
            sendMixpanelEmptyEvent(context, Events.USE_WEIGHTER);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void useBarcoder() {
        try {
            sendMixpanelEmptyEvent(context, Events.USE_BARCODER);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void goBack(String screen) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.GO_BACK_SCREEN, screen);

            sendMixpanelEvent(context, Events.GO_BACK, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void keyboardShowed(String type) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.KEYBOARD_TYPE, type);

            sendMixpanelEvent(context, Events.KEYBOARD, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void breadcrumbs() {
        try {
            sendMixpanelEmptyEvent(context, Events.BREADCRUMBS);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void clearReceipt() {
        try {
            sendMixpanelEmptyEvent(context, Events.CLEAR_RECEIPT);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void startReceipt(int positions, int sum) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.START_RECEIPT_POSITIONS, positions);
            props.put(Events.START_RECEIPT_SUM, sum);

            sendMixpanelEvent(context, Events.START_RECEIPT, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }

    @Override
    public void completeReceipt(int positions, int sum) {
        try {
            JSONObject props = new JSONObject();
            props.put(Events.COMPLETE_RECEIPT_POSITIONS, positions);
            props.put(Events.COMPLETE_RECEIPT_SUM, sum);

            sendMixpanelEvent(context, Events.COMPLETE_RECEIPT, props);
        } catch (Exception e) {
            Log.d("MIXPANEL ERROR", e.getLocalizedMessage());
        }
    }
}
