package com.abhibot.virtualtrading;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private LinearLayout root;

    private double balance = 100000.0;

    private String symbol = "NIFTY 50";
    private double price = 24500.0;

    private final List<String> trades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dashboard();
    }

    // ==============================
    // BASIC SCREEN SETUP
    // ==============================

    private void setup() {

        ScrollView scrollView = new ScrollView(this);

        root = new LinearLayout(this);

        root.setOrientation(LinearLayout.VERTICAL);

        root.setPadding(
                24,
                28,
                24,
                40
        );

        root.setBackgroundColor(Color.WHITE);

        scrollView.addView(root);

        setContentView(scrollView);
    }

    // ==============================
    // TEXT
    // ==============================

    private TextView text(
            String value,
            float size,
            boolean bold
    ) {

        TextView textView = new TextView(this);

        textView.setText(value);

        textView.setTextSize(size);

        textView.setTextColor(Color.BLACK);

        textView.setGravity(Gravity.CENTER);

        textView.setPadding(
                4,
                10,
                4,
                10
        );

        if (bold) {
            textView.setTypeface(
                    null,
                    Typeface.BOLD
            );
        }

        return textView;
    }

    // ==============================
    // BUTTON
    // ==============================

    private Button button(String title) {

        Button button = new Button(this);

        button.setText(title);

        button.setTextSize(17);

        button.setAllCaps(false);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                0,
                6,
                0,
                6
        );

        root.addView(
                button,
                params
        );

        return button;
    }

    // ==============================
    // BACK BUTTON
    // ==============================

    private void backButton() {

        Button back =
                button("← Back to Dashboard");

        back.setOnClickListener(
                v -> dashboard()
        );
    }

    // ==============================
    // TOAST
    // ==============================

    private void message(String value) {

        Toast.makeText(
                this,
                value,
                Toast.LENGTH_SHORT
        ).show();
    }

    // ==============================
    // MONEY FORMAT
    // ==============================

    private String money(double value) {

        return String.format(
                java.util.Locale.US,
                "%.2f",
                value
        );
    }

    // ==============================
    // DASHBOARD
    // ==============================

    private void dashboard() {

        setup();

        root.addView(
                text(
                        "AbhiBoT 2.0",
                        30,
                        true
                )
        );

        root.addView(
                text(
                        "Virtual Trading Dashboard",
                        18,
                        false
                )
        );

        Button virtualTrading =
                button(
                        "📊  Virtual Trading"
                );

        virtualTrading.setOnClickListener(
                v -> virtualTrading()
        );

        Button watchlist =
                button(
                        "⭐  Watchlist"
                );

        watchlist.setOnClickListener(
                v -> watchlist()
        );

        Button startTrade =
                button(
                        "⚡  Start Trade"
                );

        startTrade.setOnClickListener(
                v -> startTrade()
        );

        Button diary =
                button(
                        "📒  Trading Diary"
                );

        diary.setOnClickListener(
                v -> diary()
        );

        Button profile =
                button(
                        "👤  Profile"
                );

        profile.setOnClickListener(
                v -> profile()
        );

        Button settings =
                button(
                        "⚙  Settings"
                );

        settings.setOnClickListener(
                v -> settings()
        );

        root.addView(
                text(
                        "Virtual Balance: ₹"
                                + money(balance),
                        17,
                        true
                )
        );

        root.addView(
                text(
                        "Mode: PAPER / VIRTUAL TRADING",
                        17,
                        false
                )
        );
    }

    // ==============================
    // VIRTUAL TRADING
    // ==============================

    private void virtualTrading() {

        setup();

        root.addView(
                text(
                        "Virtual Trading",
                        28,
                        true
                )
        );

        root.addView(
                text(
                        "Balance: ₹"
                                + money(balance),
                        18,
                        false
                )
        );

        root.addView(
                text(
                        "Select Instrument",
                        21,
                        true
                )
        );

        Button nifty =
                button(
                        "NIFTY 50   ₹24,500"
                );

        nifty.setOnClickListener(
                v -> {

                    symbol = "NIFTY 50";

                    price = 24500;

                    message(
                            "NIFTY 50 selected"
                    );

                    virtualTrading();
                }
        );

        Button bankNifty =
                button(
                        "BANK NIFTY   ₹55,000"
                );

        bankNifty.setOnClickListener(
                v -> {

                    symbol = "BANK NIFTY";

                    price = 55000;

                    message(
                            "BANK NIFTY selected"
                    );

                    virtualTrading();
                }
        );

        Button sensex =
                button(
                        "SENSEX   ₹80,000"
                );

        sensex.setOnClickListener(
                v -> {

                    symbol = "SENSEX";

                    price = 80000;

                    message(
                            "SENSEX selected"
                    );

                    virtualTrading();
                }
        );

        root.addView(
                text(
                        "Selected: "
                                + symbol
                                + "  ₹"
                                + money(price),
                        19,
                        true
                )
        );

        Button openTrade =
                button(
                        "⚡ Open Trade"
                );

        openTrade.setOnClickListener(
                v -> startTrade()
        );

        backButton();
    }

    // ==============================
    // START TRADE
    // ==============================

    private void startTrade() {

        setup();

        root.addView(
                text(
                        "Start Trade",
                        28,
                        true
                )
        );

        root.addView(
                text(
                        symbol
                                + "\nPrice: ₹"
                                + money(price),
                        18,
                        false
                )
        );

        EditText quantity =
                new EditText(this);

        quantity.setHint(
                "Enter Quantity"
        );

        quantity.setText("1");

        quantity.setInputType(2);

        root.addView(quantity);

        Button buy =
                button(
                        "🟢 BUY"
                );

        buy.setOnClickListener(
                v -> {

                    int qty =
                            getQuantity(
                                    quantity
                            );

                    if (qty <= 0) {
                        return;
                    }

                    double amount =
                            price * qty;

                    if (amount > balance) {

                        message(
                                "Insufficient virtual balance"
                        );

                        return;
                    }

                    balance =
                            balance - amount;

                    trades.add(
                            "BUY | "
                                    + symbol
                                    + " | Qty "
                                    + qty
                                    + " | ₹"
                                    + money(price)
                    );

                    message(
                            "Virtual BUY executed"
                    );

                    virtualTrading();
                }
        );

        Button sell =
                button(
                        "🔴 SELL"
                );

        sell.setOnClickListener(
                v -> {

                    int qty =
                            getQuantity(
                                    quantity
                            );

                    if (qty <= 0) {
                        return;
                    }

                    balance =
                            balance
                                    + (price * qty);

                    trades.add(
                            "SELL | "
                                    + symbol
                                    + " | Qty "
                                    + qty
                                    + " | ₹"
                                    + money(price)
                    );

                    message(
                            "Virtual SELL executed"
                    );

                    virtualTrading();
                }
        );

        backButton();
    }

    // ==============================
    // QUANTITY
    // ==============================

    private int getQuantity(
            EditText editText
    ) {

        try {

            int quantity =
                    Integer.parseInt(
                            editText
                                    .getText()
                                    .toString()
                                    .trim()
                    );

            if (quantity <= 0) {

                message(
                        "Quantity must be greater than 0"
                );

                return 0;
            }

            return quantity;

        } catch (Exception e) {

            message(
                    "Enter a valid quantity"
            );

            return 0;
        }
    }

    // ==============================
    // WATCHLIST
    // ==============================

    private void watchlist() {

        setup();

        root.addView(
                text(
                        "⭐ Watchlist",
                        28,
                        true
                )
        );

        watch(
                "NIFTY 50",
                24500
        );

        watch(
                "BANK NIFTY",
                55000
        );

        watch(
                "SENSEX",
                80000
        );

        watch(
                "FINNIFTY",
                26000
        );

        watch(
                "MIDCAP SELECT",
                13500
        );

        backButton();
    }

    private void watch(
            String name,
            double currentPrice
    ) {

        Button item =
                button(
                        name
                                + "\n₹"
                                + money(currentPrice)
                );

        item.setOnClickListener(
                v -> {

                    symbol = name;

                    price = currentPrice;

                    message(
                            name
                                    + " selected"
                    );

                    startTrade();
                }
        );
    }

    // ==============================
    // TRADING DIARY
    // ==============================

    private void diary() {

        setup();

        root.addView(
                text(
                        "📒 Trading Diary",
                        28,
                        true
                )
        );

        if (trades.isEmpty()) {

            root.addView(
                    text(
                            "No trades recorded yet.",
                            18,
                            false
                    )
            );

        } else {

            root.addView(
                    text(
                            "Recorded Trades: "
                                    + trades.size(),
                            18,
                            true
                    )
            );

            for (String trade : trades) {

                root.addView(
                        text(
                                "• " + trade,
                                16,
                                false
                        )
                );
            }
        }

        backButton();
    }

    // ==============================
    // PROFILE
    // ==============================

    private void profile() {

        setup();

        root.addView(
                text(
                        "👤 Profile",
                        28,
                        true
                )
        );

        root.addView(
                text(
                        "Account: Virtual Trading",
                        18,
                        false
                )
        );

        root.addView(
                text(
                        "Current Balance: ₹"
                                + money(balance),
                        18,
                        false
                )
        );

        root.addView(
                text(
                        "Trades: "
                                + trades.size(),
                        18,
                        false
                )
        );

        Button reset =
                button(
                        "Reset Virtual Account"
                );

        reset.setOnClickListener(
                v -> {

                    balance = 100000;

                    trades.clear();

                    message(
                            "Virtual account reset"
                    );

                    profile();
                }
        );

        backButton();
    }

    // ==============================
    // SETTINGS
    // ==============================

    private void settings() {

        setup();

        root.addView(
                text(
                        "⚙ Settings",
                        28,
                        true
                )
        );

        root.addView(
                text(
                        "Trading Mode: PAPER / VIRTUAL",
                        18,
                        false
                )
        );

        root.addView(
                text(
                        "AbhiBoT 2.0",
                        18,
                        false
                )
        );

        Button alerts =
                button(
                        "🔔 Alerts & Notifications"
                );

        alerts.setOnClickListener(
                v -> message(
                        "Alerts module selected"
                )
        );

        Button security =
                button(
                        "🔐 Security"
                );

        security.setOnClickListener(
                v -> message(
                        "Security settings selected"
                )
        );

        Button broker =
                button(
                        "🔌 Broker API Configuration"
                );

        broker.setOnClickListener(
                v -> message(
                        "Broker API configuration selected"
                )
        );

        backButton();
    }

    // ==============================
    // ANDROID BACK BUTTON
    // ==============================

    @Override
    public void onBackPressed() {

        dashboard();
    }
                        }
