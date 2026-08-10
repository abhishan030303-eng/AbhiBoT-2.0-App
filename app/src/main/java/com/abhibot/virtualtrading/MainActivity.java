package com.abhibot.virtualtrading;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends Activity {

    private LinearLayout root;

    private double balance = 100000.0;
    private double invested = 0.0;

    private String selectedSymbol = "NIFTY 50";
    private double selectedPrice = 24500.0;

    private final ArrayList<String> orders = new ArrayList<>();
    private final ArrayList<String> diary = new ArrayList<>();

    private int dark = Color.rgb(15, 23, 42);
    private int card = Color.rgb(30, 41, 59);
    private int green = Color.rgb(22, 163, 74);
    private int red = Color.rgb(220, 38, 38);
    private int blue = Color.rgb(37, 99, 235);
    private int white = Color.WHITE;
    private int grey = Color.rgb(148, 163, 184);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(dark);
        dashboard();
    }

    // =========================================================
    // BASIC UI
    // =========================================================

    private void setup() {

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 20, 20, 30);
        root.setBackgroundColor(dark);

        scroll.addView(root);

        setContentView(scroll);
    }

    private TextView title(String text) {

        TextView t = new TextView(this);
        t.setText(text);
        t.setTextColor(white);
        t.setTextSize(28);
        t.setTypeface(null, Typeface.BOLD);
        t.setGravity(Gravity.CENTER);
        t.setPadding(5, 10, 5, 5);

        root.addView(t);

        return t;
    }

    private TextView subtitle(String text) {

        TextView t = new TextView(this);
        t.setText(text);
        t.setTextColor(grey);
        t.setTextSize(15);
        t.setGravity(Gravity.CENTER);
        t.setPadding(5, 0, 5, 18);

        root.addView(t);

        return t;
    }

    private TextView label(String text) {

        TextView t = new TextView(this);
        t.setText(text);
        t.setTextColor(white);
        t.setTextSize(17);
        t.setPadding(4, 14, 4, 8);

        root.addView(t);

        return t;
    }

    private GradientDrawable background(int color, float radius) {

        GradientDrawable g = new GradientDrawable();
        g.setColor(color);
        g.setCornerRadius(radius);
        return g;
    }

    private Button button(String text) {

        Button b = new Button(this);

        b.setText(text);
        b.setTextColor(white);
        b.setTextSize(16);
        b.setAllCaps(false);
        b.setGravity(Gravity.CENTER);
        b.setPadding(10, 5, 10, 5);

        b.setBackground(background(card, 24));

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        58
                );

        p.setMargins(0, 7, 0, 7);

        root.addView(b, p);

        return b;
    }

    private Button coloredButton(String text, int color) {

        Button b = button(text);
        b.setBackground(background(color, 24));
        return b;
    }

    private TextView cardText(String text) {

        TextView t = new TextView(this);

        t.setText(text);
        t.setTextColor(white);
        t.setTextSize(16);
        t.setPadding(18, 18, 18, 18);
        t.setBackground(background(card, 22));

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(0, 6, 0, 6);

        root.addView(t, p);

        return t;
    }

    private void toast(String text) {

        Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
        ).show();
    }

    private String money(double value) {

        return String.format(
                Locale.US,
                "₹%,.2f",
                value
        );
    }

    private void back() {

        Button b = button("←  Back to Dashboard");

        b.setOnClickListener(v -> dashboard());
    }

    // =========================================================
    // DASHBOARD
    // =========================================================

    private void dashboard() {

        setup();

        title("AbhiBoT 2.0");
        subtitle("VIRTUAL TRADING PLATFORM");

        LinearLayout balanceCard = new LinearLayout(this);
        balanceCard.setOrientation(LinearLayout.VERTICAL);
        balanceCard.setGravity(Gravity.CENTER);
        balanceCard.setPadding(20, 20, 20, 20);
        balanceCard.setBackground(background(Color.rgb(30, 64, 175), 28));

        TextView balanceTitle = new TextView(this);
        balanceTitle.setText("AVAILABLE BALANCE");
        balanceTitle.setTextColor(Color.rgb(191, 219, 254));
        balanceTitle.setTextSize(13);
        balanceTitle.setGravity(Gravity.CENTER);

        TextView balanceValue = new TextView(this);
        balanceValue.setText(money(balance));
        balanceValue.setTextColor(white);
        balanceValue.setTextSize(30);
        balanceValue.setTypeface(null, Typeface.BOLD);
        balanceValue.setGravity(Gravity.CENTER);

        balanceCard.addView(balanceTitle);
        balanceCard.addView(balanceValue);

        root.addView(balanceCard);

        cardText(
                "MARKET STATUS\n"
                        + "NIFTY 50     ₹24,500\n"
                        + "BANK NIFTY   ₹55,000\n"
                        + "SENSEX       ₹80,000"
        );

        label("QUICK ACTIONS");

        Button trade = coloredButton(
                "⚡  START NEW TRADE",
                blue
        );
        trade.setOnClickListener(v -> tradeScreen());

        Button market = button("📊  VIRTUAL TRADING");
        market.setOnClickListener(v -> virtualTrading());

        Button watch = button("★  WATCHLIST");
        watch.setOnClickListener(v -> watchlist());

        Button ordersButton = button("▣  ORDERS & POSITIONS");
        ordersButton.setOnClickListener(v -> ordersScreen());

        Button diaryButton = button("▤  TRADING DIARY");
        diaryButton.setOnClickListener(v -> diaryScreen());

        Button profileButton = button("●  PROFILE");
        profileButton.setOnClickListener(v -> profileScreen());

        Button settingsButton = button("⚙  SETTINGS");
        settingsButton.setOnClickListener(v -> settingsScreen());

        subtitle(
                "PAPER TRADING • NO REAL MONEY\n"
                        + "Virtual Balance: " + money(balance)
        );
    }

    // =========================================================
    // VIRTUAL TRADING
    // =========================================================

    private void virtualTrading() {

        setup();

        title("Virtual Trading");
        subtitle("SELECT MARKET");

        marketCard(
                "NIFTY 50",
                24500
        );

        marketCard(
                "BANK NIFTY",
                55000
        );

        marketCard(
                "SENSEX",
                80000
        );

        marketCard(
                "FINNIFTY",
                26000
        );

        marketCard(
                "MIDCAP SELECT",
                13500
        );

        back();
    }

    private void marketCard(
            String symbol,
            double price
    ) {

        Button b = button(
                symbol + "\n" + money(price)
        );

        b.setOnClickListener(v -> {

            selectedSymbol = symbol;
            selectedPrice = price;

            tradeScreen();
        });
    }

    // =========================================================
    // WATCHLIST
    // =========================================================

    private void watchlist() {

        setup();

        title("Watchlist");
        subtitle("MARKET WATCH");

        watchItem("NIFTY 50", 24500);
        watchItem("BANK NIFTY", 55000);
        watchItem("SENSEX", 80000);
        watchItem("FINNIFTY", 26000);
        watchItem("MIDCAP SELECT", 13500);

        back();
    }

    private void watchItem(
            String symbol,
            double price
    ) {

        TextView item = cardText(
                symbol
                        + "\n"
                        + money(price)
                        + "     •     PAPER MARKET"
        );

        item.setOnClickListener(v -> {

            selectedSymbol = symbol;
            selectedPrice = price;

            tradeScreen();
        });
    }

    // =========================================================
    // TRADE SCREEN
    // =========================================================

    private void tradeScreen() {

        setup();

        title("Place Virtual Trade");

        subtitle(
                selectedSymbol
                        + "  •  "
                        + money(selectedPrice)
        );

        cardText(
                "AVAILABLE BALANCE\n"
                        + money(balance)
        );

        label("ORDER TYPE");

        Button marketOrder = button(
                "MARKET ORDER  •  ACTIVE"
        );

        marketOrder.setOnClickListener(
                v -> toast("Market order selected")
        );

        label("QUANTITY");

        EditText quantity = new EditText(this);
        quantity.setHint("Enter quantity");
        quantity.setText("1");
        quantity.setTextColor(white);
        quantity.setHintTextColor(grey);
        quantity.setTextSize(17);
        quantity.setInputType(2);
        quantity.setPadding(18, 0, 18, 0);
        quantity.setBackground(background(card, 20));

        root.addView(
                quantity,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        58
                )
        );

        label("STOP LOSS");

        EditText stopLoss = new EditText(this);
        stopLoss.setHint("Optional");
        stopLoss.setTextColor(white);
        stopLoss.setHintTextColor(grey);
        stopLoss.setInputType(2);
        stopLoss.setPadding(18, 0, 18, 0);
        stopLoss.setBackground(background(card, 20));

        root.addView(
                stopLoss,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        58
                )
        );

        label("TARGET");

        EditText target = new EditText(this);
        target.setHint("Optional");
        target.setTextColor(white);
        target.setHintTextColor(grey);
        target.setInputType(2);
        target.setPadding(18, 0, 18, 0);
        target.setBackground(background(card, 20));

        root.addView(
                target,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        58
                )
        );

        label("EXECUTE");

        Button buy = coloredButton(
                "BUY  •  LONG",
                green
        );

        buy.setOnClickListener(v -> {

            int qty = getQuantity(quantity);

            if (qty <= 0) return;

            double amount =
                    selectedPrice * qty;

            if (amount > balance) {

                toast("Insufficient virtual balance");
                return;
            }

            balance -= amount;
            invested += amount;

            String order =
                    "BUY | "
                            + selectedSymbol
                            + " | Qty: "
                            + qty
                            + " | Entry: "
                            + money(selectedPrice);

            orders.add(order);
            diary.add(order);

            toast("BUY order executed");

            dashboard();
        });

        Button sell = coloredButton(
                "SELL  •  SHORT",
                red
        );

        sell.setOnClickListener(v -> {

            int qty = getQuantity(quantity);

            if (qty <= 0) return;

            double amount =
                    selectedPrice * qty;

            balance += amount;

            String order =
                    "SELL | "
                            + selectedSymbol
                            + " | Qty: "
                            + qty
                            + " | Entry: "
                            + money(selectedPrice);

            orders.add(order);
            diary.add(order);

            toast("SELL order executed");

            dashboard();
        });

        back();
    }

    private int getQuantity(EditText e) {

        try {

            int q = Integer.parseInt(
                    e.getText()
                            .toString()
                            .trim()
            );

            if (q <= 0) {

                toast("Quantity must be greater than 0");
                return 0;
            }

            return q;

        } catch (Exception ex) {

            toast("Enter a valid quantity");
            return 0;
        }
    }

    // =========================================================
    // ORDERS
    // =========================================================

    private void ordersScreen() {

        setup();

        title("Orders & Positions");
        subtitle("VIRTUAL PORTFOLIO");

        cardText(
                "AVAILABLE\n"
                        + money(balance)
                        + "\n\nINVESTED\n"
                        + money(invested)
        );

        if (orders.isEmpty()) {

            cardText(
                    "No orders yet.\n\n"
                            + "Your BUY / SELL trades will appear here."
            );

        } else {

            label(
                    "ORDER HISTORY  •  "
                            + orders.size()
            );

            for (String order : orders) {

                cardText(order);
            }
        }

        Button newTrade =
                coloredButton(
                        "⚡ NEW TRADE",
                        blue
                );

        newTrade.setOnClickListener(
                v -> tradeScreen()
        );

        back();
    }

    // =========================================================
    // DIARY
    // =========================================================

    private void diaryScreen() {

        setup();

        title("Trading Diary");
        subtitle("YOUR TRADING JOURNAL");

        if (diary.isEmpty()) {

            cardText(
                    "No trades recorded.\n\n"
                            + "Start a virtual trade to create your first diary entry."
            );

        } else {

            label(
                    "TRADE LOG  •  "
                            + diary.size()
            );

            for (String item : diary) {

                cardText(item);
            }
        }

        back();
    }

    // =========================================================
    // PROFILE
    // =========================================================

    private void profileScreen() {

        setup();

        title("Profile");
        subtitle("ABHIBOT ACCOUNT");

        cardText(
                "ACCOUNT TYPE\n"
                        + "Virtual Trading Account\n\n"
                        + "STATUS\n"
                        + "Active\n\n"
                        + "BALANCE\n"
                        + money(balance)
        );

        cardText(
                "TOTAL ORDERS\n"
                        + orders.size()
        );

        Button reset = coloredButton(
                "RESET VIRTUAL ACCOUNT",
                red
        );

        reset.setOnClickListener(v -> {

            balance = 100000;
            invested = 0;
            orders.clear();
            diary.clear();

            toast("Virtual account reset");

            profileScreen();
        });

        back();
    }

    // =========================================================
    // SETTINGS
    // =========================================================

    private void settingsScreen() {

        setup();

        title("Settings");
        subtitle("ABHIBOT 2.0 CONFIGURATION");

        cardText(
                "TRADING MODE\n"
                        + "PAPER / VIRTUAL TRADING"
        );

        Button notifications =
                button(
                        "🔔  Notifications"
                );

        notifications.setOnClickListener(
                v -> toast("Notifications settings opened")
        );

        Button security =
                button(
                        "🔐  Security"
                );

        security.setOnClickListener(
                v -> toast("Security settings opened")
        );

        Button broker =
                button(
                        "🔌  Broker API"
                );

        broker.setOnClickListener(
                v -> brokerScreen()
        );

        Button about =
                button(
                        "ℹ  About AbhiBoT"
                );

        about.setOnClickListener(
                v -> aboutScreen()
        );

        back();
    }

    // =========================================================
    // BROKER
    // =========================================================

    private void brokerScreen() {

        setup();

        title("Broker API");
        subtitle("OPTIONAL CONNECTION");

        cardText(
                "This version is PAPER TRADING only.\n\n"
                        + "You can later configure broker APIs "
                        + "for supported brokers."
        );

        EditText apiKey =
                new EditText(this);

        apiKey.setHint("Enter API Key");
        apiKey.setTextColor(white);
        apiKey.setHintTextColor(grey);
        apiKey.setPadding(18, 0, 18, 0);
        apiKey.setBackground(background(card, 20));

        root.addView(
                apiKey,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        58
                )
        );

        Button save =
                coloredButton(
                        "SAVE API CONFIGURATION",
                        blue
                );

        save.setOnClickListener(
                v -> toast("API configuration saved locally")
        );

        back();
    }

    // =========================================================
    // ABOUT
    // =========================================================

    private void aboutScreen() {

        setup();

        title("AbhiBoT 2.0");

        subtitle(
                "Virtual Trading Platform"
        );

        cardText(
                "VERSION\n2.0\n\n"
                        + "MODE\nPaper Trading\n\n"
                        + "VIRTUAL CAPITAL\n"
                        + money(balance)
        );

        back();
    }

    // =========================================================
    // ANDROID BACK
    // =========================================================

    @Override
    public void onBackPressed() {

        dashboard();
    }
    }
