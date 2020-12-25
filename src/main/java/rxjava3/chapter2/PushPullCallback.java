package rxjava3.chapter2;

interface PushPullCallback {
  void pushData(String data);
  void pushCompleted();
  void pushError(Exception exception);
}
