
// 🧩 Problem
// Design a Logger class with one method:
// shouldPrintMessage(int timestamp, String message) → boolean
// Rule: A message can only be printed if it was not printed in the last 10 seconds.
// Timestamps arrive in non-decreasing (chronological) order.
// Example:
// shouldPrintMessage(1,  "foo") → true   (first time)
// shouldPrintMessage(2,  "bar") → true   (first time)
// shouldPrintMessage(3,  "foo") → false  (3 < 1+10 = 11)
// shouldPrintMessage(8,  "bar") → false  (8 < 2+10 = 12)
// shouldPrintMessage(10, "foo") → false  (10 < 11)
// shouldPrintMessage(11, "foo") → true   (11 >= 11 ✅)

class Logger {
    private Map<String, Integer> nextAllowed;

    public Logger() {
        nextAllowed = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < nextAllowed.getOrDefault(message, 0)) {
            return false;
        }
        nextAllowed.put(message, timestamp + 10);
        return true;
    }
}