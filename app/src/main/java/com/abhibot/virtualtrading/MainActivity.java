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
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private LinearLayout root;

    // Virtual trading data
    private double balance = 100000.00;
    private String selectedSymbol = "NIFTY 50";
    private double selectedPrice = 24500.00;
    private int quantity = 1;

    private final List<String> diary = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showDashboard();
    }

    // ============================================================
    // BASIC UI HELPERS
    // ============================================================

    private void createRoot() {

        ScrollView scrollView = new ScrollView(this);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 30, 24, 40);
        root.setBackgroundColor(Color.WHITE);

        scrollView.addView(root);

        setContentView(scrollView);
    }

    private TextView title(String text) {

        TextView tv = new TextView(this);

        tv.setText(text);
        tv.setTextSize(28);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(0, 10, 0, 15);

        return tv;
    }

    private TextView heading(String text) {

        TextView tv = new TextView(this);

        tv.setText(text);
        tv.setTextSize(21);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setTextColor(Color.BLACK);
        tv.setPadding(0, 20, 0, 10);

        return tv;
    }

    private TextView text(String value) {

        TextView tv = new TextView(this);

        tv.setText(value);
        tv.setTextSize(17);
        tv.setTextColor(Color.DKGRAY);
        tv.setPadding(5, 8, 5, 8);

        return tv;
    }

    private Button menuButton(String text) {

        Button button = new Button(this);

        button.setText(text);
        button.setTextSize(17);
        button.setAllCaps(false);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 7, 0, 7);

        root.addView(button, params);

        return button;
    }

    private Button actionButton(String text) {

        Button button = new Button(this);

        button.setText(text);
        button.setTextSize(17);
        button.setAllCaps(false);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 8, 0, 8);

        root.addView(button, params);

        return button;
    }

    private void addBackButton() {

        Button back = actionButton("← Back to Dashboard");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDashboard();
            }
        });
    }

    private void addSpace(int height) {

        Space space = new Space(this);

        root.addView(
                space,
                new LinearLayout.LayoutParams(
                        1,
                        height
                )
        );
    }

    private void toast(String message) {

        Toast.makeText(
                MainActivity.this,
                message,
                Toast.LENGTH_SHORT
        ).show();
    }

    // ============================================================
    // DASHBOARD
    // ============================================================

    private void showDashboard() {

        createRoot();

        root.addView(title("AbhiBoT 2.0"));

        TextView subtitle =
                text("Virtual Trading Dashboard");

        subtitle.setGravity(Gravity.CENTER);
        subtitle.setTextSize(17);

        root.addView(subtitle);

        addSpace(10);

        Button virtualTrading =
                menuButton("📊  Virtual Trading");

        virtualTrading.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showVirtualTrading();
                    }
                }
        );

        Button watchlist =
                menuButton("⭐  Watchlist");

        watchlist.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showWatchlist();
                    }
                }
        );

        Button startTrade =
                menuButton("⚡  Start Trade");

        startTrade.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showStartTrade();
                    }
                }
        );

        Button diaryButton =
                menuButton("📒  Trading Diary");

        diaryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDiary();
                    }
                }
        );

        Button profile =
                menuButton("👤  Profile");

        profile.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showProfile();
                    }
                }
        );

        Button settings =
                menuButton("⚙  Settings");

        settings.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showSettings();
                    }
                }
        );

        addSpace(20);

        root.addView(heading("Virtual Account"));

        root.addView(
                text(
                        "Available Balance: ₹" +
                        String.format("%.2f", balance)
                )
        );

        root.addView(
                text("Mode: PAPER / VIRTUAL TRADING")
        );
    }

    // ============================================================
    // VIRTUAL TRADING
    // ============================================================

    private void showVirtualTrading() {

        createRoot();

        root.addView(title("Virtual Trading"));

        root.addView(
                text("Practice trading with virtual money.")
        );

        root.addView(
                heading("Account Balance")
        );

        root.addView(
                text(
                        "₹" +
                        String.format("%.2f", balance)
                )
        );

        root.addView(
                heading("Market")
        );

        Button nifty =
                actionButton("NIFTY 50   ₹24,500");

        nifty.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectedSymbol = "NIFTY 50";
                        selectedPrice = 24500;
                        toast("NIFTY 50 selected");
                    }
                }
        );

        Button bank =
                actionButton("BANK NIFTY   ₹55,000");

        bank.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectedSymbol = "BANK NIFTY";
                        selectedPrice = 55000;
                        toast("BANK NIFTY selected");
                    }
                }
        );

        Button sensex =
                actionButton("SENSEX   ₹80,000");

        sensex.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectedSymbol = "SENSEX";
                        selectedPrice = 80000;
                        toast("SENSEX selected");
                    }
                }
        );

        root.addView(
                heading("Selected Instrument")
        );

        root.addView(
                text(
                        selectedSymbol +
                        "\nPrice: ₹" +
                        String.format("%.2f", selectedPrice)
                )
        );

        addSpace(10);

        Button trade =
                actionButton("⚡ Open Trade");

        trade.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showStartTrade();
                    }
                }
        );

        addBackButton();
    }

    // ============================================================
    // START TRADE
    // ============================================================

    private void showStartTrade() {

        createRoot();

        root.addView(title("Start Trade"));

        root.addView(
                text("Virtual order execution only")
        );

        root.addView(
                heading("Instrument")
        );

        root.addView(
                text(
                        selectedSymbol +
                        "\n₹" +
                        String.format("%.2f", selectedPrice)
                )
        );

        root.addView(
                heading("Quantity")
        );

        final EditText quantityInput =
                new EditText(this);

        quantityInput.setHint("Enter quantity");
        quantityInput.setText("1");
        quantityInput.setInputType(
                android.text.InputType.TYPE_CLASS_NUMBER
        );

        root.addView(
                quantityInput,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );

        addSpace(10);

        Button buy =
                actionButton("🟢 BUY");

        buy.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int qty;

                        try {
                            qty = Integer.parseInt(
                                    quantityInput
                                            .getText()
                                            .toString()
                            );
                        } catch (Exception e) {
                            toast("Enter valid quantity");
                            return;
                        }

                        if (qty <= 0) {
                            toast("Quantity must be greater than 0");
                            return;
                        }

                        double amount =
                                selectedPrice * qty;

                        if (amount > balance) {
                            toast("Insufficient virtual balance");
                            return;
                        }

                        quantity = qty;
                        balance -= amount;

                        diary.add(
                                "BUY | " +
                                selectedSymbol +
                                " | Qty: " +
                                qty +
                                " | Price: ₹" +
                                String.format("%.2f", selectedPrice)
                        );

                        toast(
                                "BUY order executed virtually"
                        );

                        showVirtualTrading();
                    }
                }
        );

        Button sell =
                actionButton("🔴 SELL");

        sell.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int qty;

                        try {
                            qty = Integer.parseInt(
                                    quantityInput
                                            .getText()
                                            .toString()
                            );
                        } catch (Exception e) {
                            toast("Enter valid quantity");
                            return;
                        }

                        if (qty <= 0) {
                            toast("Quantity must be greater than 0");
                            return;
                        }

                        double amount =
                                selectedPrice * qty;

                        balance += amount;

                        diary.add(
                                "SELL | " +
                                selectedSymbol +
                                " | Qty: " +
                                qty +
                                " | Price: ₹" +
                                String.format("%.2f", selectedPrice)
                        );

                        toast(
                                "SELL order executed virtually"
                        );

                        showVirtualTrading();
                    }
                }
        );

        addBackButton();
    }

    // ============================================================
    // WATCHLIST
    // ============================================================

    private void showWatchlist() {

        createRoot();

        root.addView(title("Watchlist"));

        root.addView(
                text("Your selected market instruments")
        );

        addWatchItem(
                "NIFTY 50",
                "24,500.00"
        );

        addWatchItem(
                "BANK NIFTY",
                "55,000.00"
        );

        addWatchItem(
                "SENSEX",
                "80,000.00"
        );

        addWatchItem(
                "FINNIFTY",
                "26,000.00"
        );

        addWatchItem(
                "MIDCAP SELECT",
                "13,500.00"
        );

        addBackButton();
    }

    private void addWatchItem(
            final String symbol,
            final String price
    ) {

        Button button =
                actionButton(
                        "⭐ " +
                        symbol +
                        "\n₹" +
                        price
                );

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        selectedSymbol = symbol;

                        try {
                            selectedPrice =
                                    Double.parseDouble(
                                            price.replace(",", "")
                                    );
                        } catch (Exception e) {
                            selectedPrice = 0;
                        }

                        toast(
                                symbol +
                                " selected"
                        );
                    }
                }
        );
    }

    // ============================================================
    // TRADING DIARY
    // ============================================================

    private void showDiary() {

        createRoot();

        root.addView(title("Trading Diary"));

        if (diary.size() == 0) {

            root.addView(
                    text(
                            "No virtual trades yet.\n\n" +
                            "Your BUY and SELL orders will appear here."
                    )
            );

        } else {

            root.addView(
                    text(
                            "Total recorded trades: " +
                            diary.size()
                    )
            );

            for (String trade : diary) {

                TextView item =
                        text("• " + trade);

                item.setPadding(
                        5,
                        15,
                        5,
                        15
                );

                root.addView(item);
            }
        }

        addBackButton();
    }

    // ============================================================
    // PROFILE
    // ============================================================

    private void showProfile() {

        createRoot();

        root.addView(title("Profile"));

        root.addView(
                heading("AbhiBoT User")
        );

        root.addView(
                text(
                        "Account Type: Virtual Trading"
                )
        );

        root.addView(
                text(
                        "Trading Mode: PAPER"
                )
        );

        root.addView(
                text(
                        "Starting Balance: ₹1,00,000"
                )
        );

        root.addView(
                text(
                        "Current Balance: ₹" +
                        String.format("%.2f", balance)
                )
        );

        addSpace(15);

        Button reset =
                actionButton("Reset Virtual Account");

        reset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        balance = 100000;
                        diary.clear();

                        toast(
                                "Virtual account reset"
                        );

                        showProfile();
                    }
                }
        );

        addBackButton();
    }

    // ============================================================
    // SETTINGS
    // ============================================================

    private void showSettings() {

        createRoot();

        root.addView(title("Settings"));

        root.addView(
                heading("Trading Mode")
        );

        root.addView(
                text(
                        "Current: VIRTUAL / PAPER TRADING"
                )
        );

        Button broker =
                actionButton(
                        "🔌 Broker API Configuration"
                );

        broker.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        toast(
                                "Broker API will be added in a future update"
                        );
                    }
                }
        );

        Button alerts =
                actionButton(
                        "🔔 Alerts & Notifications"
                );

        alerts.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public v
