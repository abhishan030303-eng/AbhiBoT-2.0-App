# AbhiBoT 2.0

Android starter project for a live-market/paper-trading application.

## Included
- AbhiBoT 2.0 application icon supplied for this project
- Android app shell (Java)
- Live-data connection screen
- DhanHQ WebSocket v2 starter connection
- Watchlist
- Option Chain screen placeholder
- Paper-trade starter
- Pine-style Indicator Lab for saving indicator text locally
- GitHub Actions workflow that builds a debug APK

## Important
Broker credentials are entered at runtime and are not hard-coded.
Pine Script is not executed directly inside Android in this starter.
The indicator engine will be added as a staged Pine-compatible subset.

## GitHub APK build
Push to `main`, or open GitHub Actions and run the workflow manually.
The resulting debug APK is uploaded as `AbhiBoT-2.0-APK`.

## Roadmap
1. Real-time instrument master + multi-symbol subscriptions
2. Candlestick charts and timeframes
3. NIFTY/BANKNIFTY/SENSEX/FINNIFTY option chain
4. Indicator engine + Pine-compatible subset
5. Broker adapters
6. Paper trading, orders, positions, P&L and trade diary
7. Release signing and Play Store-ready APK/AAB
