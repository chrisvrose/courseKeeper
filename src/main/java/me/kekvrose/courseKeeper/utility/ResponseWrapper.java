package me.kekvrose.courseKeeper.utility;

public class ResponseWrapper<T> {
    public boolean ok;
    public T response;
    public ResponseWrapper() {
    }
    public ResponseWrapper(boolean status, T response) {
        this.ok = status;
        this.response = response;
    }
    public ResponseWrapper(T response) {
        ok=true;
        this.response = response;
    }
    
}
